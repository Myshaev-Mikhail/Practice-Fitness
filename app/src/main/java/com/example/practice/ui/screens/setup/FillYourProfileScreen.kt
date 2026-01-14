package com.example.practice.ui.screens.setup

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.setup.intents.SetUpAction
import com.example.practice.ui.screens.setup.intents.SetUpProfile
import com.example.practice.ui.screens.setup.intents.SetUpSideEffect
import com.example.practice.ui.screens.signup.intents.SignUpSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.FillYourProfile
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun FillYourProfileScreen(
    navController: NavController,
    viewModel: SetUpViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val profile = uiState.profile ?: SetUpProfile()
    val scrollState = rememberScrollState()

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            viewModel.uiAction(SetUpAction.ProfileChanged(profile.copy(avatarUri = it.toString())))
        }
    }

    val fullNameFocusRequester = remember { FocusRequester() }
    val nicknameFocusRequester = remember { FocusRequester() }
    val emailFocusRequester = remember { FocusRequester() }
    val mobileNumberFocusRequester = remember { FocusRequester() }

    when (sideEffect) {

        is SetUpSideEffect.NavigateNext -> {
            navController.navigate(FitnessScreen.Home.route)
            viewModel.clearSideEffect()
        }

        is SetUpSideEffect.NavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is SetUpSideEffect.ShowProfileValidationError -> {
            Toast.makeText(context, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            viewModel.clearSideEffect()
        }
        is SetUpSideEffect.ShowToast -> {
            Toast.makeText(context, (sideEffect as SetUpSideEffect.ShowToast).text, Toast.LENGTH_SHORT).show()

            if (profile.fullName.isNullOrEmpty()) {
                fullNameFocusRequester.requestFocus()
            } else if (profile.nickname.isNullOrEmpty()) {
                nicknameFocusRequester.requestFocus()
            } else if (profile.email.isNullOrEmpty()) {
                emailFocusRequester.requestFocus()
            } else {
                mobileNumberFocusRequester.requestFocus()
            }

            viewModel.clearSideEffect()
        }


        is SetUpSideEffect.NavigateToHome -> {
            navController.navigate(FitnessScreen.Home.route) {
                popUpTo(0) { inclusive = true }
            }
            viewModel.clearSideEffect()
        }

        else -> Unit
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .imePadding()
            .background(MaterialTheme.colorScheme.background)
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

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Fill Your Profile",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                    " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        FillYourProfile(
            avatarUri = profile.avatarUri,
            onAvatarClick = { launcher.launch("image/*") },
            fullName = profile.fullName.orEmpty(),
            nickname = profile.nickname.orEmpty(),
            email = profile.email.orEmpty(),
            mobileNumber = profile.mobileNumber.orEmpty(),
            fullNameFocusRequester = fullNameFocusRequester,
            nicknameFocusRequester = nicknameFocusRequester,
            emailFocusRequester = emailFocusRequester,
            mobileNumberFocusRequester = mobileNumberFocusRequester,
            onFullNameChange = {
                viewModel.uiAction(SetUpAction.ProfileChanged(profile.copy(fullName = it)))
            },
            onNicknameChange = {
                viewModel.uiAction(SetUpAction.ProfileChanged(profile.copy(nickname = it)))
            },
            onEmailChange = {
                viewModel.uiAction(SetUpAction.ProfileChanged(profile.copy(email = it)))
            },
            onMobileNumberChange = {
                viewModel.uiAction(SetUpAction.ProfileChanged(profile.copy(mobileNumber = it)))
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        AppButton(
            modifier = Modifier
                .width(180.dp)
                .padding(vertical = 4.dp)
                .align(Alignment.CenterHorizontally),
            text = "Start",
            textStyle = MaterialTheme.typography.headlineMedium,
            textColor = MaterialTheme.colorScheme.outlineVariant,
            buttonColor = MaterialTheme.colorScheme.secondary
        ) {
            viewModel.uiAction(SetUpAction.SaveProfile)
        }
    }
}