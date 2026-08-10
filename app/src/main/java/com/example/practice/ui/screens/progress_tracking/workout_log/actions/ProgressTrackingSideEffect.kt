package com.example.practice.ui.screens.progress_tracking.workout_log.actions

sealed class ProgressTrackingSideEffect {
    data object Empty : ProgressTrackingSideEffect()
    data object ShowCharts : ProgressTrackingSideEffect()
}