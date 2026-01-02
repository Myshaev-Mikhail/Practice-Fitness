package com.example.practice.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.LogIn
import io.github.composegears.valkyrie.Facebook
import io.github.composegears.valkyrie.FingerprintIcon
import io.github.composegears.valkyrie.GoogleIcon
import io.github.composegears.valkyrie.Icons

@Composable
fun LogInScreen(
    navController: NavController
) {
    val viewModel: LogInViewModel = viewModel()
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
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
                text = "Log In",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Welcome",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier.padding(48.dp),
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
            LogIn()
        }

        Column(
            modifier = Modifier
                .padding(bottom = 48.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppOutlinedButton(
                modifier = Modifier.width(185.dp),
                text = "Log In",
                textColor = MaterialTheme.colorScheme.onPrimary
            ) {
                // TODO
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "or sign up with",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(16.dp))
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
            Spacer(modifier = Modifier.height(52.dp))
            Row() {
                Text(
                    text = "oDon’t have an account?",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
