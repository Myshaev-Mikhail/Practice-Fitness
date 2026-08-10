package com.example.practice.ui.screens.progress_tracking.charts.actions

sealed class ChartsSideEffect {
    data object Empty : ChartsSideEffect()
    data object ShowProgressTracking : ChartsSideEffect()
}