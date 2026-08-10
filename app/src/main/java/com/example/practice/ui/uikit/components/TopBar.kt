package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.utils.localizedAppText
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
    val context = LocalContext.current

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        val titleMaxWidth = maxWidth * 0.5f

        Row(
            modifier = Modifier
                .width(titleMaxWidth)
                .align(Alignment.CenterStart)
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
                modifier = Modifier.weight(1f),
                text = context.localizedAppText(title),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge.copy(
                    lineBreak = LineBreak.Paragraph
                )
            )
        }

        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
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
    Spacer(modifier = Modifier.height(12.dp))
}
