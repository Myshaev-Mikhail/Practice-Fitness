package com.example.practice.ui.screens.progress_tracking.charts.actions

sealed class ChartsAction {
    data object ProgressTrackingPressed : ChartsAction()
    data class StepsPermissionChanged(val permission: Boolean) : ChartsAction()
}