package com.example.practice.ui.screens.setup

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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.setup.intents.SetUpAction
import com.example.practice.ui.screens.setup.intents.SetUpSideEffect
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.HeightPicker
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun HeightScreen(
    navController: NavController,
    viewModel: SetUpViewModel
) {
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    var selectedHeight by remember { mutableStateOf(165) }

    when (sideEffect) {
        is SetUpSideEffect.NavigateNext -> {
            navController.navigate(FitnessScreen.Goal.route)
            viewModel.clearSideEffect()
        }

        is SetUpSideEffect.NavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        else -> Unit
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ) {
            Spacer(modifier = Modifier.height(45.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable {
                        viewModel.uiAction(SetUpAction.NavigateBack)
                    }
            ) {
                Spacer(modifier = Modifier.width(24.dp))
                Image(
                    painter = rememberVectorPainter(Icons.Arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(11.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Back",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall,
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "What Is Your height?",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center
                )
            }

            HeightPicker(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) { height ->
                selectedHeight = height
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
        ) {
            AppOutlinedButton(
                modifier = Modifier
                    .width(180.dp)
                    .padding(vertical = 4.dp),
                text = "Continue",
                textStyle = MaterialTheme.typography.titleLarge,
            ) {
                viewModel.uiAction(SetUpAction.HeightEntered(selectedHeight))
            }
        }
    }
}