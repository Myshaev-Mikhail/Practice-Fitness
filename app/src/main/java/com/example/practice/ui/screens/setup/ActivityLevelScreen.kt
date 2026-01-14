package com.example.practice.ui.screens.setup

import android.widget.Toast
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.domain.models.ActivityLevel
import com.example.practice.ui.screens.setup.intents.SetUpAction
import com.example.practice.ui.screens.setup.intents.SetUpSideEffect
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.AppToggleButton
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun ActivityLevelScreen(
    navController: NavController,
    viewModel: SetUpViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val context = LocalContext.current
    val selectedActivityLevel = uiState.activityLevel

    when (sideEffect) {
        is SetUpSideEffect.NavigateNext -> {
            navController.navigate(FitnessScreen.FillYourProfile.route)
            viewModel.clearSideEffect()
        }

        is SetUpSideEffect.NavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is SetUpSideEffect.ShowToast -> {
            Toast.makeText(context, (sideEffect as SetUpSideEffect.ShowToast).text, Toast.LENGTH_SHORT).show()
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
                    text = "Physical Activity Level",
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
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                AppToggleButton(
                    text = "Beginner",
                    isSelected = selectedActivityLevel == ActivityLevel.BEGINNER,
                    onClick = {
                        viewModel.uiAction(SetUpAction.ActivitySelected(ActivityLevel.BEGINNER))
                    },
                )
                Spacer(modifier = Modifier.height(28.dp))
                AppToggleButton(
                    text = "Intermediate",
                    isSelected = selectedActivityLevel == ActivityLevel.INTERMEDIATE,
                    onClick = {
                        viewModel.uiAction(SetUpAction.ActivitySelected(ActivityLevel.INTERMEDIATE))
                    },
                )
                Spacer(modifier = Modifier.height(28.dp))
                AppToggleButton(
                    text = "Advance",
                    isSelected = selectedActivityLevel == ActivityLevel.ADVANCED,
                    onClick = {
                        viewModel.uiAction(SetUpAction.ActivitySelected(ActivityLevel.ADVANCED))
                    },
                )
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
                viewModel.uiAction(SetUpAction.ContinueClickedActivityLevel)
            }
        }
    }
}