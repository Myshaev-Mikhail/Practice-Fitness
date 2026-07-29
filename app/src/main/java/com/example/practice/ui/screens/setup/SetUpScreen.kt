package com.example.practice.ui.screens.setup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.ui.screens.setup.actions.SetUpAction
import com.example.practice.ui.screens.setup.actions.SetUpSideEffect
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.theme.Poppins
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetUpScreen(
    navController: NavController,
    viewModel: SetUpViewModel
) {
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is SetUpSideEffect.ShowGenderScreen -> {
                viewModel.clearSideEffect()
                navController.navigate(FitnessScreen.Gender.route)
            }

            else -> Unit
        }
    }

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val heightImage = screenHeight / 2 + screenHeight / 15

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.mipmap.beautiful_young_sporty_woman_training_workout_gym_4),
            contentDescription = "Workout Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(heightImage),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.setup_quote),
            color = MaterialTheme.colorScheme.secondary,
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = Medium,
                fontSize = 26.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.setup_description),
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        AppOutlinedButton(
            modifier = Modifier
                .width(180.dp)
                .padding(vertical = 4.dp),
            text = stringResource(R.string.next),
            textStyle = MaterialTheme.typography.titleLarge
        ) {
            viewModel.handleUiAction(SetUpAction.StartSetUp)
        }
    }
}
