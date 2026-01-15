package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practice.ui.utils.cropAndSaveAvatar

@Composable
fun AvatarCrop(
    imageUri: String,
    onConfirm: (String) -> Unit,
    onCancel: () -> Unit
) {
    val context = LocalContext.current

    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    val cropSizeDp = 260f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(cropSizeDp.dp)
                .clip(CircleShape)
                .background(Color.DarkGray)
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale = (scale * zoom).coerceIn(1f, 4f)
                        offset += pan
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = imageUri,
                contentDescription = null,
                modifier = Modifier.graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offset.x
                    translationY = offset.y
                }
            )
        }

        Spacer(Modifier.height(24.dp))

        Row {
            Button(onClick = onCancel) {
                Text("Back")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                val finalUri = cropAndSaveAvatar(
                    context,
                    imageUri,
                    scale,
                    offset,
                    cropSizeDp
                )
                onConfirm(finalUri)
            }) {
                Text("Next")
            }
        }
    }
}