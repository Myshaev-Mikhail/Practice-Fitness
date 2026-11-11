package com.example.practice.ui.screens.nutrition.meal_ideas

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaCardUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaDishUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeaTodayStateUi
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasAction
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasSideEffect
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealIdeasState
import com.example.practice.ui.screens.nutrition.meal_ideas.actions.MealTypeUi
import com.example.practice.ui.utils.isRussianLanguage
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.TopBar
import com.example.practice.ui.uikit.theme.FitnessTheme
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Check
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Nutrition
import io.github.composegears.valkyrie.StarDefault
import io.github.composegears.valkyrie.TimeDefault

@Composable
fun MealIdeasScreen(
    navController: NavController,
    viewModel: MealIdeasViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    LaunchedEffect(sideEffect) {
        when (val effect = sideEffect) {
            is MealIdeasSideEffect.Empty -> {
                // Nothing
            }

            is MealIdeasSideEffect.ShowNavigationMealIdeasInfo -> {
                navController.navigate(
                    FitnessScreen.MealIdeaDetails.createRoute(
                        mealIdeaId = effect.mealIdeaId,
                        recipeId = effect.recipeId
                    )
                )
                viewModel.clearSideEffect()
            }

            is MealIdeasSideEffect.ShowNavigationBack -> {
                navController.navigate(FitnessScreen.Home.route)
                viewModel.clearSideEffect()
            }
        }
    }

    MealIdeasContent(
        navController = navController,
        uiState = uiState,
        onToggleMealIdea = { mealIdeaId ->
            viewModel.handleUiAction(MealIdeasAction.ToggleMealIdeaForTodayPressed(mealIdeaId))
        },
        onDishClick = { mealIdeaId, recipeId ->
            viewModel.handleUiAction(
                MealIdeasAction.NavigationMealIdeasInfoPressed(mealIdeaId, recipeId)
            )
        }
    )
}

@Composable
fun MealIdeasContent(
    navController: NavController,
    uiState: MealIdeasState,
    onToggleMealIdea: (mealIdeaId: String) -> Unit,
    onDishClick: (mealIdeaId: String, recipeId: String) -> Unit
) {
    val listState = rememberLazyListState()
    val selectedTodayId = uiState.mealIdeaCards
        .firstOrNull { it.todayState == MealIdeaTodayStateUi.SelectedToday }
        ?.id
    var lastSelectedTodayId by rememberSaveable { mutableStateOf<String?>(null) }

    LaunchedEffect(selectedTodayId) {
        if (selectedTodayId != null && selectedTodayId != lastSelectedTodayId) {
            listState.scrollToItem(0)
        }
        lastSelectedTodayId = selectedTodayId
    }

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

        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(
                items = uiState.mealIdeaCards,
                key = { card -> card.id }
            ) { card ->
                MealIdeasCard(
                    card = card,
                    onToggleMealIdea = { onToggleMealIdea(card.id) },
                    onDishClick = { recipeId ->
                        onDishClick(card.id, recipeId)
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        BottomNavigation(
            navController = navController
        )
    }
}

@Composable
fun MealIdeasCard(
    card: MealIdeaCardUi,
    onToggleMealIdea: () -> Unit,
    onDishClick: (recipeId: String) -> Unit
) {
    val isRussian = isRussianLanguage()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onTertiary,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.meal_ideas_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = rememberVectorPainter(Icons.StarDefault),
                    contentDescription = "",
                    tint = mealTodayStateRes(card.todayState)
                )

                Spacer(modifier = Modifier.weight(1f))

                MealIdeaStatusBadge(
                    icon = mealIconStatusRes(card.todayState),
                    text = stringResource(mealTextStatusRes(card.todayState)),
                    onClickLabel = stringResource(
                        if (card.todayState == MealIdeaTodayStateUi.SelectedToday) {
                            R.string.meal_ideas_cancel_today
                        } else {
                            R.string.meal_ideas_choose_today
                        }
                    ),
                    onClick = onToggleMealIdea
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            card.dishes.forEach { dish ->
                MealIdeaDishRow(
                    nameImage = dish.imagePath,
                    meals = stringResource(
                        if (dish.snackAddition) R.string.meal_ideas_snack_addition
                        else mealTypeTextRes(dish.mealType)
                    ),
                    nameDish = dish.localizedName(isRussian),
                    time = dish.timeMinutes,
                    calories = dish.calories,
                    onClick = {
                        onDishClick(dish.recipeId)
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                )
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(start = 8.dp))
                Text(
                    text = stringResource(R.string.meal_ideas_day_totals),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = rememberVectorPainter(Icons.TimeDefault),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(
                        R.string.meal_ideas_minutes_short_format,
                        card.totalTimeMinutes
                    ),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(modifier = Modifier.width(12.dp))

                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = rememberVectorPainter(Icons.Calories),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(
                        R.string.meal_ideas_calories_short_format,
                        card.totalCalories
                    ),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(modifier = Modifier.padding(end = 8.dp))
            }
        }
    }
}

@Composable
fun MealIdeaDishRow(
    nameImage: String,
    meals: String,
    nameDish: String,
    time: Int,
    calories: Int,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    var bitmap by remember(nameImage) { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(nameImage) {
        if (nameImage.isBlank()) return@LaunchedEffect
        bitmap = try {
            context.assets.open(nameImage).use { BitmapFactory.decodeStream(it)?.asImageBitmap() }
        } catch (_: java.io.IOException) {
            null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.onTertiary),
                contentAlignment = Alignment.Center
            ) {
                val loadedBitmap = bitmap
                if (loadedBitmap != null) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        bitmap = loadedBitmap,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = rememberVectorPainter(Icons.Nutrition),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = meals,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = nameDish,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.outline
                )

                Row {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = rememberVectorPainter(Icons.TimeDefault),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = stringResource(R.string.meal_ideas_minutes_short_format, time),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = rememberVectorPainter(Icons.Calories),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = stringResource(R.string.meal_ideas_calories_short_format, calories),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .rotate(180f),
                painter = rememberVectorPainter(Icons.Arrow),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun MealIdeaStatusBadge(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    onClickLabel: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(MaterialTheme.colorScheme.secondary)
                .clickable(role = Role.Button, onClickLabel = onClickLabel, onClick = onClick)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = icon,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.outlineVariant
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
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

@Composable
private fun mealTodayStateRes(mealToday: MealIdeaTodayStateUi): Color {
    return when (mealToday) {
        MealIdeaTodayStateUi.NotSelected -> MaterialTheme.colorScheme.outline
        MealIdeaTodayStateUi.SelectedToday -> MaterialTheme.colorScheme.secondary
        MealIdeaTodayStateUi.SelectedPastDay -> MaterialTheme.colorScheme.tertiary
    }
}

@Composable
private fun mealIconStatusRes(mealToday: MealIdeaTodayStateUi): Painter {
    return when (mealToday) {
        MealIdeaTodayStateUi.NotSelected -> rememberVectorPainter(Icons.StarDefault)
        MealIdeaTodayStateUi.SelectedToday -> rememberVectorPainter(Icons.Check)
        MealIdeaTodayStateUi.SelectedPastDay -> rememberVectorPainter(Icons.TimeDefault)
    }
}

@Composable
private fun mealTextStatusRes(mealToday: MealIdeaTodayStateUi): Int {
    return when (mealToday) {
        MealIdeaTodayStateUi.NotSelected -> R.string.meal_plan_status_appropriate
        MealIdeaTodayStateUi.SelectedToday -> R.string.meal_plan_status_today
        MealIdeaTodayStateUi.SelectedPastDay -> R.string.meal_plan_status_earlier
    }
}

private fun MealIdeaDishUi.localizedName(isRussian: Boolean): String {
    return if (isRussian) nameRu else nameEn
}

@Preview(showBackground = true)
@Composable
fun MealIdeasContentPreview() {
    FitnessTheme(true) {
        MealIdeasContent(
            navController = rememberNavController(),
            uiState = MealIdeasState(
                mealIdeaCards = listOf(
                    MealIdeaCardUi(
                        id = "preview-meal-idea",
                        dishes = listOf(
                            MealIdeaDishUi(
                                recipeId = "breakfast-preview",
                                mealType = MealTypeUi.Breakfast,
                                nameRu = "Запеченная овсянка",
                                nameEn = "Baked oatmeal",
                                imagePath = "recipe_catalog/images/baked-berry-oatmeal.jpg",
                                calories = 340,
                                timeMinutes = 12
                            ),
                            MealIdeaDishUi(
                                recipeId = "lunch-preview",
                                mealType = MealTypeUi.Lunch,
                                nameRu = "Курица с рисом",
                                nameEn = "Chicken and rice",
                                imagePath = "recipe_catalog/images/chicken-and-rice.jpg",
                                calories = 610,
                                timeMinutes = 32
                            )
                        ),
                        totalCalories = 950,
                        totalTimeMinutes = 44,
                        todayState = MealIdeaTodayStateUi.SelectedToday
                    ),
                    MealIdeaCardUi(
                        id = "preview-meal-idea-alternative",
                        dishes = listOf(
                            MealIdeaDishUi(
                                recipeId = "breakfast-preview",
                                mealType = MealTypeUi.Breakfast,
                                nameRu = "Запеченная овсянка",
                                nameEn = "Baked oatmeal",
                                imagePath = "recipe_catalog/images/baked-berry-oatmeal.jpg",
                                calories = 340,
                                timeMinutes = 12
                            ),
                            MealIdeaDishUi(
                                recipeId = "lunch-preview",
                                mealType = MealTypeUi.Lunch,
                                nameRu = "Курица с рисом",
                                nameEn = "Chicken and rice",
                                imagePath = "recipe_catalog/images/chicken-and-rice.jpg",
                                calories = 610,
                                timeMinutes = 32
                            )
                        ),
                        totalCalories = 950,
                        totalTimeMinutes = 44,
                        todayState = MealIdeaTodayStateUi.NotSelected
                    )
                )
            ),
            onToggleMealIdea = {},
            onDishClick = { _, _ -> }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MealIdeasCardPreview() {
    FitnessTheme(true) {
        MealIdeasCard(
            card = MealIdeaCardUi(
                id = "preview-meal-idea",
                dishes = listOf(
                    MealIdeaDishUi(
                        recipeId = "breakfast-preview",
                        mealType = MealTypeUi.Breakfast,
                        nameRu = "Запеченная овсянка",
                        nameEn = "Baked oatmeal",
                        imagePath = "recipe_catalog/images/baked-berry-oatmeal.jpg",
                        calories = 340,
                        timeMinutes = 12
                    ),
                    MealIdeaDishUi(
                        recipeId = "lunch-preview",
                        mealType = MealTypeUi.Lunch,
                        nameRu = "Курица с рисом",
                        nameEn = "Chicken and rice",
                        imagePath = "recipe_catalog/images/chicken-and-rice.jpg",
                        calories = 610,
                        timeMinutes = 32
                    )
                ),
                totalCalories = 950,
                totalTimeMinutes = 44,
                todayState = MealIdeaTodayStateUi.SelectedToday
            ),
            onToggleMealIdea = {},
            onDishClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MealIdeaStatusBadgePreview() {
    FitnessTheme(true) {
        MealIdeaStatusBadge(
            icon = rememberVectorPainter(Icons.Check),
            text = stringResource(R.string.meal_plan_status_today),
            onClickLabel = stringResource(R.string.meal_ideas_cancel_today),
            onClick = {}
        )
    }
}
