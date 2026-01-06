package com.example.practice.ui.screens.forgotpassword

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.screens.forgotpassword.intents.ForgottenPasswordAction
import com.example.practice.ui.screens.forgotpassword.intents.ForgottenPasswordSideEffect
import com.example.practice.ui.uikit.components.AppOutlinedButton
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun ForgottenPasswordScreen(
    navController: NavController
) {
    val viewModel: ForgottenPasswordViewModel = viewModel()
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is ForgottenPasswordSideEffect.ShowToast -> {
                Toast.makeText(
                    context,
                    (sideEffect as ForgottenPasswordSideEffect.ShowToast).message,
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.clearSideEffect()
            }

            is ForgottenPasswordSideEffect.Success -> {
                viewModel.clearSideEffect()
            }

            is ForgottenPasswordSideEffect.NavigateBack -> {
                navController.popBackStack()
                viewModel.clearSideEffect()
            }

            else -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(44.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberVectorPainter(Icons.Arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            viewModel.uiAction(ForgottenPasswordAction.BackClicked)
                        }
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Forgotten Password",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Forgot Password?",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(40.dp),
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 24.dp, vertical = 32.dp)
            ) {
                Text(
                    text = "Enter your email address",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(6.dp))

                BasicTextField(
                    value = state.email,
                    onValueChange = {
                        viewModel.uiAction(ForgottenPasswordAction.EmailChanged(it))
                    },
                    textStyle = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onSecondary
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(24.dp))
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(bottom = 48.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppOutlinedButton(
                modifier = Modifier.width(185.dp),
                text = "Continue",
                textColor = MaterialTheme.colorScheme.onPrimary
            ) {
                viewModel.uiAction(ForgottenPasswordAction.SendClicked)
            }
        }
    }
}