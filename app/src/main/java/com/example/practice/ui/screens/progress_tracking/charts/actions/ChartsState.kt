package com.example.practice.ui.screens.progress_tracking.charts.actions

data class ChartsState(
    val monthSteps: MonthStepsUi = MonthStepsUi(),
)

data class MonthStepsUi(
    val month: List<String> = emptyList(),
    val normalizeSteps: List<Float> = emptyList(),
    val fromMaxToMinSteps: List<Int> = emptyList()
)