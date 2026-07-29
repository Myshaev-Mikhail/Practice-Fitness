package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.practice.ui.utils.localizedAppText

@Composable
fun DeleteAccountDialog(
    titleText: String = "Are you sure you want to Delete Account?",
    cancelText: String = "Cancel",
    delAccount: String = "Yes, Del account",
    onCancel: () -> Unit,
    onConfirm: () -> Unit
) {
    val context = LocalContext.current

    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.4f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onCancel()
                    }
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp
                        )
                    )
                    .padding(
                        horizontal = 24.dp,
                        vertical = 32.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = context.localizedAppText(titleText),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppButton(
                        modifier = Modifier.weight(1f),
                        text = cancelText,
                        textColor = MaterialTheme.colorScheme.primary,
                        textStyle = MaterialTheme.typography.headlineSmall,
                        buttonColor = MaterialTheme.colorScheme.onPrimary,
                        onClick = onCancel
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    AppButton(
                        modifier = Modifier.weight(1f),
                        text = delAccount,
                        textColor = MaterialTheme.colorScheme.onSecondary,
                        textStyle = MaterialTheme.typography.headlineSmall,
                        buttonColor = MaterialTheme.colorScheme.secondary,
                        onClick = onConfirm
                    )
                }
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}
