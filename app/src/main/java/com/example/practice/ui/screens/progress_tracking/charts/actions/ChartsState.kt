package com.example.practice.ui.screens.progress_tracking.charts.actions

data class ChartsState(
    val monthSteps: MonthStepsUi = MonthStepsUi(),
    val permissionSteps: Boolean? = null,
    val todayStepsUi: TodayStepsUi = TodayStepsUi(),
    val stepsRecordsUi: List<StepsRecordUi> = emptyList()
)

data class MonthStepsUi(
    val month: List<String> = emptyList(),
    val normalizeSteps: List<Float> = emptyList(),
    val fromMaxToMinSteps: List<Float> = emptyList()
)

data class TodayStepsUi(
    val date: String = "",
    val steps: Int = 0,
    val distance: Float = 0f,
    val calories: Int = 0,
    val goalOfSteps: Int = 12000,
    val goalProgress: Float = 0f
)

data class StepsRecordUi(
    val period: StepsRecordPeriodUi,
    val dateText: String,
    val steps: String,
    val distance: Float,
    val calories: String
)

enum class StepsRecordPeriodUi {
    DAY,
    WEEK,
    MONTH,
    YEAR
}
