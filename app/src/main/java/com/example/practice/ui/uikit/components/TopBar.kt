package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.BellNotificationOff
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.SearchOff
import io.github.composegears.valkyrie.UserOff

@Composable
fun TopBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp)
                    .clickable {
                        navController.popBackStack()
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
                    text = title,
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
                            //navController.navigate(FitnessScreen.Profile.route)
                            // TODO
                        }
                )
                Image(
                    painter = rememberVectorPainter(image = Icons.BellNotificationOff),
                    contentDescription = "notification",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable {
                            navController.navigate(FitnessScreen.NotificationSetting.route)
                        }
                )
                Image(
                    painter = rememberVectorPainter(image = Icons.UserOff),
                    contentDescription = "profile_user",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable {
                            navController.navigate(FitnessScreen.Profile.route)
                        }
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}