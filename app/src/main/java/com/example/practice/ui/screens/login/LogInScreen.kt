package com.example.practice.ui.screens.login

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.R
import com.example.practice.FitnessScreen
import com.example.practice.extensions.userProfileDataStore
import com.example.practice.ui.screens.login.actions.LogInAction
import com.example.practice.ui.screens.login.actions.LogInSideEffect
import com.example.practice.ui.screens.login.actions.LogInState
import com.example.practice.ui.utils.findActivity
import com.example.practice.ui.utils.localizedAppText
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.LanguageSwitcher
import com.example.practice.ui.uikit.components.LogIn
import com.example.practice.ui.uikit.theme.FitnessTheme
import io.github.composegears.valkyrie.GoogleIcon
import io.github.composegears.valkyrie.Icons
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LogInScreen(
    navController: NavController
) {
    val viewModel: LogInViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current
    val googleAuthContext = LocalView.current.context.findActivity() ?: context
    val dataStore = context.userProfileDataStore
    val selectedLanguage by dataStore.languageFlow.collectAsState(initial = "en")
    val coroutineScope = rememberCoroutineScope()

    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is LogInSideEffect.Success -> {
                navController.navigate(FitnessScreen.Home.route)
                viewModel.clearSideEffect()
            }

            is LogInSideEffect.ShowToast -> {
                Toast.makeText(
                    context,
                    context.localizedAppText((sideEffect as LogInSideEffect.ShowToast).text),
                    Toast.LENGTH_SHORT
                ).show()

                if (uiState.email.isEmpty()) {
                    emailFocusRequester.requestFocus()
                } else if (uiState.password.isEmpty()) {
                    passwordFocusRequester.requestFocus()
                }

                viewModel.clearSideEffect()
            }

            is LogInSideEffect.ShowForgottenPasswordScreen -> {
                navController.navigate(FitnessScreen.ForgottenPassword.route)
                viewModel.clearSideEffect()
            }

            is LogInSideEffect.ShowSignInScreen -> {
                navController.navigate(FitnessScreen.SignUp.route)
                viewModel.clearSideEffect()
            }

            is LogInSideEffect.Empty -> {
                // Nothing
            }
        }
    }
    LogInContentScreen(
        uiState = uiState,
        emailFocusRequester = emailFocusRequester,
        passwordFocusRequester = passwordFocusRequester,
        onEmailChange = {
            viewModel.handleUiAction(LogInAction.EmailChanged(it))
        },
        onPasswordChange = {
            viewModel.handleUiAction(LogInAction.PasswordChanged(it))
        },
        onForgotPassword = {
            viewModel.handleUiAction(LogInAction.ForgotPasswordClicked)
        },
        onEmailLogIn = {
            viewModel.handleUiAction(LogInAction.EmailLogInClicked, context)
        },
        onGoogleLogIn = {
            viewModel.handleUiAction(LogInAction.GoogleLogInClicked, googleAuthContext)
        },
        onSignUpClick = {
            viewModel.handleUiAction(LogInAction.SignInClicked)
        },
        selectedLanguage = selectedLanguage,
        onLanguageSelected = { language ->
            coroutineScope.launch {
                dataStore.setLanguage(language)
            }
        }
    )
}

@Composable
fun LogInContentScreen(
    uiState: LogInState,
    emailFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPassword: () -> Unit,
    onEmailLogIn: () -> Unit,
    onGoogleLogIn: () -> Unit,
    onSignUpClick: () -> Unit,
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit
) {
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
            Spacer(modifier = Modifier.height(24.dp))
            LanguageSwitcher(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 24.dp),
                selectedLanguage = selectedLanguage,
                onLanguageSelected = onLanguageSelected
            )
            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = stringResource(R.string.login_title),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.login_welcome),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(28.dp),
                text = stringResource(R.string.login_description),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )


            Box(
                contentAlignment = Alignment.Center
            ) {
                LogIn(
                    modifier = Modifier.fillMaxWidth(),
                    email = uiState.email,
                    password = uiState.password,
                    emailFocusRequester = emailFocusRequester,
                    passwordFocusRequester = passwordFocusRequester,
                    onEmailChange = onEmailChange,
                    onPasswordChange = onPasswordChange,
                    onForgotPassword = onForgotPassword
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            AppOutlinedButton(
                modifier = Modifier.width(185.dp),
                text = stringResource(R.string.login_title),
                textColor = MaterialTheme.colorScheme.onPrimary
            ) {
                onEmailLogIn()
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.login_or_sign_up_with),
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
                        .padding(8.dp)
                        .size(40.dp)
                        .clickable {
                            onGoogleLogIn()
                        }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = stringResource(R.string.login_no_account),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.login_sign_up),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clickable {
                        onSignUpClick()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogInScreenPreview() {
    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    var previewLanguage by remember { mutableStateOf("en") }

    FitnessTheme(true) {
        LogInContentScreen(
            uiState = LogInState(
                email = "",
                password = "",
                isLoading = false,
                error = null
            ),
            emailFocusRequester = emailFocusRequester,
            passwordFocusRequester = passwordFocusRequester,
            onEmailChange = {},
            onPasswordChange = {},
            onForgotPassword = {},
            onEmailLogIn = {},
            onGoogleLogIn = {},
            onSignUpClick = {},
            selectedLanguage = previewLanguage,
            onLanguageSelected = { previewLanguage = it }
        )
    }
}
