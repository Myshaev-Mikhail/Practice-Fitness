package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import kotlin.math.roundToInt

@Composable
fun AgePicker(
    modifier: Modifier = Modifier,
    minAge: Int = 10,
    maxAge: Int = 100,
    initialAge: Int = 28,
    onAgeChange: (Int) -> Unit
) {
    val itemWidth = 64.dp
    val itemWidthPx = with(LocalDensity.current) { itemWidth.toPx() }

    val count = maxAge - minAge + 1
    val initialIndex = initialAge - minAge
    val listState = rememberLazyListState(initialIndex)

    val currentIndex by remember {
        derivedStateOf {
            val raw = listState.firstVisibleItemIndex +
                    (listState.firstVisibleItemScrollOffset / itemWidthPx)
            raw.roundToInt().coerceIn(0, count - 1)
        }
    }

    val currentAge = minAge + currentIndex

    LaunchedEffect(currentIndex) {
        onAgeChange(currentAge)
    }

    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress) {
            listState.animateScrollToItem(currentIndex)
        }
    }

    val sidePadding =
        (LocalConfiguration.current.screenWidthDp.dp / 2) - (itemWidth / 2)

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentAge.toString(),
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = Bold,
                fontSize = 52.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )

        Image(
            painter = rememberVectorPainter(Icons.Arrow),
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
                .rotate(90f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp).background(MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier
                        .width(2.dp)
                        .height(60.dp)
                        .background(MaterialTheme.colorScheme.secondary)
                )
                Spacer(Modifier.width(itemWidth - 4.dp))
                Box(
                    Modifier
                        .width(2.dp)
                        .height(60.dp)
                        .background(MaterialTheme.colorScheme.secondary)
                )
            }

            LazyRow(
                state = listState,
                contentPadding = PaddingValues(horizontal = sidePadding),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(count) { idx ->
                    val age = minAge + idx
                    val isSelected = idx == currentIndex

                    Text(
                        text = age.toString(),
                        modifier = Modifier
                            .width(itemWidth),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontWeight = if (isSelected) Bold else Bold,
                            fontSize = if (isSelected) 32.sp else 28.sp
                        ),
                        color = if (isSelected)
                            MaterialTheme.colorScheme.onBackground
                        else
                            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)
                    )
                }
            }
        }
    }
}