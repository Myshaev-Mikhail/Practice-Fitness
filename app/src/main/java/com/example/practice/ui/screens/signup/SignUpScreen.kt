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
import com.example.practice.ui.screens.signup.actions.SignUpAction
import com.example.practice.ui.screens.signup.actions.SignUpSideEffect
import com.example.practice.ui.screens.signup.actions.SignUpState
import com.example.practice.ui.utils.findActivity
import com.example.practice.ui.utils.localizedAppText
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.LanguageSwitcher
import com.example.practice.ui.uikit.components.SignUp
import com.example.practice.ui.uikit.theme.FitnessTheme
import io.github.composegears.valkyrie.GoogleIcon
import io.github.composegears.valkyrie.Icons
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    navController: NavController
) {
    val viewModel: SignUpViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current
    val googleAuthContext = LocalView.current.context.findActivity() ?: context
    val dataStore = context.userProfileDataStore
    val selectedLanguage by dataStore.languageFlow.collectAsState(initial = "en")
    val coroutineScope = rememberCoroutineScope()

    val fullNameFocusRequester = remember { FocusRequester() }
    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    val confirmPasswordFocusRequester = remember { FocusRequester() }

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is SignUpSideEffect.Success -> {
                navController.navigate(FitnessScreen.SetUp.route)
                viewModel.clearSideEffect()
            }

            is SignUpSideEffect.ShowToast -> {
                Toast.makeText(
                    context,
                    context.localizedAppText((sideEffect as SignUpSideEffect.ShowToast).text),
                    Toast.LENGTH_SHORT
                ).show()

                if (uiState.fullName.isEmpty()) {
                    fullNameFocusRequester.requestFocus()
                } else if (uiState.email.isEmpty()) {
                    emailFocusRequester.requestFocus()
                } else if (uiState.password.isEmpty()) {
                    passwordFocusRequester.requestFocus()
                } else {
                    confirmPasswordFocusRequester.requestFocus()
                }

                viewModel.clearSideEffect()
            }

            else -> Unit
        }
    }

    SignUpContentScreen(
        uiState = uiState,
        fullNameFocusRequester = fullNameFocusRequester,
        emailFocusRequester = emailFocusRequester,
        passwordFocusRequester = passwordFocusRequester,
        confirmPasswordFocusRequester = confirmPasswordFocusRequester,
        onFullNameChange = {
            val normalized = viewModel.normalizeText(it)
            viewModel.handleUiAction(SignUpAction.FullNameChanged(normalized))
        },
        onEmailChange = {
            val normalized = viewModel.normalizeText(it)
            viewModel.handleUiAction(SignUpAction.EmailChanged(normalized))
        },
        onPasswordChange = {
            val normalized = viewModel.normalizeText(it)
            viewModel.handleUiAction(SignUpAction.PasswordChanged(normalized))
        },
        onConfirmPasswordChange = {
            val normalized = viewModel.normalizeText(it)
            viewModel.handleUiAction(SignUpAction.ConfirmPasswordChanged(normalized))
        },
        onEmailSignUp = {
            viewModel.handleUiAction(SignUpAction.EmailSignUpClicked, context)
        },
        onGoogleSignUp = {
            viewModel.handleUiAction(SignUpAction.GoogleLogInClicked, googleAuthContext)
        },
        onLogInClick = {
            navController.navigate(FitnessScreen.LogIn.route)
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
fun SignUpContentScreen(
    uiState: SignUpState,
    fullNameFocusRequester: FocusRequester,
    emailFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
    confirmPasswordFocusRequester: FocusRequester,
    onFullNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onEmailSignUp: () -> Unit,
    onGoogleSignUp: () -> Unit,
    onLogInClick: () -> Unit,
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
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            LanguageSwitcher(
                modifier = Modifier.align(Alignment.End).padding(end = 24.dp),
                selectedLanguage = selectedLanguage,
                onLanguageSelected = onLanguageSelected
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.signup_create_account),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.signup_lets_start),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            SignUp(
                modifier = Modifier.fillMaxWidth(),
                fullName = uiState.fullName,
                email = uiState.email,
                password = uiState.password,
                confirmPassword = uiState.confirmPassword,
                fullNameFocusRequester = fullNameFocusRequester,
                emailFocusRequester = emailFocusRequester,
                passwordFocusRequester = passwordFocusRequester,
                confirmPasswordFocusRequester = confirmPasswordFocusRequester,
                onFullNameChange = onFullNameChange,
                onEmailChange = onEmailChange,
                onPasswordChange = onPasswordChange,
                onConfirmPasswordChange = onConfirmPasswordChange
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.signup_terms),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            AppOutlinedButton(
                modifier = Modifier.width(190.dp),
                text = stringResource(R.string.signup_button),
                textColor = MaterialTheme.colorScheme.onPrimary
            ) {
                onEmailSignUp()
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.signup_or_sign_up_with),
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
                        .clickable {
                            onGoogleSignUp()
                        }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = stringResource(R.string.signup_already_have_account),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.signup_log_in),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clickable {
                        onLogInClick()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val fullNameFocusRequester = remember { FocusRequester() }
    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    val confirmPasswordFocusRequester = remember { FocusRequester() }
    var previewLanguage by remember { mutableStateOf("en") }

    FitnessTheme(true) {
        SignUpContentScreen(
            uiState = SignUpState(),
            fullNameFocusRequester = fullNameFocusRequester,
            emailFocusRequester = emailFocusRequester,
            passwordFocusRequester = passwordFocusRequester,
            confirmPasswordFocusRequester = confirmPasswordFocusRequester,
            onFullNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onEmailSignUp = {},
            onGoogleSignUp = {},
            onLogInClick = {},
            selectedLanguage = previewLanguage,
            onLanguageSelected = { previewLanguage = it }
        )
    }
}
