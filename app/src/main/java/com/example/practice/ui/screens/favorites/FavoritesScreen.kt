package com.example.practice.ui.screens.favorites

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.favorites.intents.FavoritesAction
import com.example.practice.ui.screens.favorites.intents.FavoritesFilter
import com.example.practice.ui.screens.favorites.intents.FavoritesItem
import com.example.practice.ui.screens.favorites.intents.FavoritesSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.CyclingChallengeCard
import com.example.practice.ui.uikit.components.WorkoutCard
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.BellNotificationOff
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.SearchOff
import io.github.composegears.valkyrie.UserOff

@Composable
fun FavoritesScreen(
    navController: NavController
) {
    val viewModel: FavoritesViewModel = viewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    when (sideEffect) {
        is FavoritesSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }
        is FavoritesSideEffect.ShowSearchScreen -> {
            //navController.navigate(FitnessScreen.Search.route)
            // TODO
            viewModel.clearSideEffect()
        }
        is FavoritesSideEffect.ShowNotificationScreen -> {
            //navController.navigate(FitnessScreen.Notification.route)
            // TODO
            viewModel.clearSideEffect()
        }
        is FavoritesSideEffect.ShowProfileScreen -> {
            navController.navigate(FitnessScreen.Profile.route)
            viewModel.clearSideEffect()
        }
        is FavoritesSideEffect.Empty -> {
            // Nothing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 40.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column{
                    Row(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(horizontal = 16.dp)
                            .clickable {
                                viewModel.uiAction(FavoritesAction.NavigateBack)
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberVectorPainter(Icons.Arrow),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Favorites",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Image(
                            painter = rememberVectorPainter(image = Icons.SearchOff),
                            contentDescription = "search",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(24.dp)
                                .clickable {
                                    viewModel.uiAction(FavoritesAction.Search)
                                }
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.BellNotificationOff),
                            contentDescription = "notification",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(24.dp)
                                .clickable {
                                    viewModel.uiAction(FavoritesAction.Notification)
                                }
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.UserOff),
                            contentDescription = "profile_user",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(24.dp)
                                .clickable {
                                    viewModel.uiAction(FavoritesAction.Profile)
                                }
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 12.dp, top = 8.dp, end = 24.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sort By",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )
                )

                Spacer(Modifier.width(12.dp))

                AppButton(
                    modifier = Modifier.width(80.dp).height(25.dp),
                    text = "All",
                    textColor = if (uiState.selectedFilter == FavoritesFilter.ALL) {
                        MaterialTheme.colorScheme.onSecondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    },
                    textStyle = MaterialTheme.typography.displayMedium,
                    buttonColor = if (uiState.selectedFilter == FavoritesFilter.ALL) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.onBackground
                    }
                ) {
                    viewModel.uiAction(
                        FavoritesAction.SelectFilter(FavoritesFilter.ALL)
                    )
                }

                Spacer(Modifier.width(12.dp))

                AppButton(
                    modifier = Modifier.width(80.dp).height(25.dp),
                    text = "Video",
                    textColor = if (uiState.selectedFilter == FavoritesFilter.VIDEO) {
                        MaterialTheme.colorScheme.onSecondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    },
                    textStyle = MaterialTheme.typography.displayMedium,
                    buttonColor = if (uiState.selectedFilter == FavoritesFilter.VIDEO) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.onBackground
                    }
                ) {
                    viewModel.uiAction(
                        FavoritesAction.SelectFilter(FavoritesFilter.VIDEO)
                    )
                }

                Spacer(Modifier.width(12.dp))

                AppButton(
                    modifier = Modifier.width(80.dp).height(25.dp),
                    text = "Article",
                    textColor = if (uiState.selectedFilter == FavoritesFilter.ARTICLE) {
                        MaterialTheme.colorScheme.onSecondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    },
                    textStyle = MaterialTheme.typography.displayMedium,
                    buttonColor = if (uiState.selectedFilter == FavoritesFilter.ARTICLE) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.onBackground
                    }
                ) {
                    viewModel.uiAction(
                        FavoritesAction.SelectFilter(FavoritesFilter.ARTICLE)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                uiState.visibleItems.forEach { item ->
                    when (item) {
                        is FavoritesItem.Workout -> {
                            WorkoutCard(
                                title = item.title,
                                duration = item.duration,
                                calories = item.calories,
                                exercises = item.exercises,
                                image = painterResource(id = item.imageRes)
                            )
                            Spacer(Modifier.height(12.dp))
                        }

                        is FavoritesItem.Article -> {
                            CyclingChallengeCard(
                                title = item.title,
                                isDescription = item.isDescriptor,
                                description = item.description,
                                duration = item.duration,
                                calories = item.calories,
                                image = painterResource(id = item.imageRes)
                            )
                            Spacer(Modifier.height(12.dp))
                        }
                    }
                }
            }
            Spacer(Modifier.height(40.dp))
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}