"""Turn published recipe portions into lunch and dinner plates with measured sides."""
from copy import deepcopy


# USDA SR28, edible weight per 100 g. For rice and chickpeas use cooked weights.
SIDES = {
    "avocado": (
        "Мякоть авокадо", "Avocado flesh", "09", 9037,
        (160, 2.0, 14.66, 2.126, 8.53, 6.7, 0.66, 7),
    ),
    "rice": (
        "Отварной длиннозёрный рис без добавок", "Plain cooked long-grain rice", "20", 20045,
        (130, 2.69, 0.28, 0.077, 28.17, 0.4, 0.05, 1),
    ),
    "chickpeas": (
        "Отварной нут без соли и жидкости", "Cooked unsalted chickpeas, drained", "16", 16057,
        (164, 8.86, 2.59, 0.269, 27.42, 7.6, 4.8, 7),
    ),
}
NUTRIENTS = (
    "energyKcal", "proteinGrams", "fatGrams", "saturatedFatGrams",
    "carbohydrateGrams", "fiberGrams", "sugarGrams", "sodiumMilligrams",
)
MAIN_MEALS = {"LUNCH", "DINNER"}
READY_SIDE_NOTES = {
    "rice": ("Взвесьте готовый рис. Время его варки не включено.",
             "Weigh the cooked rice. The recipe time excludes cooking it."),
    "chickpeas": ("Используйте уже готовый нут.", "Use ready-to-eat chickpeas."),
}

PORTIONS = [
    ("oven-baked-salmon", "salmon-with-avocado", 2, {"avocado": 125}, 357,
     "Запечённый лосось с авокадо", "Baked salmon with avocado",
     "2 куска лосося и 125 г авокадо", "2 pieces of salmon and 125 g avocado"),
    ("baked-tilapia-with-tomatoes", "tilapia-with-tomatoes-and-avocado", 1, {"avocado": 150}, None,
     "Тилапия с помидорами и авокадо", "Tilapia with tomatoes and avocado",
     "1 филе с помидорами и 150 г авокадо", "1 fillet with tomatoes and 150 g avocado"),
    ("black-bean-soup", "black-bean-soup-with-rice-and-avocado", 1, {"rice": 200, "avocado": 80}, 535,
     "Суп из чёрной фасоли с рисом и авокадо", "Black bean soup with rice and avocado",
     "255 г супа, 200 г риса и 80 г авокадо", "255 g soup, 200 g rice and 80 g avocado"),
    ("vegetarian-chili", "vegetarian-chili-with-rice-and-avocado", 1, {"rice": 180, "avocado": 70}, 486,
     "Овощной чили с рисом и авокадо", "Vegetarian chili with rice and avocado",
     "236 г чили, 180 г риса и 70 г авокадо", "236 g chili, 180 g rice and 70 g avocado"),
    ("chicken-and-rice", "chicken-rice-bowl-with-chickpeas", 1, {"chickpeas": 150, "avocado": 40}, None,
     "Курица с рисом, нутом и авокадо", "Chicken and rice with chickpeas and avocado",
     "1 кусок курицы, 1 чашка риса с овощами, 150 г нута и 40 г авокадо",
     "1 piece of chicken, 1 cup of rice with vegetables, 150 g chickpeas and 40 g avocado"),
    ("pasta-caprese", "pasta-caprese-with-chickpeas", 1, {"chickpeas": 100}, None,
     "Паста капрезе с нутом", "Pasta Caprese with chickpeas",
     "¼ готовой пасты и 100 г нута", "¼ of the cooked pasta and 100 g chickpeas"),
    ("indian-lentils-and-pasta", "lentils-orzo-with-chickpeas", 1, {"chickpeas": 100}, 604,
     "Орзо с чечевицей и нутом", "Orzo with lentils and chickpeas",
     "504 г орзо с чечевицей и 100 г нута", "504 g lentils and orzo and 100 g chickpeas"),
    ("kale-and-white-bean-soup", "white-bean-soup-with-chickpea-salad", 1,
     {"chickpeas": 160, "avocado": 80}, 481,
     "Суп с белой фасолью и салатом из нута", "White bean soup with chickpea salad",
     "241 г супа, 160 г нута и 80 г авокадо", "241 g soup, 160 g chickpeas and 80 g avocado"),
    ("tofu-scramble", "tofu-scramble-with-chickpeas", 1, {"chickpeas": 170, "avocado": 60}, 436,
     "Тофу со шпинатом, нутом и авокадо", "Tofu scramble with chickpeas and avocado",
     "206 г тофу со шпинатом, 170 г нута и 60 г авокадо",
     "206 g tofu scramble, 170 g chickpeas and 60 g avocado"),
]


def side_url(side):
    group = SIDES[side][2]
    return f"https://www.ars.usda.gov/ARSUserFiles/80400535/Data/SR/SR28/reports/sr28fg{group}.pdf"


def make_main_portions(recipes):
    by_id = {r["recipe"]["id"]: r for r in recipes}
    meals = []
    for base_id, slug, factor, sides, grams, name_ru, name_en, portion_ru, portion_en in PORTIONS:
        base = by_id[base_id]
        meal = deepcopy(base)
        batch_servings, remainder = divmod(base["serving"]["batchServings"], factor)
        assert not remainder, slug

        nutrition = meal["nutrition"]
        for index, field in enumerate(NUTRIENTS):
            if nutrition[field] is not None:
                total = nutrition[field] * factor + sum(SIDES[key][4][index] * g / 100 for key, g in sides.items())
                nutrition[field] = round(total) if field == "energyKcal" else round(total, 2)
        nutrition["basis"] = "PUBLISHED_BASE_PORTION_PLUS_USDA_SIDES"
        has_precooked_side = "rice" in sides or "chickpeas" in sides
        meal["recipe"].update(
            id=slug, nameRu=name_ru, nameEn=name_en,
            descriptionRu=f"На одну порцию: {portion_ru}.",
            descriptionEn=f"Per serving: {portion_en}.",
            caloriesPerServing=nutrition["energyKcal"],
            totalTimeMinutes=base["recipe"]["totalTimeMinutes"] + 5,
        )
        meal["mealTypes"] = ["LUNCH", "DINNER"]
        meal["dietaryPreferences"] = [
            diet for diet in base["dietaryPreferences"]
            if not has_precooked_side or diet not in {"KETO", "PALEO"}
        ]
        meal["serving"].update(
            batchServings=batch_servings,
            sourceServingsPerPortion=base["serving"]["sourceServingsPerPortion"] * factor,
            descriptionRu=portion_ru + (f" (всего около {grams} г)" if grams else ""),
            descriptionEn=portion_en + (f" (about {grams} g total)" if grams else ""),
            approximateWeightGrams=grams,
        )
        for group in ("ingredients", "steps"):
            for item in meal[group]:
                item["recipeId"] = slug
        for key, weight in sides.items():
            ru, en, _, _, _ = SIDES[key]
            note_ru, note_en = READY_SIDE_NOTES.get(key, (None, None))
            meal["ingredients"].append(dict(
                recipeId=slug, position=len(meal["ingredients"]),
                nameIngredientsRu=ru, nameIngredientsEn=en,
                amount=weight * batch_servings, ingredientUnit="GRAM",
                noteRu=note_ru, noteEn=note_en,
                sourceLocation="SERVING_ADDITION",
            ))

        meal["steps"].append(dict(
            recipeId=slug, position=len(meal["steps"]),
            textRu=f"Разложите готовое блюдо по тарелкам. На каждую порцию отмерьте: {portion_ru}.",
            textEn=f"Plate the dish. For each serving, measure: {portion_en}.",
        ))
        meal["mealComposition"] = {
            "baseRecipeId": base_id,
            "baseDisplayedServings": factor,
            "baseEnergyKcal": base["recipe"]["caloriesPerServing"] * factor,
            "sides": [
                {"food": key, "gramsPerPortion": g, "kcalPer100g": SIDES[key][4][0],
                 "usdaNdbNumber": SIDES[key][3], "sourceUrl": side_url(key)}
                for key, g in sides.items()
            ],
        }
        # Ready-to-eat chickpeas can be drained and plated within the extra five minutes.
        # Rice is listed by cooked weight but its preparation time is not included.
        meal["review"]["completeTimeSuitableForFiltering"] &= "rice" not in sides
        meal["warningsRu"].append("Калорийность рассчитана на указанную порцию с гарниром.")
        meal["warningsEn"].append("Calories include the stated serving and sides.")
        if has_precooked_side:
            meal["warningsRu"].append("Время указано с готовым гарниром. Если варите его с нуля, потребуется дополнительное время.")
            meal["warningsEn"].append("Time assumes the side is already cooked. Cooking it from scratch takes extra time.")
        meals.append(meal)

    # Keep the published versions readable in menus saved with older catalogs.
    for base_id, *_ in PORTIONS:
        base = by_id[base_id]
        base["mealTypes"] = [meal_type for meal_type in base["mealTypes"] if meal_type not in MAIN_MEALS]
    return meals
