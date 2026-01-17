package com.example.practice.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.profile.intents.ProfileAction
import com.example.practice.ui.screens.profile.intents.ProfileSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.ProfileMenuItem
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Favorites
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Logout
import io.github.composegears.valkyrie.Privacity
import io.github.composegears.valkyrie.Profile
import io.github.composegears.valkyrie.Settings
import io.github.composegears.valkyrie.SupportAgent

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    when (sideEffect) {
        is ProfileSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowEditProfileScreen -> {
            navController.navigate(FitnessScreen.EditProfile.route)
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowFavoritesScreen -> {
            navController.navigate(FitnessScreen.Favorites.route)
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowPrivacyPolicyScreen -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowSettingsScreen -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowSupportScreen -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowLogoutScreen -> {
            //navController.navigate(FitnessScreen.Profile.route)
            // TODO
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.Empty -> {
            // Nothing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(top = 44.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            viewModel.uiAction(ProfileAction.NavigateBack)
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
                        text = "My Profile",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                AsyncImage(
                    model = uiState.avatarUri ?: com.example.practice.R.mipmap.ic_group1,
                    contentDescription = null,
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = com.example.practice.R.mipmap.ic_group1)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "${uiState.fullName}",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${uiState.email}",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Birthday: April 1st",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            Row(
                modifier = Modifier
                    .offset(y = -(32.dp))
                    .padding(start = 32.dp, end = 32.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${uiState.weight} Kg",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Weight",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .width(1.dp)
                        .height(42.dp)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${uiState.age}",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Years Old",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .width(1.dp)
                        .height(42.dp)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${uiState.height} CM",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Height",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Profile),
                    title = "Profile",
                    onClick = {
                        viewModel.uiAction(ProfileAction.NavigateProfileEditing)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Favorites),
                    title = "Favorite",
                    onClick = {
                        viewModel.uiAction(ProfileAction.NavigateFavorite)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Privacity),
                    title = "Privacy Policy",
                    onClick = {
                        viewModel.uiAction(ProfileAction.NavigatePrivacyPolicy)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Settings),
                    title = "Settings",
                    onClick = {
                        viewModel.uiAction(ProfileAction.NavigateSettings)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.SupportAgent),
                    title = "Help",
                    onClick = {
                        viewModel.uiAction(ProfileAction.NavigateSupport)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Logout),
                    title = "Logout",
                    onClick = {
                        viewModel.uiAction(ProfileAction.NavigateLogout)
                    }
                )
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}