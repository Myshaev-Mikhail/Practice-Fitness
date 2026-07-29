package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.practice.R

@Composable
fun FormForEfitProfile(
    fullName: String = "",
    email: String,
    mobileNumber: String,
    date: String,
    weight: String,
    height: String,
    onFullNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onMobileNumberChange: (String) -> Unit,
    onDateChange: (String) -> Unit,
    onWeightChange: (String) -> Unit,
    onHeightChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.full_name),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = fullName,
            onValueChange = onFullNameChange,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.email),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = email,
            onValueChange = onEmailChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.mobile_number),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = mobileNumber,
            onValueChange = onMobileNumberChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone,
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.years_old_label),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = date,
            onValueChange = onDateChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.weight),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = stringResource(R.string.weight_kg_value, weight),
            onValueChange = onWeightChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.height),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = stringResource(R.string.height_cm_value, height),
            onValueChange = onHeightChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
            ),
            textStyle = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSecondary
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        )
    }
}
