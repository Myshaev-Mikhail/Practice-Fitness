package com.example.practice.ui.uikit.components

import CommunityOff
import CommunityOn
import NutritionOff
import NutritionOn
import ProgressOn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.practice.R
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.ProgressOff
import io.github.composegears.valkyrie.WorkoutOff
import io.github.composegears.valkyrie.WorkoutOn

@Composable
fun NavBar(
    workout: Boolean = false,
    progressTracking: Boolean = false,
    nutrition: Boolean = false,
    community: Boolean = false,
    onWorkoutClick: () -> Unit,
    onProgressClick: () -> Unit,
    onNutritionClick: () -> Unit,
    onCommunityClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavBarItem(
            selected = workout,
            text = stringResource(R.string.workout),
            icon = if (workout) Icons.WorkoutOn else Icons.WorkoutOff,
            onClick = onWorkoutClick
        )
        NavDivider()
        NavBarItem(
            selected = progressTracking,
            text = stringResource(R.string.progress_tracking),
            icon = if (progressTracking) ProgressOn else ProgressOff,
            onClick = onProgressClick
        )
        NavDivider()
        NavBarItem(
            selected = nutrition,
            text = stringResource(R.string.nutrition),
            icon = if (nutrition) NutritionOn else NutritionOff,
            onClick = onNutritionClick
        )
        NavDivider()
        NavBarItem(
            selected = community,
            text = stringResource(R.string.community),
            icon = if (community) CommunityOn else CommunityOff,
            onClick = onCommunityClick
        )
    }
}

@Composable
private fun RowScope.NavBarItem(
    selected: Boolean,
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(onClick = onClick)
            .padding(horizontal = 2.dp, vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberVectorPainter(image = icon),
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.labelSmall,
            color = if (selected) MaterialTheme.colorScheme.secondary
            else MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun NavDivider() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .width(1.dp)
            .height(56.dp)
    )
}
