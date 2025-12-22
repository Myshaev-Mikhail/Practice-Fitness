package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import kotlin.math.roundToInt

@Composable
fun HeightPicker(
    modifier: Modifier = Modifier,
    minHeight: Int = 100,
    maxHeight: Int = 230,
    initialHeight: Int = 165,
    step: Int = 1,
    onHeightChange: (Int) -> Unit = {}
) {
    val itemHeight = 24.dp
    val scaleWidth = 56.dp

    val count = ((maxHeight - minHeight) / step) + 1
    val initialIndex = (initialHeight - minHeight) / step

    val listState = rememberLazyListState(initialIndex)

    val itemHeightPx = with(LocalDensity.current) {
        itemHeight.toPx()
    }

    val currentIndex by remember {
        derivedStateOf {
            val raw =
                listState.firstVisibleItemIndex +
                        (listState.firstVisibleItemScrollOffset / itemHeightPx)

            raw.roundToInt().coerceIn(0, count - 1)
        }
    }

    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress) {
            listState.animateScrollToItem(currentIndex)
        }
    }

    val currentHeight = maxHeight - currentIndex * step

    LaunchedEffect(currentIndex) {
        onHeightChange(currentHeight)
    }

    val pickerHeight = 300.dp
    val sidePadding = (pickerHeight / 2) - (itemHeight / 2)

    Column(
        modifier = modifier
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Box(
                modifier = Modifier.width(95.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = currentHeight.toString(),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Bold,
                        fontSize = 48.sp,
                    ),
                )
            }

            Spacer(Modifier.width(6.dp))

            Text(
                text = "cm",
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                fontFamily = Poppins,
                fontWeight = Bold,
                fontSize = 20.sp,
            )
        }

        Box(
            modifier = Modifier
                .width(90.dp)
                .height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.tertiary)
            )

            Box(
                modifier = Modifier
                    .width(45.dp)
                    .height(3.dp)
                    .background(MaterialTheme.colorScheme.secondary)
                    .zIndex(1f)
            )

            Image(
                painter = rememberVectorPainter(Icons.Arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 18.dp)
            )

            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(vertical = sidePadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
            ) {
                items(count) { idx ->
                    val value = maxHeight - idx * step
                    val isFull = value % 5 == 0

                    Box(
                        modifier = Modifier
                            .height(itemHeight)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {

                        if (isFull) {
                            Text(
                                text = value.toString(),
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = TextStyle(
                                    fontFamily = Poppins,
                                    fontWeight = Bold,
                                    fontSize = 16.sp,
                                ),
                                modifier = Modifier
                                    .offset(x = -(scaleWidth / 2 + 28.dp))
                            )
                        }

                        Box(
                            modifier = Modifier
                                .width(if (isFull) 22.dp else 12.dp)
                                .height(3.dp)
                                .background(MaterialTheme.colorScheme.onPrimary)
                        )
                    }
                }
            }
        }
    }
}