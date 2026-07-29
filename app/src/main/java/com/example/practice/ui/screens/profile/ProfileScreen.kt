package com.example.practice.ui.screens.profile

import android.widget.Toast
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.profile.actions.ProfileAction
import com.example.practice.ui.screens.profile.actions.ProfileSideEffect
import com.example.practice.ui.screens.settings.actions.SettingsSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.DeleteAccountDialog
import com.example.practice.ui.uikit.components.ProfileMenuItem
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Favorites
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Logout
import io.github.composegears.valkyrie.Privacity
import io.github.composegears.valkyrie.Profile
import io.github.composegears.valkyrie.Settings
import io.github.composegears.valkyrie.SupportAgent
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val viewModel: ProfileViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val context = LocalContext.current
    var showDeleteDialog by remember { mutableStateOf(false) }

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
            navController.navigate(FitnessScreen.PrivacyPolicy.route)
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowSettingsScreen -> {
            navController.navigate(FitnessScreen.Settings.route)
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowHelpScreen -> {
            navController.navigate(FitnessScreen.Help.route)
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowLogoutScreen -> {
            navController.navigate(FitnessScreen.OnBoarding.route) {
                popUpTo(0)
            }
            viewModel.clearSideEffect()
        }

        is ProfileSideEffect.ShowError -> {
            val message = (sideEffect as SettingsSideEffect.ShowError).throwable.message ?: "Unknown error"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
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
                            viewModel.handleUiAction(ProfileAction.NavigateBack)
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
                        viewModel.handleUiAction(ProfileAction.NavigateProfileEditing)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Favorites),
                    title = "Favorite",
                    onClick = {
                        viewModel.handleUiAction(ProfileAction.NavigateFavorite)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Privacity),
                    title = "Privacy Policy",
                    onClick = {
                        viewModel.handleUiAction(ProfileAction.NavigatePrivacyPolicy)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Settings),
                    title = "Settings",
                    onClick = {
                        viewModel.handleUiAction(ProfileAction.NavigateSettings)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.SupportAgent),
                    title = "Help",
                    onClick = {
                        viewModel.handleUiAction(ProfileAction.NavigateHelp)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Logout),
                    title = "Logout",
                    onClick = {
                        showDeleteDialog = true
                    }
                )
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        if (showDeleteDialog) {
            DeleteAccountDialog(
                titleText = "Are you sure you want to log out?",
                delAccount = "Yes, logout",
                onCancel = { showDeleteDialog = false },
                onConfirm = {
                    showDeleteDialog = false
                    viewModel.handleUiAction(ProfileAction.NavigateLogout)
                }
            )
        }
    }
}