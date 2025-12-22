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
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import kotlin.math.roundToInt

@Composable
fun WeightPicker(
    modifier: Modifier = Modifier,
    minWeight: Float = 30f,
    maxWeight: Float = 190f,
    initialWeight: Float = 75f,
    step: Float = 0.2f,
    onWeightChange: (Float) -> Unit = {}
) {
    val itemWidth = 32.dp
    val itemWidthPx = with(LocalDensity.current) { itemWidth.toPx() }

    val count = ((maxWeight - minWeight) / step).roundToInt() + 1

    val initialIndex = ((initialWeight - minWeight) / step).roundToInt()
    val listState = rememberLazyListState(initialIndex)

    val currentIndex by remember {
        derivedStateOf {
            val raw = listState.firstVisibleItemIndex +
                    (listState.firstVisibleItemScrollOffset / itemWidthPx)
            raw.roundToInt().coerceIn(0, count - 1)
        }
    }

    val currentWeight = minWeight + currentIndex * step

    LaunchedEffect(currentIndex) {
        onWeightChange(((currentWeight * 10).roundToInt()) / 10f)
    }

    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress) {
            listState.animateScrollToItem(currentIndex)
        }
    }

    val sidePadding = (LocalConfiguration.current.screenWidthDp.dp / 2) - (itemWidth / 2)

    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.BottomCenter)
            )

            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height(45.dp)
                    .offset(y = 26.dp)
                    .background(MaterialTheme.colorScheme.secondary)
                    .zIndex(1f)
            )

            LazyRow(
                state = listState,
                contentPadding = PaddingValues(horizontal = sidePadding),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(count) { idx ->
                    val value = minWeight + idx * step
                    val isFull = (value * 10 % 10 == 0f)

                    Column(
                        modifier = Modifier
                            .width(itemWidth)
                            .height(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (isFull) {
                            Text(
                                text = value.toInt().toString(),
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = TextStyle(
                                    fontFamily = Poppins,
                                    fontWeight = Bold,
                                    fontSize = 18.sp,
                                )
                            )
                            Spacer(Modifier.height(12.dp))
                        } else Spacer(Modifier.height(26.dp))

                        Box(
                            modifier = Modifier
                                .width(3.dp)
                                .height(if (isFull) 45.dp else 24.dp)
                                .offset(y = 10.dp)
                                .background(MaterialTheme.colorScheme.onPrimary)
                        )
                    }
                }
            }
        }

        Image(
            painter = rememberVectorPainter(Icons.Arrow),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(top = 8.dp)
                .rotate(90f)
        )

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                text = String.format("%.1f", currentWeight),
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = Bold,
                    fontSize = 48.sp,
                )
            )

            Spacer(Modifier.width(4.dp))

            Text(
                text = "Kg",
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = Bold,
                    fontSize = 20.sp,
                )
            )
        }
    }
}