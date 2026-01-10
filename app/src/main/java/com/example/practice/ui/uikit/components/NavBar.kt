package com.example.practice.ui.uikit.components

import CommunityOff
import CommunityOn
import NutritionOff
import NutritionOn
import ProgressOn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
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
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, top = 12.dp, end = 12.dp, bottom = 0.dp)
                    .clickable {
                        onWorkoutClick()
                    }
            ) {
                Image(
                    painter = rememberVectorPainter(
                        image = if (workout) Icons.WorkoutOn
                        else Icons.WorkoutOff
                    ),
                    contentDescription = "check",
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Workout",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (workout) MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(2.dp)
                    .height(60.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .clickable {
                        onProgressClick()
                    }
            ) {
                Image(
                    painter = rememberVectorPainter(
                        image = if (progressTracking) ProgressOn
                        else ProgressOff
                    ),
                    contentDescription = "check",
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Progress \n" +
                            "tracking",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (progressTracking) MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(2.dp)
                    .height(60.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .clickable {
                        onNutritionClick()
                    }
            ) {
                Image(
                    painter = rememberVectorPainter(
                        image = if (nutrition) NutritionOn
                        else NutritionOff

                    ),
                    contentDescription = "check",
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Nutrition",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (nutrition) MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(2.dp)
                    .height(60.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, end = 0.dp, bottom = 12.dp)
                    .clickable {
                        onCommunityClick()
                    }
            ) {
                Image(
                    painter = rememberVectorPainter(
                        image = if (community) CommunityOn
                        else CommunityOff
                    ),
                    contentDescription = "check",
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Community",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (community) MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}