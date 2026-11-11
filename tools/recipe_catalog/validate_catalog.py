"""Offline integrity checks and explicit questionnaire coverage audit.

This checks data, not clinical safety. Coverage uses the displayed portions and
the same optional dip pairings as the menu generator.
"""
from collections import Counter
import hashlib
from itertools import combinations, product
import json
import math
from pathlib import Path
import re

from build_catalog import CUP_ML, ingredient, number_from_fact, save
from main_dishes import MAIN_DISH_SOURCES
from meal_portions import MAIN_MEALS, NUTRIENTS, SIDES, side_url

ROOT = Path(__file__).resolve().parents[2]
ASSETS = ROOT / "app/src/main/assets"
DOCS = ROOT / "docs/recipe_catalog"
MEALS = ["BREAKFAST", "LUNCH", "DINNER", "SNACKS"]
DIETS = ["VEGETARIAN", "VEGAN", "GLUTEN_FREE", "KETO", "PALEO"]
ALLERGIES = ["NUTS", "DAIRY", "SHELLFISH", "EGGS"]
TIMES = {"UNDER_15_MINUTES": 15, "UNDER_30_MINUTES": 30, "NO_LIMIT": None}
UNITS = {"MILLILITER", "GRAM", "PIECE", "TEASPOON", "TABLESPOON", "CUP", "CLOVE"}
DIP_PAIRINGS = {"perfect-hard-cooked-eggs", "baked-tomatoes-with-cheese"}


def read(path):
    return json.loads(path.read_text())


def powerset(values):
    return [tuple(c) for size in range(len(values) + 1) for c in combinations(values, size)]


def validate(recipes, quarantine, credits, sources):
    all_recipes = recipes + quarantine
    ids = [r["recipe"]["id"] for r in all_recipes]
    by_id = {r["recipe"]["id"]: r for r in all_recipes}
    assert len(ids) == len(set(ids)), "Duplicate recipe ids"
    original_recipes = [r for r in all_recipes if not r.get("mealComposition")]
    assert {r["recipe"]["id"] for r in original_recipes} == set(credits)
    assert not set(r["recipe"]["id"] for r in recipes) & set(r["recipe"]["id"] for r in quarantine)
    for full in all_recipes:
        r = full["recipe"]
        slug = r["id"]
        composition = full.get("mealComposition")
        source_id = composition["baseRecipeId"] if composition else slug
        source = sources[source_id]
        assert re.fullmatch(r"[a-z][a-z0-9-]+", slug), slug
        assert full["source"]["url"] == source["url"]
        assert r["caloriesPerServing"] == full["nutrition"]["energyKcal"] > 0
        assert isinstance(r["totalTimeMinutes"], int) and r["totalTimeMinutes"] > 0
        assert r["allergensVerified"] is False
        assert full["review"]["productionImportAllowed"] is False
        serving = full["serving"]
        multiple = serving["sourceServingsPerPortion"]
        assert serving["batchServings"] > 0 and multiple >= 1
        assert serving["batchServings"] * multiple == serving["sourceBatchServings"]
        assert serving["ingredientsBasis"] == "FULL_SOURCE_BATCH"
        assert serving["nutritionBasis"] == "ONE_DISPLAYED_SERVING"
        assert serving["descriptionRu"] and serving["descriptionEn"]
        for field, label in {
            "energyKcal": "Calories", "proteinGrams": "Protein", "fatGrams": "Total Fat",
            "saturatedFatGrams": "Saturated Fat", "carbohydrateGrams": "Total Carbohydrate",
            "fiberGrams": "Dietary Fiber", "sugarGrams": "Total Sugars", "sodiumMilligrams": "Sodium",
        }.items():
            source_value = number_from_fact(source["facts"], label)
            expected = None if source_value is None else source_value * multiple
            if composition and expected is not None:
                index = NUTRIENTS.index(field)
                expected += sum(SIDES[s["food"]][4][index] * s["gramsPerPortion"] / 100
                                for s in composition["sides"])
                expected = round(expected) if field == "energyKcal" else round(expected, 2)
            assert full["nutrition"][field] == expected, (slug, field)
        for field in ["nameRu", "nameEn", "descriptionRu", "descriptionEn"]:
            assert isinstance(r[field], str) and r[field].strip(), (slug, field)
        for group in ["ingredients", "steps"]:
            rows = full[group]
            assert rows and [x["position"] for x in rows] == list(range(len(rows))), slug
            assert all(x["recipeId"] == slug for x in rows), slug
        for row in full["ingredients"]:
            assert row["nameIngredientsRu"] and row["nameIngredientsEn"]
            assert (row["amount"] is None) == (row["ingredientUnit"] is None), (slug, row)
            if row["amount"] is not None:
                assert math.isfinite(row["amount"]) and row["amount"] > 0
                assert row["ingredientUnit"] in UNITS
            else:
                assert row["noteRu"] and row["noteEn"], (slug, row)
        assert [i["sourceTextEn"] for i in full["ingredients"] if "sourceTextEn" in i] == source["ingredients"]
        if composition:
            base = by_id[source_id]
            assert r["imagePath"] == base["recipe"]["imagePath"], slug
            assert composition["baseEnergyKcal"] == base["recipe"]["caloriesPerServing"] * composition["baseDisplayedServings"]
            sides = composition["sides"]
            additions = [i for i in full["ingredients"] if i.get("sourceLocation") == "SERVING_ADDITION"]
            assert len(additions) == len(sides)
            for side, item in zip(sides, additions):
                assert side["sourceUrl"] == side_url(side["food"])
                assert side["kcalPer100g"] == SIDES[side["food"]][4][0]
                assert item["ingredientUnit"] == "GRAM" and item["amount"] == side["gramsPerPortion"] * serving["batchServings"]
        for row in full["steps"]:
            assert re.search("[А-Яа-я]", row["textRu"]), slug
            assert re.search("[A-Za-z]", row["textEn"]), slug
        assert set(full["mealTypes"]) <= set(MEALS)
        if full["review"]["status"] != "QUARANTINED" and MAIN_MEALS & set(full["mealTypes"]):
            assert 500 <= r["caloriesPerServing"] <= 800, slug
        if full["snackAddition"]:
            assert full["mealTypes"] == ["SNACKS"], slug
        assert set(full["dietaryPreferences"]) <= set(DIETS)
        assert set(full["allergens"]) <= set(ALLERGIES)
        diets, allergens = set(full["dietaryPreferences"]), set(full["allergens"] + full["additionalAllergens"])
        if "VEGAN" in diets:
            assert "VEGETARIAN" in diets and not allergens & {"DAIRY", "EGGS", "FISH", "SHELLFISH"}, slug
        if "GLUTEN_FREE" in diets:
            assert "WHEAT" not in allergens, slug
        if "PALEO" in diets:
            assert not allergens & {"DAIRY", "WHEAT", "SOY", "PEANUT"}, slug
        if "KETO" in diets:
            n = full["nutrition"]
            assert n["carbohydrateGrams"] is not None and n["fiberGrams"] is not None
            assert n["carbohydrateGrams"] - n["fiberGrams"] <= 10, slug
        if "PEANUT" in allergens:
            assert "NUTS" in allergens, slug
        credit = credits[source_id]
        assert credit["assetPath"] == r["imagePath"]
        data = (ASSETS / r["imagePath"]).read_bytes()
        assert data.startswith(b"\xff\xd8\xff") and data.endswith(b"\xff\xd9"), slug
        assert hashlib.sha256(data).hexdigest() == credit["sha256"], slug
        assert len(data) == credit["bytes"]
        assert credit["author"] and credit["sourceUrl"].startswith("https://commons.wikimedia.org/wiki/File:")
        assert credit["licenseUrl"].startswith("https://creativecommons.org/"), slug
        assert credit["license"] == "CC0" or credit["license"].startswith(("CC BY ", "CC BY-SA "))
    assert all(r["review"]["nutritionSuitableForApproximateMatching"] for r in recipes)
    assert all(r["review"]["status"] == "QUARANTINED" for r in quarantine)
    # Focused regression checks for ambiguous source units and alternative methods.
    assert by_id["overnight-oats-for-one"]["recipe"]["totalTimeMinutes"] == 735
    assert by_id["oven-baked-salmon"]["ingredients"][1]["amount"] is None
    assert by_id["tofu-scramble"]["review"]["completeTimeSuitableForFiltering"] is False
    assert by_id["chicken-and-rice"]["nutrition"]["proteinGrams"] is None
    assert ingredient("test", 0, "1 and 1/2 cup milk", "Молоко")["amount"] == round(1.5 * CUP_ML, 2)
    assert ingredient("test", 0, "1/4 teaspoon salt", "Соль")["amount"] == 0.25
    can = ingredient("test", 0, "2 cans (15 ounces) beans, drained", "Фасоль")
    assert can["amount"] == 850.49 and "before draining" in can["noteEn"]


def make_coverage(recipes):
    rows = []
    for diets, allergies, (time_option, cap) in product(powerset(DIETS), powerset(ALLERGIES), TIMES.items()):
        selected = [r for r in recipes if set(diets) <= set(r["dietaryPreferences"])
                    and not set(allergies) & set(r["allergens"])
                    and (cap is None or (r["review"]["completeTimeSuitableForFiltering"] and r["recipe"]["totalTimeMinutes"] <= cap))]
        dips = [r for r in selected if r["snackAddition"]]
        groups = {meal: [(r,) for r in selected if meal in r["mealTypes"] and not r["snackAddition"]]
                  for meal in MEALS}
        snack_options = [
            (snack, dip)
            for (snack,) in groups["SNACKS"] if snack["recipe"]["id"] in DIP_PAIRINGS
            for dip in dips
            if cap is None or snack["recipe"]["totalTimeMinutes"] + dip["recipe"]["totalTimeMinutes"] <= cap
        ]
        groups["SNACKS"].extend(snack_options)
        plans = {}
        for meal_set in [MEALS[:3], MEALS]:
            totals = Counter()
            examples = {}
            for choices in product(*(groups[m] for m in meal_set)):
                menu = [recipe for option in choices for recipe in option]
                ids = [r["recipe"]["id"] for r in menu]
                if len(set(ids)) != len(ids):
                    continue
                kcal = sum(r["recipe"]["caloriesPerServing"] for r in menu)
                totals[kcal] += 1
                examples.setdefault(kcal, ids)
            goals = {}
            for name, preferred, fallback in [
                ("UNDER_1500", (1000, 1200), (1000, 1499)),
                ("FROM_1500_TO_2000", (1500, 2000), None),
                ("OVER_2000", (2500, 3000), (2001, 3000)),
                ("NO_GOAL", None, None),
            ]:
                matching = [k for k in sorted(totals) if preferred is None or preferred[0] <= k <= preferred[1]]
                widened = [k for k in sorted(totals) if fallback and fallback[0] <= k <= fallback[1]]
                goals[name] = {"preferredCount": sum(totals[k] for k in matching),
                               "expandedCount": sum(totals[k] for k in widened) if fallback else None,
                               "exampleRecipeIds": examples[matching[0]] if matching else (examples[widened[0]] if widened else None)}
            plans["WITH_SNACK" if len(meal_set) == 4 else "WITHOUT_SNACK"] = {
                "minKcal": min(totals) if totals else None, "maxKcal": max(totals) if totals else None,
                "calorieGoals": goals,
            }
        partial = []
        for meal_set in powerset(MEALS)[1:]:
            if {"BREAKFAST", "LUNCH", "DINNER"} <= set(meal_set):
                continue
            available = any(len({r["recipe"]["id"] for option in choices for r in option})
                            == sum(len(option) for option in choices)
                            for choices in product(*(groups[m] for m in meal_set)))
            if available:
                partial.append(list(meal_set))
        rows.append({"dietaryPreferences": list(diets), "excludedAllergens": list(allergies),
                     "cookingTime": time_option,
                     "recipeCountsByMeal": {k: sum(len(option) == 1 for option in v) for k, v in groups.items()},
                     "availablePartialMealSelectionsIgnoringDailyCalories": partial, "fullDayPlans": plans})
    return {
        "auditBasis": "EDITORIAL_RECIPE_TAGS_AND_DISPLAYED_SERVINGS",
        "profileCount": len(rows), "dietCombinationCount": 32, "allergyCombinationCount": 16,
        "rules": ["All selected diets must match; all selected allergies are excluded.",
                  "NO_PREFERENCE and NONE mean no corresponding filter, not recipe tags.",
                  "Time caps are <=15 and <=30 minutes; uncertain total times are excluded from capped searches.",
                  "One distinct base recipe per meal, with an optional dip for eligible snacks.",
                  "Nutrition uses one displayed serving of each recipe.",
                  "Daily calorie bands apply only when breakfast, lunch and dinner are all selected.",
                  "Counts are ordered meal assignments, not a recommendation to expose every permutation to users.",
                  "This audits only the four allergy options in the current questionnaire; it does not declare food allergy-safe."],
        "singleDietSummaryNoAllergyNoTimeLimit": [r for r in rows if len(r["dietaryPreferences"]) <= 1 and not r["excludedAllergens"] and r["cookingTime"] == "NO_LIMIT"],
        "profiles": rows,
    }


def main():
    recipes = read(ASSETS / "recipe_catalog/recipes.json")["recipes"]
    quarantine = read(DOCS / "review_required.json")["recipes"]
    credits = {c["recipeId"]: c for c in read(ASSETS / "recipe_catalog/image_credits.json")}
    sources = {**read(DOCS / "source_facts.json"), **MAIN_DISH_SOURCES}
    validate(recipes, quarantine, credits, sources)
    coverage = make_coverage(recipes)
    save(DOCS / "coverage.json", coverage)
    report = {"result": "PASS", "reviewedSeedRecipes": len(recipes), "quarantinedRecipes": len(quarantine),
              "photosWithCreditAndMatchingHash": len(credits), "questionnaireProfilesAudited": coverage["profileCount"],
              "independentCookingOrLaboratoryValidation": False, "productionImportAllowed": False}
    save(DOCS / "validation_report.json", report)
    print(json.dumps(report, ensure_ascii=False, indent=2))
    for row in coverage["singleDietSummaryNoAllergyNoTimeLimit"]:
        print(row["dietaryPreferences"] or ["NO_PREFERENCE"], row["recipeCountsByMeal"],
              "max daily kcal:", row["fullDayPlans"]["WITH_SNACK"]["maxKcal"])


if __name__ == "__main__":
    main()
