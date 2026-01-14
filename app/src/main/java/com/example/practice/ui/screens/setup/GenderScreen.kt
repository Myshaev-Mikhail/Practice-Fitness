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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.domain.models.Gender
import com.example.practice.ui.screens.setup.intents.SetUpAction
import com.example.practice.ui.screens.setup.intents.SetUpSideEffect
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.GenderItem
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.FemaleOff
import io.github.composegears.valkyrie.FemaleOn
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.MaleOff
import io.github.composegears.valkyrie.Property1MaleOn

@Composable
fun GenderScreen(
    navController: NavController,
    viewModel: SetUpViewModel
) {
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val context = LocalContext.current
    val selectedGender = state.gender

    when (sideEffect) {
        is SetUpSideEffect.NavigateNext -> {
            navController.navigate(FitnessScreen.Age.route)
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
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

        Text(
            text = "What’s Your Gender",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(16.dp)
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                        " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column {
            GenderItem(
                isSelected = selectedGender == Gender.MALE,
                icon = if (selectedGender == Gender.MALE)
                    Icons.Property1MaleOn else Icons.MaleOff,
                text = "Male",
                iconSize = 150.dp,
                onClick = {
                    viewModel.uiAction(SetUpAction.GenderSelected(Gender.MALE))
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            GenderItem(
                isSelected = selectedGender == Gender.FEMALE,
                icon = if (selectedGender == Gender.FEMALE)
                    Icons.FemaleOn else Icons.FemaleOff,
                text = "Female",
                iconSize = 150.dp,
                onClick = {
                    viewModel.uiAction(SetUpAction.GenderSelected(Gender.FEMALE))
                }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        AppOutlinedButton(
            modifier = Modifier
                .width(180.dp)
                .padding(vertical = 4.dp),
            text = "Continue",
            textStyle = MaterialTheme.typography.titleLarge,
        ) {
            viewModel.uiAction(SetUpAction.ContinueClickedGender)
        }
    }
}