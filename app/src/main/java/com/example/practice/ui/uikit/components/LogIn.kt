package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp

@Composable
fun LogIn(
    email: String,
    password: String,
    emailFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPassword: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            text = "Username or email",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        BasicTextField(
            value = email,
            onValueChange = onEmailChange,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            textStyle = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(emailFocusRequester)
                .background(Color.White, RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Password",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        BasicTextField(
            value = password,
            onValueChange = onPasswordChange,
            textStyle = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(passwordFocusRequester)
                .background(Color.White, RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forgot Password?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                     onForgotPassword()
                }
        )
    }
}