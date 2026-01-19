package com.example.practice.ui.screens.passwordsetting

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.passwordsetting.intents.PasswordSettingAction
import com.example.practice.ui.screens.passwordsetting.intents.PasswordSettingSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.FormForPassword
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun PasswordSettingScreen(
    navController: NavController
) {
    val viewModel: PasswordSettingViewModel = viewModel()
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val context = LocalContext.current

    when (sideEffect) {
        is PasswordSettingSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }
        is PasswordSettingSideEffect.ShowForgottenPasswordScreen -> {
            navController.navigate(FitnessScreen.ForgottenPassword.route)
            viewModel.clearSideEffect()
        }
        is PasswordSettingSideEffect.ShowToast -> {
            Toast.makeText(context, (sideEffect as PasswordSettingSideEffect.ShowToast).message, Toast.LENGTH_LONG).show()
            viewModel.clearSideEffect()
        }
        is PasswordSettingSideEffect.Empty -> {
            // Nothing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 52.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            viewModel.uiAction(PasswordSettingAction.NavigateBack)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(Icons.Arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Notifications Settings",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                FormForPassword(
                    currentPassword = state.currentPassword,
                    newPassword = state.newPassword,
                    confirmNewPassword = state.confirmNewPassword,
                    onCurrentPasswordChange = {
                        viewModel.uiAction(
                            PasswordSettingAction.CurrentPasswordChanged(it)
                        )
                    },
                    onForgotPassword = {
                        viewModel.uiAction(
                            PasswordSettingAction.ForgotPasswordClicked
                        )
                    },
                    onNewPasswordChange = {
                        viewModel.uiAction(
                            PasswordSettingAction.NewPasswordChanged(it)
                        )
                    },

                    onConfirmNewPasswordChange = {
                        viewModel.uiAction(
                            PasswordSettingAction.ConfirmNewPasswordChanged(it)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.weight(1f))

                AppButton(
                    modifier = Modifier.width(185.dp).align(Alignment.CenterHorizontally),
                    text = "Change Password",
                    textColor = MaterialTheme.colorScheme.onSecondary,
                    textStyle = MaterialTheme.typography.headlineSmall,
                    buttonColor = MaterialTheme.colorScheme.secondary,
                ) {
                    viewModel.uiAction(PasswordSettingAction.ChangePasswordClicked)
                }
                Spacer(modifier = Modifier.height(44.dp))
                BottomNavigation(
                    navController = navController
                )
            }
        }
    }
}