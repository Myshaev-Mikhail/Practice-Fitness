package com.example.practice.ui.screens.onbording

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.example.practice.ui.uikit.components.AppOutlinedButton
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val pages = onboardingPages
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Box(Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            if (page == 0) {
                FirstOnboardingPageScreen(pages[page])
            } else {
                OnboardingPageScreen(
                    page = pages[page],
                    currentPage = pagerState.currentPage,
                    totalPages = pages.size
                )
            }
        }

        Button(
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .padding(top = 40.dp),
            onClick = onFinish,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                "Skip",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(end = 4.dp)
            )

            Image(
                painter = rememberVectorPainter(image = Icons.Arrow),
                contentDescription = "skip",
                modifier = Modifier
                    .graphicsLayer(scaleX = -1f)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
        ) {


            AppOutlinedButton(
                text = if (pagerState.currentPage == pages.lastIndex) "Get Started" else "Next",
                onClick = {
                    if (pagerState.currentPage == pages.lastIndex) {
                        onFinish()
                    } else {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            )
        }
    }
}