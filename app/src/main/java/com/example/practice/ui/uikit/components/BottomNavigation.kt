package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.practice.FitnessScreen
import io.github.composegears.valkyrie.BookmarkOff
import io.github.composegears.valkyrie.HomeWhite
import io.github.composegears.valkyrie.ResourcesWhite
import io.github.composegears.valkyrie.SupportWhite
import io.github.composegears.valkyrie.Icons

@Composable
fun BottomNavigation(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val iconSize = screenWidth / 12

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            NavIcon(Icons.HomeWhite, iconSize) {
                if (currentRoute != FitnessScreen.Home.route) {
                    navController.navigate(FitnessScreen.Home.route) {
                        popUpTo(FitnessScreen.Home.route) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            }

            NavIcon(Icons.ResourcesWhite, iconSize) {
                if (currentRoute != FitnessScreen.SignUp.route) {
                    navController.navigate(FitnessScreen.SignUp.route)
                }
                // TODO
            }

            NavIcon(Icons.BookmarkOff, iconSize) {
                if (currentRoute != FitnessScreen.LogIn.route) {
                    navController.navigate(FitnessScreen.LogIn.route)
                }
                // TODO
            }

            NavIcon(Icons.SupportWhite, iconSize) {
                if (currentRoute != FitnessScreen.OnBoarding.route) {
                    navController.navigate(FitnessScreen.OnBoarding.route)
                }
                // TODO
            }
        }
    }
}

@Composable
private fun NavIcon(
    icon: ImageVector,
    iconSize: Dp,
    onClick: () -> Unit
) {
    Icon(
        painter = rememberVectorPainter(icon),
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .size(iconSize)
            .clickable { onClick() }
    )
}