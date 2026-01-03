package com.example.practice.ui.screens.signup

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.FitnessScreen
import com.example.practice.ui.screens.signup.intents.SignUpAction
import com.example.practice.ui.screens.signup.intents.SignUpSideEffect
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.SignUp
import io.github.composegears.valkyrie.Facebook
import io.github.composegears.valkyrie.FingerprintIcon
import io.github.composegears.valkyrie.GoogleIcon
import io.github.composegears.valkyrie.Icons

@Composable
fun SignUpScreen(
    navController: NavController
) {
    val viewModel: SignUpViewModel = viewModel()
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is SignUpSideEffect.Success -> {
                navController.navigate(FitnessScreen.SignUp.route)
                // TODO
            }
            is SignUpSideEffect.ShowToast -> {
                Toast.makeText(context, (sideEffect as SignUpSideEffect.ShowToast).text, Toast.LENGTH_SHORT).show()
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
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Create Account",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "let's start!",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            SignUp(
                modifier = Modifier.fillMaxWidth(),
                email = state.email,
                password = state.password,
                confirmPassword = state.confirmPassword,
                onEmailChange = {
                    viewModel.uiAction(SignUpAction.EmailChanged(it))
                },
                onPasswordChange = {
                    viewModel.uiAction(SignUpAction.PasswordChanged(it))
                },
                onConfirmPasswordChange = {
                    viewModel.uiAction(SignUpAction.ConfirmPasswordChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "By continuing, you agree to \n" +
                        " Terms of Use and Privacy Policy.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            AppOutlinedButton(
                modifier = Modifier.width(185.dp),
                text = "Sign Up",
                textColor = MaterialTheme.colorScheme.onPrimary
            ) {
                viewModel.uiAction(SignUpAction.SignUpClicked)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "or sign up with",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.outline
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = rememberVectorPainter(Icons.GoogleIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)

                )
                Image(
                    painter = rememberVectorPainter(Icons.Facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)

                )
                Image(
                    painter = rememberVectorPainter(Icons.FingerprintIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)

                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row() {
                Text(
                    text = "Already have an account?",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clickable {
                        navController.navigate(FitnessScreen.LogIn.route)
                    }
                )
            }
        }
    }
}