package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.LeagueSpartan
import com.example.practice.ui.uikit.theme.Poppins

@Composable
fun LogIn(
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            text = "Username or email",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            textStyle = TextStyle(
                fontFamily = Poppins,
                fontWeight = Normal,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondary
            ),
            placeholder = {
                Text(
                    text = "Email",
                    fontFamily = LeagueSpartan,
                    fontWeight = Light,
                    fontSize = 14.sp
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Password",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            textStyle = TextStyle(
                fontFamily = Poppins,
                fontWeight = Normal,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondary
            ),
            placeholder = {
                Text(
                    text = "Password",
                    fontFamily = LeagueSpartan,
                    fontWeight = Light,
                    fontSize = 14.sp
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forgot Password?",
            fontFamily = Poppins,
            fontWeight = Medium,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.align(Alignment.End)
        )
    }
}