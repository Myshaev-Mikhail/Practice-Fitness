package com.example.practice.ui.screens.onbording

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.FitnessScreen
import com.example.practice.ui.screens.onbording.intents.OnBoardingSideEffect
import com.example.practice.ui.screens.onbording.intents.OnboardingAction
import com.example.practice.ui.screens.onbording.onboardingpage.FirstOnboardingPageScreen
import com.example.practice.ui.screens.onbording.onboardingpage.OnboardingPageScreen
import com.example.practice.ui.screens.onbording.onboardingpage.onboardingPages
import com.example.practice.ui.uikit.components.AppOutlinedButton

@Composable
fun OnBoardingScreen(
    navController: NavController
) {
    val viewModel: OnboardingViewModel = viewModel()
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { state.totalPages }
    )

    LaunchedEffect(sideEffect) {
        when (val effect = sideEffect) {
            is OnBoardingSideEffect.ScrollToPage -> {
                pagerState.animateScrollToPage(effect.page)
            }

            is OnBoardingSideEffect.NavigateToLogin -> {
                navController.navigate(FitnessScreen.SignIn.route) {
                    popUpTo(FitnessScreen.OnBoarding.route) {
                        inclusive = true
                    }
                }
            }

            OnBoardingSideEffect.Empty -> Unit
        }
    }

    Box(Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            if (page == 0) {
                FirstOnboardingPageScreen()
            } else {
                OnboardingPageScreen(
                    page = onboardingPages[page],
                    currentPage = page,
                    totalPages = state.totalPages,
                    onSkip = {
                        viewModel.uiAction(OnboardingAction.Skip)
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(240.dp))

            if (state.currentPage == state.totalPages - 1) {
                AppOutlinedButton(
                    text = "Get Started",
                    onClick = {
                        viewModel.uiAction(OnboardingAction.Finish)
                    }
                )
            } else {
                AppOutlinedButton(
                    text = "Next",
                    onClick = {
                        viewModel.uiAction(OnboardingAction.NextPage)
                    }
                )
            }
        }
    }
}