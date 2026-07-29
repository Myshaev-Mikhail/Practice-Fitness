package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.practice.R
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.World

@Composable
fun LanguageSwitcher(
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(32.dp)

    Row(
        modifier = modifier
            .clip(shape)
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.55f))
            .border(2.dp, MaterialTheme.colorScheme.outline, shape)
            .height(35.dp)
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberVectorPainter(image = Icons.World),
            contentDescription = stringResource(R.string.language),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.outline),
            modifier = Modifier.size(15.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        LanguageOption(
            text = "EN",
            selected = selectedLanguage == "en",
            onClick = { onLanguageSelected("en") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .width(1.dp)
                .height(20.dp)
                .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.45f))
        )

        Spacer(modifier = Modifier.width(8.dp))

        LanguageOption(
            text = "RU",
            selected = selectedLanguage == "ru",
            onClick = { onLanguageSelected("ru") }
        )
    }
}

@Composable
private fun LanguageOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = text,
        color = if (selected) {
            MaterialTheme.colorScheme.secondary
        } else {
            MaterialTheme.colorScheme.onPrimary
        },
        style = MaterialTheme.typography.titleSmall.copy(
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 2.dp, vertical = 4.dp)
    )
}
