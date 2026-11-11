"""Reviewed additions based on the nutrition and yields published by MedlinePlus."""

MAIN_DISHES = [
    dict(
        slug="chicken-and-black-bean-salsa-burritos",
        name="Буррито с курицей и чёрной фасолью",
        description="Пшеничная лепёшка с курицей, фасолью и расплавленным сыром.",
        en="A wheat tortilla filled with chicken, black beans and melted cheese.",
        names=["Чёрная фасоль, промыть и слить жидкость", "Стебли зелёного лука",
               "Лимонный сок", "Молотый кумин", "Соль", "Куриное филе без кожи и костей",
               "Порошок чили", "Чёрный перец", "Натёртый чеддер", "Пшеничные тортильи диаметром 23 см"],
        steps=[
            "Разогрейте духовку до 177 °C. Смешайте промытую фасоль, нарезанный зелёный лук, лимонный сок, кумин и половину соли.",
            "Натрите курицу чили, перцем и оставшейся солью. Обжарьте на сковороде на средне-сильном огне с обеих сторон до 74 °C в самой толстой части. Нарежьте полосками.",
            "Разложите сыр, курицу и фасолевую смесь по четырём тортильям. Сверните их и заверните в фольгу.",
            "Запекайте около 15 минут до расплавления сыра. Одна порция — один целый буррито.",
        ],
        steps_en=[
            "Heat the oven to 177 °C. Combine the rinsed beans, chopped green onions, lemon juice, cumin and half the salt.",
            "Season the chicken with chili, pepper and the remaining salt. Sear both sides over medium-high heat until the thickest part reaches 74 °C. Slice into strips.",
            "Divide the cheese, chicken and bean mixture among four tortillas. Roll them up and wrap in foil.",
            "Bake for about 15 minutes until the cheese melts. Serve one whole burrito per portion.",
        ],
        meals=["LUNCH", "DINNER"], diets=[], allergens=["DAIRY"], extra=["WHEAT"],
        serving=("1 буррито (около 322 г)", "1 whole burrito (about 322 g)"),
        serving_multiple=2, nutrition_ok=True, time_ok=True, issues=[],
    ),
    dict(
        slug="cheesy-beef-pasta",
        name="Паста с говядиной и сыром",
        description="Макароны с говяжьим фаршем, кабачком и томатным соусом.",
        en="Pasta with ground beef, zucchini, tomato sauce and melted cheese.",
        names=["Говяжий фарш, 15% жира", "Репчатый лук", "Чеснок", "Небольшой кабачок",
               "Томатный соус для пасты", "Сушёный базилик", "Сушёный орегано",
               "Хлопья красного перца", "Сухая паста ротини",
               "Натёртый чеддер", "Натёртая моцарелла"],
        steps=[
            "Нарежьте лук и кабачок, измельчите чеснок. Обжарьте овощи с фаршем, разбивая комки. Доведите фарш до 71 °C и слейте лишний жир.",
            "Вмешайте томатный соус, базилик, орегано и по желанию острый перец. Готовьте на слабом огне около 15 минут.",
            "Отварите пасту по инструкции на упаковке. Слейте воду и смешайте пасту с соусом.",
            "Вмешайте оба сыра и накройте до их расплавления. Разделите весь выход на четыре порции.",
        ],
        steps_en=[
            "Chop the onion and zucchini and mince the garlic. Brown the vegetables with the beef, breaking up the meat. Cook the beef to 71 °C and drain excess fat.",
            "Stir in the tomato sauce, basil, oregano and optional pepper flakes. Simmer for about 15 minutes.",
            "Cook the pasta according to the package. Drain and combine with the sauce.",
            "Stir in both cheeses and cover until they melt. Divide the batch into four servings.",
        ],
        meals=["LUNCH", "DINNER"], diets=[], allergens=["DAIRY"], extra=["WHEAT"],
        serving=("¼ готового блюда (около 578 г)", "¼ of the cooked batch (about 578 g)"),
        serving_multiple=2, nutrition_ok=True, time_ok=True, issues=[],
    ),
    dict(
        slug="indian-lentils-and-pasta",
        name="Чечевица с орзо и томатами",
        description="Чечевица и мелкие макароны в томатном соусе с кумином и куркумой.",
        en="Lentils and small pasta in a tomato sauce with cumin and turmeric.",
        names=["Растительное масло", "Крупная луковица", "Чеснок", "Вода",
               "Нарезанные консервированные томаты с соком", "Сухая чечевица",
               "Молотый кумин", "Куркума", "Хлопья красного перца",
               "Орзо или мелкая паста без яйца", "Свежая кинза"],
        steps=[
            "Нарежьте лук и чеснок, промойте чечевицу. Обжарьте лук и чеснок в масле 3–4 минуты.",
            "Добавьте воду, томаты с соком, чечевицу, кумин, куркуму и по желанию острый перец. Доведите до кипения и тушите под крышкой на слабом огне около 25 минут.",
            "Всыпьте орзо. Готовьте без крышки около 10 минут, пока паста не станет мягкой.",
            "Добавьте нарезанную кинзу и разделите блюдо на три порции.",
        ],
        steps_en=[
            "Chop the onion and garlic and rinse the lentils. Sauté the onion and garlic in oil for 3–4 minutes.",
            "Add the water, tomatoes with their juice, lentils, cumin, turmeric and optional pepper flakes. Bring to a boil, cover and simmer gently for about 25 minutes.",
            "Add the orzo and cook uncovered for about 10 minutes, until the pasta is tender.",
            "Add chopped cilantro and divide the batch into three servings.",
        ],
        meals=["LUNCH", "DINNER"], diets=["VEGETARIAN", "VEGAN"], allergens=[], extra=["WHEAT"],
        serving=("⅓ готового блюда (около 504 г)", "⅓ of the cooked batch (about 504 g)"),
        serving_multiple=2, nutrition_ok=True, time_ok=True, issues=[],
    ),
]


def source(slug, title, timing, serving, nutrition, ingredients):
    labels = ["Calories", "Protein", "Total Fat", "Saturated Fat",
              "Total Carbohydrate", "Dietary Fiber", "Total Sugars", "Sodium"]
    return {
        "url": f"https://medlineplus.gov/recipes/{slug}/",
        "title": title, "publisher": "MedlinePlus, National Library of Medicine",
        "origin": "Food Hero / Oregon State University Extension",
        "checkedOn": "2026-11-11", "timing": timing,
        "facts": [f"Serving size {serving}"] + [f"{k} {v}" for k, v in zip(labels, nutrition)],
        "ingredients": ingredients,
    }


MAIN_DISH_SOURCES = {
    "chicken-and-black-bean-salsa-burritos": source(
        "chicken-and-black-bean-salsa-burritos", "Chicken and Black Bean Salsa Burritos",
        "Prep time: 20 minutes Cook time: 30 minutes Total time: 50 minutes Number of Servings: 8",
        "1/2 burrito (161 g)", [260, 22, 8, 3.5, 24, 4, 1, 410],
        ["1 can (15 ounces) black beans, drained and rinsed", "2 green onions, chopped",
         "1 Tablespoon lemon juice", "1/4 teaspoon ground cumin", "1/2 teaspoon salt, divided",
         "4 boneless, skinless chicken breasts", "1/4 teaspoon chili powder", "1/4 teaspoon pepper",
         "1 cup shredded cheese", "4 (9-inch) flour tortillas"],
    ),
    "cheesy-beef-pasta": source(
        "cheesy-beef-pasta", "Cheesy Beef Pasta",
        "Prep time: 20 minutes Cook time: 30 minutes Total time: 50 minutes Number of Servings: 8",
        "1 cup (289 g)", [380, 20, 12, 5, 46, 1, 6, 580],
        ["1/2 pound lean ground beef (15% fat)", "1 onion, diced",
         "2 cloves garlic, minced, or 1/2 teaspoon garlic powder", "1 small zucchini, chopped",
         "1 jar (24 to 26 ounces) tomato-based pasta sauce", "1/2 teaspoon dried basil",
         "1/2 teaspoon dried oregano", "1/4 teaspoon red pepper flakes (optional)",
         "12 ounces rotini pasta", "2 ounces shredded cheddar cheese", "6 ounces shredded mozzarella cheese"],
    ),
    "indian-lentils-and-pasta": source(
        "indian-lentils-and-pasta", "Indian Lentils and Pasta",
        "Prep time: 10 minutes Cook time: 45 minutes Total time: 55 minutes Number of Servings: 6",
        "1 cup (252 g)", [170, 7, 3, 0, 30, 4, 4, 170],
        ["1 Tablespoon vegetable oil", "1 large onion, chopped",
         "2 cloves garlic finely chopped or 1/2 teaspoon garlic powder", "3 cups water",
         "1 can (15 ounces) diced tomatoes, with juice", "1/2 cup dry lentils, rinsed",
         "1 teaspoon ground cumin", "1 teaspoon turmeric", "1/4 teaspoon red pepper flakes (optional)",
         "1/2 cup orzo or tiny pasta", "1/4 cup fresh cilantro, chopped"],
    ),
}
