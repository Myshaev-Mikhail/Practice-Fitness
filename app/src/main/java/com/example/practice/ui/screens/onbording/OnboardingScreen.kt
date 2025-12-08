package com.example.practice.ui.screens.onbording

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.practice.R
import com.example.practice.ui.view.AppOutlinedButton
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.ValkyrieIcons
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
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

        Row(
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
        ) {
            Text(
                "Skip",
                color = colorResource(id = R.color.lime_green),
                modifier = Modifier
                    .padding(top = 48.dp, end = 8.dp)
                    .clickable { onFinish() }
            )

            Image(
                painter = rememberVectorPainter(image = ValkyrieIcons.Arrow),
                contentDescription = "skip",
                modifier = Modifier
                    .graphicsLayer(scaleX = -1f)
                    .padding(top = 48.dp, start = 16.dp)
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