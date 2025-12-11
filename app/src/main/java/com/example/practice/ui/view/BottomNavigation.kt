package com.example.practice.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.practice.R
import io.github.composegears.valkyrie.BookmarkOff
import io.github.composegears.valkyrie.HomeWhite
import io.github.composegears.valkyrie.ResourcesWhite
import io.github.composegears.valkyrie.SupportWhite
import io.github.composegears.valkyrie.ValkyrieIcons

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val iconSize = screenWidth / 12

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.purple),
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            NavIcon(ValkyrieIcons.HomeWhite, iconSize)
            NavIcon(ValkyrieIcons.ResourcesWhite, iconSize)
            NavIcon(ValkyrieIcons.BookmarkOff, iconSize)
            NavIcon(ValkyrieIcons.SupportWhite, iconSize)
        }
    }
}

@Composable
private fun NavIcon(icon: ImageVector, iconSize: Dp) {
    Icon(
        painter = rememberVectorPainter(icon),
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .size(iconSize)
    )
}
