package com.example.practice.ui.screens.signin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.screens.signin.intents.SignUpAction
import com.example.practice.ui.screens.signin.intents.SignUpSideEffect
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
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
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
                .align(Alignment.TopCenter)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Account",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "let's start!",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
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
        }

        Column(
            modifier = Modifier
                .padding(bottom = 48.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "By continuing, you agree to \n" +
                        " Terms of Use and Privacy Policy.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            )
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
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = rememberVectorPainter(Icons.GoogleIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .padding(4.dp)
                )
                Image(
                    painter = rememberVectorPainter(Icons.Facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .padding(4.dp)
                )
                Image(
                    painter = rememberVectorPainter(Icons.FingerprintIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .padding(4.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row() {
                Text(
                    text = "Already have an account?",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
