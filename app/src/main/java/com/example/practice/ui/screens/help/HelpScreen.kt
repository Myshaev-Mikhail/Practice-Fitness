package com.example.practice.ui.screens.help

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.screens.help.actions.HelpAction
import com.example.practice.ui.screens.help.actions.HelpSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.ProfileMenuItem
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Globe
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Telegram
import org.koin.androidx.compose.koinViewModel

@Composable
fun HelpScreen(
    navController: NavController
) {
    val viewModel: HelpViewModel = koinViewModel()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current

    when (sideEffect) {
        is HelpSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is HelpSideEffect.ShowNavigateTelegram -> {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://t.me/lebensmude_spotter")
            )
            context.startActivity(intent)
            viewModel.clearSideEffect()
        }

        is HelpSideEffect.ShowNavigateEmail -> {
            val intent = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("mailto:mikhailmyshaev@gmail.com")
            )
            context.startActivity(intent)
            viewModel.clearSideEffect()
        }

        is HelpSideEffect.Empty -> {
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
                    .padding(top = 52.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            viewModel.handleUiAction(HelpAction.NavigateBack)
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
                        text = "Help & FAQs",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "How Can We Help You?",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Telegram),
                    title = "Telegram",
                    onClick = {
                        viewModel.handleUiAction(HelpAction.NavigateTelegram)
                    }
                )
                ProfileMenuItem(
                    icon = rememberVectorPainter(Icons.Globe),
                    title = "Email",
                    onClick = {
                        viewModel.handleUiAction(HelpAction.NavigateEmail)
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