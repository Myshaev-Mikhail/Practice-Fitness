package com.example.practice.ui.screens.progress_tracking.workout_log.actions

sealed class ProgressTrackingAction {
    data object ChartsPressed : ProgressTrackingAction()
}