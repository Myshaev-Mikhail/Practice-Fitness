"""Build a bilingual seed catalog from captured primary-source facts.

No network access. Source quantities are for the complete batch, while nutrition
is per displayed serving. Keep the original measure and document approximations.
"""
from fractions import Fraction
import hashlib
import json
from pathlib import Path
import re

from curated import RECIPES, EXCLUDED
from main_dishes import MAIN_DISHES, MAIN_DISH_SOURCES
from meal_portions import make_main_portions, side_url
from review_sources import Document, extract
from steps_en import STEPS

ROOT = Path(__file__).resolve().parents[2]
OUT = ROOT / "app/src/main/assets/recipe_catalog"
DOCS = ROOT / "docs/recipe_catalog"
CACHE = Path("/tmp/practice-fitness-recipe-sources")
CHECKED = "2026-09-11"
CUP_ML = 236.5882365
OUNCE_G = 28.349523125
WEIGHT_REFERENCE = "https://www.kingarthurbaking.com/learn/ingredient-weight-chart"
SNACK_ADDITIONS = {"hummus-with-tahini", "quick-black-bean-dip"}

# Published weights vary by product and how the cup is filled.
GRAMS_PER_CUP = {
    "whole-wheat flour": 113,
    "quick-cooking oats": 89,
    "old fashioned rolled oats": 89,
    "oats (quick or old-fashioned)": 89,
    "bulgur, uncooked": 152,
    "raisins": 149,
    "peanut butter": 270,
    "onion, chopped": 142,
    "chopped onion": 142,
    "diced onion": 142,
    "unsalted pecans, chopped": 114,
    "sliced mushrooms": 78,
    "rice": 198,  # Dry long-grain rice, the reference used for the unspecified rice.
}
LIQUID_CUP_NAMES = (
    "water", "cold water", "milk", "fat-free (skim) milk", "vanilla soy milk",
    "orange juice", "pineapple juice", "lime juice", "low-sodium broth",
)

# Select one of the source's alternatives, keeping the reported source nutrition
# explicitly approximate. These selections also apply to the English display.
EN_NAMES = {
    ("veggie-omelet-in-a-mug", 5): "Grated cheese made with vegetarian rennet",
    ("overnight-oats-for-one", 0): "Certified gluten-free old-fashioned rolled oats",
    ("baked-berry-oatmeal", 0): "Certified gluten-free old-fashioned rolled oats",
    ("baked-berry-oatmeal", 1): "Gluten-free baking powder",
    ("tofu-scramble", 5): "Garlic powder",
    ("tofu-scramble", 8): "Cheddar cheese made with vegetarian rennet",
    ("oven-baked-salmon", 0): "Olive oil, selected from the permitted vegetable oils",
    ("oven-baked-salmon", 1): "Fresh or already thawed salmon",
    ("skillet-braised-chicken", 1): "Olive oil, selected from the permitted oils",
    ("black-bean-soup", 2): "Garlic cloves, minced",
    ("blueberry-tofu-smoothie", 4): "Orange juice, measured by volume",
    ("black-bean-soup", 4): "Cooked black beans with their liquid; measure four US cups",
    ("black-bean-soup", 9): "Lime juice; use the measured volume, not one fruit",
    ("kale-and-white-bean-soup", 1): "Garlic cloves, minced",
    ("kale-and-white-bean-soup", 2): "Butter or margarine; dairy is conservatively included as an allergen",
    ("kale-and-white-bean-soup", 3): "Gluten-free low-sodium vegetable broth",
    ("kale-and-white-bean-soup", 4): "Cooked white beans, rinsed and drained",
    ("kale-and-white-bean-soup", 5): "Diced tomatoes with their juice",
    ("vegetarian-chili", 1): "Garlic cloves, minced",
    ("vegetarian-chili", 14): "Grated cheddar cheese made with vegetarian rennet",
    ("pasta-caprese", 0): "Egg-free whole-wheat thin spaghetti",
    ("pasta-caprese", 4): "Part-skim mozzarella made with vegetarian rennet, cubed",
    ("salmon-pasta-skillet", 0): "Dry egg-free whole-grain pasta",
    ("salmon-pasta-skillet", 1): "Butter or margarine; dairy is conservatively included as an allergen",
    ("salmon-pasta-skillet", 6): "Fresh parsley, chopped",
    ("baked-tilapia-with-tomatoes", 0): "Olive oil cooking spray",
    ("hummus-with-tahini", 4): "Garlic clove",
    ("quick-black-bean-dip", 4): "Garlic clove, minced",
    ("peanut-power-smoothie", 1): "Banana, measured by volume",
    ("banana-oatmeal-cookies", 1): "Certified gluten-free oats, quick or old-fashioned",
    ("perfect-hard-cooked-eggs", 0): "Egg, one source serving",
    ("baked-tomatoes-with-cheese", 1): "Grated cheese made with vegetarian rennet",
    ("baked-tomatoes-with-cheese", 4): "Garlic powder",
    ("chicken-and-black-bean-salsa-burritos", 8): "Shredded cheddar",
    ("indian-lentils-and-pasta", 9): "Egg-free orzo or small pasta",
}

SERVING_RU = {
    "veggie-omelet-in-a-mug": "1 омлет (169 г)",
    "blueberry-tofu-smoothie": "1 чашка (170 г); объём приблизительный",
    "oatmeal-pecan-waffles-or-pancakes": "3 небольшие вафли (около 5 см) или 1 большая (около 15 см) с ягодами; четверть выхода",
    "overnight-oats-for-one": "1 чашка (281 г)",
    "baked-berry-oatmeal": "1 чашка (189 г)",
    "tofu-scramble": "1 чашка (206 г)",
    "green-pineapple-power-smoothie": "1 чашка (166 г)",
    "oven-baked-salmon": "1 порция (116 г); четверть выхода",
    "skillet-braised-chicken": "половина грудки (50 г в таблице источника)",
    "vegetarian-cowboy-salad": "половина чашки (119 г)",
    "black-bean-soup": "1 чашка (255 г)",
    "kale-and-white-bean-soup": "1 чашка (241 г)",
    "vegetarian-chili": "1 чашка (236 г)",
    "pasta-caprese": "2¼ чашки пасты; четверть выхода",
    "salmon-pasta-skillet": "половина чашки (157 г в таблице источника; требует уточнения)",
    "chicken-and-rice": "1 чашка риса и 1 кусок курицы",
    "baked-tilapia-with-tomatoes": "1 филе с томатной смесью",
    "hummus-with-tahini": "2 столовые ложки (27 г)",
    "quick-black-bean-dip": "2 столовые ложки (33 г)",
    "peanut-power-smoothie": "1 чашка (175 г)",
    "melon-and-mint": "¾ чашки (127 г)",
    "banana-oatmeal-cookies": "2 печенья (58 г)",
    "perfect-hard-cooked-eggs": "1 яйцо (50 г)",
    "baked-tomatoes-with-cheese": "2 ломтика (99 г)",
}
SERVING_EN = {
    "oatmeal-pecan-waffles-or-pancakes": "3 small waffles (about 5 cm each) or 1 large waffle (about 15 cm) with berries; ¼ of the batch",
}


def save(path, value):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")


def capture_sources():
    path = DOCS / "source_facts.json"
    if path.exists():
        return json.loads(path.read_text())
    records = {}
    for page in sorted(CACHE.glob("*.html")):
        slug = page.stem
        root = Document(page.read_text()).root
        record = extract(page)
        record.update({
            "url": f"https://medlineplus.gov/recipes/{slug}/", "checkedOn": CHECKED,
            "htmlSha256": hashlib.sha256(page.read_bytes()).hexdigest(),
            "title": root.find("h1")[0].text(),
            "publisher": "MedlinePlus, National Library of Medicine",
            "origin": "NHLBI" if root.find(cls="alsocalled") else "Food Hero / Oregon State University Extension",
        })
        ld_path = page.with_suffix(".json")
        if ld_path.exists():
            record["jsonLdForComparisonOnly"] = json.loads(ld_path.read_text()).get("recipe")
        records[slug] = record
    save(path, records)
    return records


def quantity(text):
    return float(sum((Fraction(x) for x in text.replace(" and ", " ").split()), Fraction()))


def ingredient(slug, position, en, ru):
    amount, unit = None, None
    name = en
    weight_reference = None
    notes_ru, notes_en = [], []
    match = re.match(r"^(\d+(?:\s+and)?\s+\d+/\d+|\d+/\d+|\d+(?:\.\d+)?)\s+(.*)$", en)
    if match:
        number, rest = quantity(match[1]), match[2]
        unit_match = re.match(r"^(cups?|Tablespoons?|Tbsp|tablespoons?|teaspoons?|tsp|ounces?|oz|pounds?)\s+(.*)$", rest)
        can_match = re.match(r"^cans?\s+\(([\d.]+) ounces\)\s+(.*)$", rest)
        if unit_match:
            measure, name = unit_match.groups()
            if measure.lower().startswith("cup"):
                product = name.lower()
                if product in GRAMS_PER_CUP:
                    amount, unit = round(number * GRAMS_PER_CUP[product]), "GRAM"
                    weight_reference = WEIGHT_REFERENCE
                    if product == "rice":
                        notes_ru.append(f"Примерный вес для длиннозёрного риса. Исходная мера — {match[1]} мерн. чаш.")
                        notes_en.append(f"Approximate weight for long-grain rice. Source measure: {match[1]} US cup(s).")
                    else:
                        notes_ru.append(f"Примерный вес. Исходная мера — {match[1]} мерн. чаш.")
                        notes_en.append(f"Approximate weight. Source measure: {match[1]} US cup(s).")
                elif product.startswith(LIQUID_CUP_NAMES):
                    amount, unit = round(number * CUP_ML, 2), "MILLILITER"
                else:
                    amount, unit = round(number, 4), "CUP"
            elif measure.lower() in {"oz", "ounce", "ounces"}:
                amount, unit = round(number * OUNCE_G, 2), "GRAM"
            elif measure.lower().startswith("pound"):
                amount, unit = round(number * 16 * OUNCE_G), "GRAM"
            else:
                amount = number
                unit = "TABLESPOON" if measure.lower().startswith(("tablespoon", "tbsp")) else "TEASPOON"
        elif can_match:
            weight, name = can_match.groups()
            amount, unit = round(number * float(weight) * OUNCE_G, 2), "GRAM"
            if "drained" in name:
                notes_ru.append("Вес содержимого банки до слива жидкости.")
                notes_en.append("Net weight before draining.")
            else:
                notes_ru.append("Вес содержимого банки.")
                notes_en.append("Net weight of the can contents.")
        elif rest.startswith("jar (24 to 26 ounces)"):
            name = "Tomato-based pasta sauce"
            notes_ru.append("1 банка, 680–737 г.")
            notes_en.append("1 jar, 680–737 g.")
        elif rest.startswith("to "):
            notes_ru.append("340–454 г на весь рецепт.")
            notes_en.append("340–454 g for the whole recipe.")
        elif rest.startswith("dash"):
            name = rest.removeprefix("dash ")
            notes_ru.append("1 щепотка.")
            notes_en.append("1 dash.")
        elif rest.startswith("bunch"):
            name = rest.removeprefix("bunch ")
            notes_ru.append("Один пучок; для зелёного лука в источнике указано пять стеблей." if "green onions" in rest else "Один пучок; точная масса не задана.")
            notes_en.append("One bunch (five green onions)." if "green onions" in rest else "One bunch; no exact weight specified.")
        else:
            countable = {"egg", "eggs", "banana", "bananas", "onion", "cloves", "clove", "tomato", "tomatoes",
                         "potatoes", "pepper", "olives", "tilapia", "chicken", "avocado", "carrot",
                         "onions", "zucchini", "tortillas"}
            if not countable & set(rest.lower().replace(",", "").split()[:5]):
                raise ValueError(f"Unreviewed count unit: {slug}: {en}")
            amount = number
            unit = "CLOVE" if rest.startswith(("clove ", "cloves ")) else "PIECE"
            name = re.sub(r"^cloves? (?:of )?", "", rest) if unit == "CLOVE" else rest
    elif slug == "perfect-hard-cooked-eggs":
        amount, unit = 1, "PIECE"
        notes_ru.append("Количество уточнено по таблице: одна порция — одно яйцо.")
        notes_en.append("Quantity fixed from the nutrition table: one serving is one egg.")
    elif en.startswith("dash "):
        notes_ru.append("1 щепотка.")
        notes_en.append("1 dash.")
    else:
        notes_ru.append("По вкусу или по необходимости.")
        notes_en.append("To taste or as needed.")
    if "each salt and pepper" in en:
        notes_ru.append("Указанное количество каждого: отдельно соли и отдельно перца.")
        notes_en.append("The stated quantity of EACH: salt and pepper separately.")
    if "optional" in en:
        notes_ru.append("Необязательно.")
        notes_en.append("Optional.")
    if (slug, position) in {("baked-tilapia-with-tomatoes", 1), ("chicken-and-rice", 0),
                            ("chicken-and-black-bean-salsa-burritos", 5)}:
        notes_ru.append("Масса одного куска не указана.")
        notes_en.append("Weight per piece is unspecified.")
    return {
        "recipeId": slug, "position": position,
        "nameIngredientsRu": ru, "nameIngredientsEn": EN_NAMES.get((slug, position), name),
        "amount": amount, "ingredientUnit": unit,
        "noteRu": " ".join(notes_ru) or None, "noteEn": " ".join(notes_en) or None,
        "sourceTextEn": en,
        **({"weightReferenceUrl": weight_reference} if weight_reference else {}),
    }


def minutes(text):
    return sum(int(n) * (60 if unit.startswith("hour") else 1)
               for n, unit in re.findall(r"(\d+)\s+(hours?|minutes?)", text))


def number_from_fact(facts, label):
    for line in facts:
        m = re.match(re.escape(label) + r"\s+(\d+(?:\.\d+)?)", line)
        if m:
            return float(m[1])
    return None


def recipe(curated, source, image_path):
    slug = curated["slug"]
    assert len(source["ingredients"]) == len(curated["names"]), slug
    steps_en = curated["steps_en"] if "steps_en" in curated else STEPS[slug]
    assert len(curated["steps"]) == len(steps_en), slug
    facts = source["facts"]
    servings = int(re.search(r"Number of Servings:\s*(\d+)", source["timing"])[1])
    total_text = source["timing"].split("Total time:", 1)[1].split("Number of Servings:", 1)[0].strip()
    total = curated.get("total", minutes(total_text))
    serving_en = next(x.removeprefix("Serving size ") for x in facts if x.startswith("Serving size"))
    multiplier = curated.get("serving_multiple", 1)
    assert servings % multiplier == 0, slug
    portion_ru, portion_en = curated.get("serving") or (SERVING_RU[slug], SERVING_EN.get(slug, serving_en))

    def nutrition_value(label):
        value = number_from_fact(facts, label)
        return None if value is None else value * multiplier

    warning_ru = [
        "Ингредиенты и шаги рассчитаны на весь выход; калорийность — на одну указанную порцию.",
        "Калорийность рассчитана по данным источника и зависит от продуктов и фактического размера порции.",
        "Проверьте состав и предупреждения на упаковках. Отсутствие перекрёстного загрязнения аллергенами не проверено.",
        "Фото иллюстративное: состав, способ приготовления и гарнир могут отличаться. Следуйте списку ингредиентов.",
    ]
    warning_en = [
        "Ingredients and instructions are for the complete batch; nutrition is for one stated serving.",
        "Nutrition is based on the published estimate and varies with ingredients and portion size.",
        "Check package ingredients and warnings. Allergen cross-contact has not been verified.",
        "Representative photo: ingredients, cooking method and sides may differ. Follow the ingredient list.",
    ]
    if multiplier > 1:
        warning_ru.append(f"Порция в приложении соответствует {multiplier} порциям из таблицы источника.")
        warning_en.append(f"One serving in the app is equal to {multiplier} published servings.")
    if "GLUTEN_FREE" in curated["diets"]:
        warning_ru.append("Для безглютенового варианта используйте продукты с подходящей маркировкой, особенно овёс, приправы, соусы и бульон.")
        warning_en.append("For the gluten-free variant use appropriately labelled ingredients, especially oats, seasoning, sauces and broth.")
    if "VEGETARIAN" in curated["diets"] and "DAIRY" in curated["allergens"]:
        warning_ru.append("Сыр должен быть с вегетарианским ферментом, без животного сычуга; йогурт — без желатина.")
        warning_en.append("Use cheese made with vegetarian rennet, not animal rennet, and yogurt without gelatin.")
    if "KETO" in curated["diets"]:
        warning_ru.append("Метка keto — предварительная оценка состава одной порции, не гарантия кетогенного рациона за день.")
        warning_en.append("The keto tag is a preliminary ingredient/serving assessment, not a guarantee of a ketogenic daily plan.")
    if not curated["time_ok"]:
        warning_ru.append("Полное время с разморозкой или охлаждением не установлено. Не использовать при ограничении 15 или 30 минут.")
        warning_en.append("Complete time including thawing or cooling is unknown. Exclude from 15- and 30-minute filters.")
    if slug == "overnight-oats-for-one":
        warning_ru.append("Для полного времени консервативно учтены 15 минут подготовки и 12 часов ожидания: 735 минут. В заголовке источника подготовка не прибавлена.")
        warning_en.append("Conservative complete time includes 15 minutes prep plus 12 hours waiting: 735 minutes. The source total omits the extra prep time.")
    ingredients = [ingredient(slug, i, en, ru) for i, (en, ru) in enumerate(zip(source["ingredients"], curated["names"]))]
    extras = []
    if slug in {"veggie-omelet-in-a-mug", "banana-oatmeal-cookies"}:
        extras.append(("Растительное масло для смазывания посуды", "Vegetable oil for greasing the dish",
                       "По необходимости; упомянуто в инструкции источника, без количества.",
                       "As needed; mentioned in the source instructions without an amount.", None, None))
    if slug == "pasta-caprese":
        extras.append(("Вода для варки", "Cooking water", "Часть воды оставьте для соуса.",
                       "Reserve some of the water for the sauce.", 2800, "MILLILITER"))
    if slug == "perfect-hard-cooked-eggs":
        extras.append(("Вода для варки", "Cooking water", "Налейте на 2,5 см выше яйца.",
                       "Cover the egg by at least 2.5 cm.", None, None))
    if slug == "cheesy-beef-pasta":
        extras.append(("Вода для варки", "Cooking water", "По инструкции на упаковке пасты.",
                       "Follow the pasta package directions.", None, None))
    if slug == "hummus-with-tahini":
        extras.append(("Дополнительная вода", "Extra water", "Добавьте, если хумус слишком густой.",
                       "Add if the hummus is too thick.", 2, "TEASPOON"))
    if slug == "quick-black-bean-dip":
        for ru, en in [("Вода", "Water"), ("Соль", "Salt"), ("Чёрный перец", "Black pepper")]:
            extras.append((ru, en, "По вкусу или необходимости, как указано в инструкции источника.",
                           "To taste or as needed, as stated in the source instructions.", None, None))
    for ru, en, note_ru, note_en, amount, unit in extras:
        ingredients.append({"recipeId": slug, "position": len(ingredients), "nameIngredientsRu": ru,
                            "nameIngredientsEn": en, "amount": amount, "ingredientUnit": unit,
                            "noteRu": note_ru, "noteEn": note_en, "sourceLocation": "DIRECTIONS"})
    titles = {"oatmeal-pecan-waffles-or-pancakes": "Oatmeal Pecan Waffles with Berries",
              "tofu-scramble": "Tofu with Spinach and Cheese", "perfect-hard-cooked-eggs": "Hard-Boiled Egg"}
    return {
        "recipe": {
            "id": slug, "nameRu": curated["name"], "nameEn": titles.get(slug, source["title"]),
            "descriptionRu": curated["description"], "descriptionEn": curated["en"],
            "imagePath": image_path,
            "caloriesPerServing": int(nutrition_value("Calories")),
            "totalTimeMinutes": total,
            "allergensVerified": False,
        },
        "ingredients": ingredients,
        "steps": [{"recipeId": slug, "position": i, "textRu": ru, "textEn": en}
                  for i, (ru, en) in enumerate(zip(curated["steps"], steps_en))],
        "mealTypes": curated["meals"], "dietaryPreferences": curated["diets"], "allergens": curated["allergens"],
        "additionalAllergens": curated["extra"],
        "snackAddition": slug in SNACK_ADDITIONS,
        "serving": {"batchServings": servings // multiplier, "ingredientsBasis": "FULL_SOURCE_BATCH",
                    "nutritionBasis": "ONE_DISPLAYED_SERVING",
                    "sourceServingsPerPortion": multiplier, "sourceBatchServings": servings,
                    "descriptionRu": portion_ru, "descriptionEn": portion_en,
                    "automaticPortionScalingAllowed": False},
        "nutrition": {
            "energyKcal": int(nutrition_value("Calories")),
            "proteinGrams": nutrition_value("Protein"),
            "fatGrams": nutrition_value("Total Fat"),
            "saturatedFatGrams": nutrition_value("Saturated Fat"),
            "carbohydrateGrams": nutrition_value("Total Carbohydrate"),
            "fiberGrams": nutrition_value("Dietary Fiber"),
            "sugarGrams": nutrition_value("Total Sugars"),
            "sodiumMilligrams": nutrition_value("Sodium"),
            "basis": "PUBLISHED_ESTIMATE_SCALED_TO_DISPLAYED_SERVING",
        },
        "source": {
            "url": source["url"], "title": source["title"], "publisher": source["publisher"], "origin": source["origin"],
            "checkedOn": source["checkedOn"],
            **({"htmlSha256": source["htmlSha256"]} if "htmlSha256" in source else {}),
            "contentRights": "Public-domain Healthy Recipes content per MedlinePlus policy; photographs licensed separately.",
            "rightsUrl": "https://medlineplus.gov/about/using/usingcontent/",
            "attribution": "Source: MedlinePlus, National Library of Medicine.",
            "originalAgencyAttribution": "Source: National Heart, Lung, and Blood Institute; National Institutes of Health; U.S. Department of Health and Human Services." if source["origin"] == "NHLBI" else "Food Hero, Oregon State University Extension Service, as published by MedlinePlus.",
            "translation": "Independent Russian translation and edited English instructions; not an official NIH translation or endorsement.",
            "sourceTimingText": source["timing"],
        },
        "review": {
            "status": "EDITORIALLY_REVIEWED_SEED" if curated["nutrition_ok"] else "QUARANTINED",
            "publishedFactsCompared": True, "ingredientAllergensReviewed": True,
            "nutritionSuitableForApproximateMatching": curated["nutrition_ok"],
            "completeTimeSuitableForFiltering": curated["time_ok"],
            "independentlyCookedOrLabTested": False, "clinicalReviewComplete": False,
            "productionImportAllowed": False, "issues": curated["issues"],
        },
        "warningsRu": warning_ru, "warningsEn": warning_en,
    }


def main():
    sources = {**capture_sources(), **MAIN_DISH_SOURCES}
    credits = json.loads((OUT / "image_credits.json").read_text())
    image_paths = {entry["recipeId"]: entry["assetPath"] for entry in credits}
    all_recipes = [recipe(r, sources[r["slug"]], image_paths[r["slug"]]) for r in RECIPES + MAIN_DISHES]
    all_recipes += make_main_portions(all_recipes)
    metadata = {
        "schemaVersion": 2, "catalogVersion": "2026-11-11.3", "languages": ["ru", "en"],
        "status": "REVIEWED_SEED_NOT_PRODUCTION_IMPORT", "checkedOn": CHECKED,
        "quantityPolicy": "Ingredients are full-batch quantities. Nutrition is per displayed serving. Original measures and serving factors are retained.",
        "imageCreditsPath": "recipe_catalog/image_credits.json",
        "allergensVerifiedPolicy": "False until the application's allergy vocabulary and importer can preserve all allergen and review metadata.",
    }
    reviewed = [r for r in all_recipes if r["review"]["status"] != "QUARANTINED"]
    quarantine = [r for r in all_recipes if r["review"]["status"] == "QUARANTINED"]
    save(OUT / "recipes.json", {**metadata, "recipes": reviewed})
    save(DOCS / "review_required.json", {**metadata, "recipes": quarantine, "excludedSources": EXCLUDED})
    lines = ["# Recipe and Photo Credits", "", "Source: MedlinePlus, National Library of Medicine.", "",
             "Recipe text, quantities and published nutrition: [MedlinePlus Healthy Recipes](https://medlineplus.gov/recipes/). "
             "See the [MedlinePlus content policy](https://medlineplus.gov/about/using/usingcontent/). "
             "Russian translations, edited English instructions, tags and warnings are independent editorial work, not an NIH endorsement.", "",
             "NHLBI-origin recipes: Source: National Heart, Lung, and Blood Institute; National Institutes of Health; U.S. Department of Health and Human Services.", "",
             "Food Hero-origin recipes: Food Hero, Oregon State University Extension Service, as published by MedlinePlus.", "",
             "Photographs are licensed separately. The recipe-text public-domain statement does not apply to them. "
             "All photos are representative, not photographs of these exact recipes. Some show ingredients or extra side dishes. "
             "Wikimedia-served thumbnails are used without editorial image changes. No endorsement by photographers is implied.", "",
             "Keep the photo title, author, source and linked license available to users. Preserve ShareAlike terms for adaptations "
             "of CC BY-SA images and do not impose additional restrictions on those images. "
             "See [Commons reuse guidance](https://commons.wikimedia.org/wiki/Commons:Reusing_content_outside_Wikimedia). "
             "No warranty of ownership, fitness or non-infringement is supplied by this catalog.", "", "## Recipes", ""]
    for r in all_recipes:
        lines.append(f'- {r["recipe"]["id"]}: [{r["source"]["title"]}](<{r["source"]["url"]}>)')
    lines.extend(["", "## Nutrition references for meal sides", "",
                  f'- [USDA SR28: avocado](<{side_url("avocado")}>)',
                  f'- [USDA SR28: cooked rice](<{side_url("rice")}>)',
                  f'- [USDA SR28: cooked chickpeas](<{side_url("chickpeas")}>)'])
    lines.extend(["", "## Photographs", ""])
    for c in credits:
        lines.append(f'- {c["recipeId"]}: [{c["title"][5:]}](<{c["sourceUrl"]}>), {c["author"]}. [{c["license"]}]({c["licenseUrl"]}).')
    lines.extend(["", "Checked against the source pages and Commons metadata on 2026-09-11.", ""])
    (OUT / "ATTRIBUTION.md").write_text("\n".join(lines), encoding="utf-8")
    print(f"Built {len(reviewed)} reviewed seed recipes and {len(quarantine)} quarantined recipes.")


if __name__ == "__main__":
    main()
