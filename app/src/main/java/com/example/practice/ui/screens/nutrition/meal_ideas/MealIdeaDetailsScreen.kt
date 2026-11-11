package com.example.practice.ui.screens.nutrition.meal_ideas

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.IngredientUnitUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaDetailsUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaTodayStateUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasAction
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasSideEffect
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasState
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealTypeUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.RecipeFullUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.RecipeIngredientUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.RecipeStepUi
import com.example.practice.ui.utils.isRussianLanguage
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.TopBar
import com.example.practice.ui.uikit.theme.FitnessTheme
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Check
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Nutrition
import io.github.composegears.valkyrie.StarDefault
import io.github.composegears.valkyrie.TimeDefault
import java.io.IOException
import java.text.NumberFormat

@Composable
fun MealIdeaDetailsScreen(
    navController: NavController,
    viewModel: MealIdeasViewModel,
    mealIdeaId: String,
    recipeId: String
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    var selectedRecipeId by rememberSaveable(recipeId) { mutableStateOf(recipeId) }

    LaunchedEffect(mealIdeaId) {
        viewModel.loadMealIdeaDetails(mealIdeaId)
    }

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is MealIdeasSideEffect.Empty -> {
                // Nothing
            }

            is MealIdeasSideEffect.ShowNavigationMealIdeasInfo -> {
                // Nothing
            }

            is MealIdeasSideEffect.ShowNavigationBack -> {
                navController.navigate(FitnessScreen.MealIdeas.route)
                viewModel.clearSideEffect()
            }
        }
    }

    MealIdeaDetailsContent(
        navController = navController,
        uiState = uiState,
        selectedRecipeId = selectedRecipeId,
        onMealTypeClick = { clickedRecipeId ->
            selectedRecipeId = clickedRecipeId
        },
        onTodayClick = {
            viewModel.handleUiAction(
                MealIdeasAction.ToggleMealIdeaForTodayPressed(mealIdeaId)
            )
        }
    )
}

@Composable
fun MealIdeaDetailsContent(
    navController: NavController,
    uiState: MealIdeasState,
    selectedRecipeId: String,
    onMealTypeClick: (recipeId: String) -> Unit,
    onTodayClick: () -> Unit
) {
    val mealIdea = uiState.selectedMealIdea
    val dishCount = mealIdea?.dishes?.size ?: 0
    val selectedDish = mealIdea?.dishes
        ?.firstOrNull { it.recipeId == selectedRecipeId }
        ?: mealIdea?.dishes?.firstOrNull()
    val isRussian = isRussianLanguage()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 40.dp)
    ) {
        TopBar(
            navController = navController,
            title = stringResource(R.string.meal_plan_title)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.meal_ideas_daily_plan_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MealMetric(
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = rememberVectorPainter(Icons.TimeDefault),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    text = stringResource(
                        R.string.meal_ideas_minutes_format,
                        mealIdea?.totalTimeMinutes ?: 0
                    )
                )

                Spacer(modifier = Modifier.width(12.dp))

                MealMetric(
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = rememberVectorPainter(Icons.Calories),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    text = stringResource(
                        R.string.meal_ideas_calories_format,
                        mealIdea?.totalCalories ?: 0
                    )
                )

                Spacer(modifier = Modifier.width(12.dp))

                MealMetric(
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = rememberVectorPainter(Icons.Nutrition),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    text = pluralStringResource(
                        R.plurals.meal_ideas_dishes,
                        dishCount,
                        dishCount
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            mealIdea?.let {
                MealIdeaTodayButton(
                    todayState = it.todayState,
                    onClick = onTodayClick
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            mealIdea?.let {
                MealSelection(
                    mealTypeUi = it,
                    selectedRecipeId = selectedDish?.recipeId ?: selectedRecipeId,
                    onMealTypeClick = onMealTypeClick
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = stringResource(
                    if (selectedDish?.snackAddition == true) R.string.meal_ideas_snack_addition
                    else mealTypeTextRes(selectedDish?.mealType ?: MealTypeUi.Breakfast)
                ),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = selectedDish?.localizedName(isRussian).orEmpty(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.outline
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MealMetric(
                    icon = {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            painter = rememberVectorPainter(Icons.TimeDefault),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    text = stringResource(
                        R.string.meal_ideas_minutes_format,
                        selectedDish?.timeMinutes ?: 0
                    )
                )

                Spacer(modifier = Modifier.width(14.dp))

                MealMetric(
                    icon = {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            painter = rememberVectorPainter(Icons.Calories),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    text = stringResource(
                        R.string.meal_ideas_calories_per_serving,
                        selectedDish?.calories ?: 0
                    )
                )
            }

            selectedDish?.let { dish ->
                val serving = if (isRussian) dish.servingDescriptionRu else dish.servingDescriptionEn
                if (!serving.isNullOrBlank()) {
                    Text(
                        text = stringResource(R.string.meal_ideas_serving_size, serving),
                        modifier = Modifier.padding(top = 8.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            selectedDish?.imagePath?.let { imagePath ->
                MealDetailImage(imagePath = imagePath)
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = stringResource(R.string.meal_ideas_ingredients_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            selectedDish?.batchServings?.let { count ->
                Text(
                    text = pluralStringResource(R.plurals.meal_ideas_recipe_yield, count, count),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            selectedDish?.ingredients.orEmpty().forEach { ingredient ->
                Text(
                    modifier = Modifier.padding(bottom = 6.dp),
                    text = stringResource(
                        R.string.meal_ideas_bullet_item,
                        ingredient.localizedLine(isRussian)
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = stringResource(R.string.meal_ideas_preparation_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(10.dp))

            selectedDish?.steps.orEmpty().forEach { step ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondary,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = step.position.toString(),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        modifier = Modifier.weight(1f),
                        text = step.localizedText(isRussian),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        BottomNavigation(
            navController = navController
        )
    }
}

@Composable
private fun MealIdeaTodayButton(
    todayState: MealIdeaTodayStateUi,
    onClick: () -> Unit
) {
    val backgroundColor = when (todayState) {
        MealIdeaTodayStateUi.NotSelected -> MaterialTheme.colorScheme.primary
        MealIdeaTodayStateUi.SelectedToday -> MaterialTheme.colorScheme.secondary
        MealIdeaTodayStateUi.SelectedPastDay -> MaterialTheme.colorScheme.tertiary
    }

    val contentColor = when (todayState) {
        MealIdeaTodayStateUi.NotSelected -> MaterialTheme.colorScheme.onPrimary
        MealIdeaTodayStateUi.SelectedToday -> MaterialTheme.colorScheme.onSecondary
        MealIdeaTodayStateUi.SelectedPastDay -> MaterialTheme.colorScheme.onTertiary
    }

    val icon = when (todayState) {
        MealIdeaTodayStateUi.NotSelected -> Icons.StarDefault
        MealIdeaTodayStateUi.SelectedToday -> Icons.Check
        MealIdeaTodayStateUi.SelectedPastDay -> Icons.TimeDefault
    }

    val textRes = when (todayState) {
        MealIdeaTodayStateUi.NotSelected -> R.string.meal_ideas_choose_today
        MealIdeaTodayStateUi.SelectedToday -> R.string.meal_ideas_selected_today
        MealIdeaTodayStateUi.SelectedPastDay -> R.string.meal_ideas_choose_again_today
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(25.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(22.dp),
            painter = rememberVectorPainter(icon),
            contentDescription = "",
            tint = contentColor
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = stringResource(textRes),
            style = MaterialTheme.typography.labelLarge,
            color = contentColor
        )
    }
}

@Composable
fun MealSelection(
    mealTypeUi: MealIdeaDetailsUi,
    selectedRecipeId: String,
    onMealTypeClick: (recipeId: String) -> Unit
) {
    val scrollable = mealTypeUi.dishes.size > 4
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(
                color = MaterialTheme.colorScheme.onTertiary,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(4.dp)
            .then(if (scrollable) Modifier.horizontalScroll(rememberScrollState()) else Modifier)
    ) {
        mealTypeUi.dishes.forEach { dish ->
            Box(
                modifier = Modifier
                    .then(if (scrollable) Modifier.width(90.dp) else Modifier.weight(1f))
                    .fillMaxHeight()
                    .then(
                        if (dish.recipeId == selectedRecipeId) {
                            Modifier.background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(14.dp)
                            )
                        } else {
                            Modifier
                        }
                    )
                    .clickable {
                        onMealTypeClick(dish.recipeId)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(
                        if (dish.snackAddition) R.string.meal_ideas_dip_tab
                        else mealTypeTextRes(dish.mealType)
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = if (dish.recipeId == selectedRecipeId) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.outline
                    }
                )
            }
        }
    }
}

@Composable
private fun MealMetric(
    icon: @Composable () -> Unit,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
private fun MealDetailImage(
    imagePath: String
) {
    val context = LocalContext.current
    var bitmap by remember(imagePath) { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(imagePath) {
        if (imagePath.isBlank()) return@LaunchedEffect
        bitmap = try {
            context.assets.open(imagePath).use { BitmapFactory.decodeStream(it)?.asImageBitmap() }
        } catch (_: IOException) {
            null
        }
    }

    bitmap?.let { loadedBitmap ->
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .clip(RoundedCornerShape(18.dp)),
            bitmap = loadedBitmap,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MealIdeaDetailsContentPreview() {
    FitnessTheme {
        MealIdeaDetailsContent(
            navController = rememberNavController(),
            uiState = MealIdeasState(
                selectedMealIdea = MealIdeaDetailsUi(
                    id = "preview-meal-idea",
                    totalCalories = 1580,
                    totalTimeMinutes = 77,
                    todayState = MealIdeaTodayStateUi.SelectedToday,
                    dishes = listOf(
                        RecipeFullUi(
                            recipeId = "breakfast-preview",
                            mealType = MealTypeUi.Breakfast,
                            nameRu = "Запеченная овсянка с ягодами",
                            nameEn = "Baked berry oatmeal",
                            descriptionRu = "Теплая овсянка с ягодами и орехами.",
                            descriptionEn = "Warm oatmeal with berries and nuts.",
                            imagePath = "recipe_catalog/images/baked-berry-oatmeal.jpg",
                            calories = 340,
                            timeMinutes = 12,
                            ingredients = listOf(
                                RecipeIngredientUi(
                                    recipeId = "breakfast-preview",
                                    position = 1,
                                    nameIngredientsRu = "Овсяные хлопья",
                                    nameIngredientsEn = "Oats",
                                    amount = 80.0,
                                    ingredientUnit = IngredientUnitUi.Gram,
                                    noteRu = null,
                                    noteEn = null
                                ),
                                RecipeIngredientUi(
                                    recipeId = "breakfast-preview",
                                    position = 2,
                                    nameIngredientsRu = "Ягоды",
                                    nameIngredientsEn = "Berries",
                                    amount = 100.0,
                                    ingredientUnit = IngredientUnitUi.Gram,
                                    noteRu = null,
                                    noteEn = null
                                ),
                                RecipeIngredientUi(
                                    recipeId = "breakfast-preview",
                                    position = 3,
                                    nameIngredientsRu = "Греческий йогурт",
                                    nameIngredientsEn = "Greek yogurt",
                                    amount = 120.0,
                                    ingredientUnit = IngredientUnitUi.Gram,
                                    noteRu = null,
                                    noteEn = null
                                )
                            ),
                            batchServings = 1,
                            servingDescriptionRu = "1 миска (около 300 г)",
                            servingDescriptionEn = "1 bowl (about 300 g)",
                            steps = listOf(
                                RecipeStepUi(
                                    recipeId = "breakfast-preview",
                                    position = 1,
                                    textRu = "Смешайте овсяные хлопья, йогурт и часть ягод.",
                                    textEn = "Mix oats, yogurt, and part of the berries."
                                ),
                                RecipeStepUi(
                                    recipeId = "breakfast-preview",
                                    position = 2,
                                    textRu = "Выложите смесь в форму и запекайте до мягкой текстуры.",
                                    textEn = "Place the mixture into a dish and bake until soft."
                                ),
                                RecipeStepUi(
                                    recipeId = "breakfast-preview",
                                    position = 3,
                                    textRu = "Добавьте оставшиеся ягоды перед подачей.",
                                    textEn = "Add the remaining berries before serving."
                                )
                            )
                        ),
                        RecipeFullUi(
                            recipeId = "lunch-preview",
                            mealType = MealTypeUi.Lunch,
                            nameRu = "Курица с рисом",
                            nameEn = "Chicken and rice",
                            descriptionRu = "Сытный обед с курицей, рисом и овощами.",
                            descriptionEn = "A filling lunch with chicken, rice, and vegetables.",
                            imagePath = "recipe_catalog/images/chicken-and-rice.jpg",
                            calories = 520,
                            timeMinutes = 25,
                            ingredients = emptyList(),
                            steps = emptyList()
                        ),
                        RecipeFullUi(
                            recipeId = "dinner-preview",
                            mealType = MealTypeUi.Dinner,
                            nameRu = "Запеченный лосось",
                            nameEn = "Oven baked salmon",
                            descriptionRu = "Легкий ужин с лососем и зеленью.",
                            descriptionEn = "A light dinner with salmon and greens.",
                            imagePath = "recipe_catalog/images/oven-baked-salmon.jpg",
                            calories = 470,
                            timeMinutes = 28,
                            ingredients = emptyList(),
                            steps = emptyList()
                        ),
                        RecipeFullUi(
                            recipeId = "snack-preview",
                            mealType = MealTypeUi.Snacks,
                            nameRu = "Дыня с мятой",
                            nameEn = "Melon and mint",
                            descriptionRu = "Свежий перекус с мятой.",
                            descriptionEn = "A fresh snack with mint.",
                            imagePath = "recipe_catalog/images/melon-and-mint.jpg",
                            calories = 250,
                            timeMinutes = 12,
                            ingredients = emptyList(),
                            steps = emptyList()
                        )
                    )
                )
            ),
            selectedRecipeId = "breakfast-preview",
            onMealTypeClick = {},
            onTodayClick = {}
        )
    }
}

private fun mealTypeTextRes(mealType: MealTypeUi): Int {
    return when (mealType) {
        MealTypeUi.Breakfast -> R.string.meal_plan_breakfast
        MealTypeUi.Lunch -> R.string.meal_plan_lunch
        MealTypeUi.Dinner -> R.string.meal_plan_dinner
        MealTypeUi.Snacks -> R.string.meal_plan_snacks
    }
}

private fun RecipeFullUi.localizedName(isRussian: Boolean): String {
    return if (isRussian) nameRu else nameEn
}

@Composable
private fun RecipeIngredientUi.localizedLine(isRussian: Boolean): String {
    val name = if (isRussian) nameIngredientsRu else nameIngredientsEn
    val note = if (isRussian) noteRu else noteEn
    val unit = ingredientUnit
    val value = amount
    val withQuantity = if (value != null && unit != null) {
        val unitRes = when (unit) {
            IngredientUnitUi.Gram -> R.string.meal_ideas_unit_gram
            IngredientUnitUi.Milliliter -> R.string.meal_ideas_unit_milliliter
            IngredientUnitUi.Piece -> R.string.meal_ideas_unit_piece
            IngredientUnitUi.Teaspoon -> R.string.meal_ideas_unit_teaspoon
            IngredientUnitUi.Tablespoon -> R.string.meal_ideas_unit_tablespoon
            IngredientUnitUi.Cup -> R.string.meal_ideas_unit_cup
            IngredientUnitUi.Clove -> R.string.meal_ideas_unit_clove
        }
        val locale = LocalConfiguration.current.locales[0]
        val amountText = remember(value, unit, locale) {
            val fraction = if (unit == IngredientUnitUi.Cup) {
                when {
                    kotlin.math.abs(value - 1.0 / 3) < 0.001 -> "⅓"
                    value == 0.25 -> "¼"
                    value == 0.5 -> "½"
                    value == 0.75 -> "¾"
                    value == 1.5 -> "1½"
                    value == 1.75 -> "1¾"
                    else -> null
                }
            } else null
            fraction ?: NumberFormat.getNumberInstance(locale).apply {
                maximumFractionDigits = 3
            }.format(value)
        }
        stringResource(
            R.string.meal_ideas_ingredient_amount, name, amountText, stringResource(unitRes)
        )
    } else {
        name
    }
    return if (note.isNullOrBlank()) withQuantity else {
        stringResource(R.string.meal_ideas_ingredient_note, withQuantity, note)
    }
}

private fun RecipeStepUi.localizedText(isRussian: Boolean): String {
    return if (isRussian) textRu else textEn
}
