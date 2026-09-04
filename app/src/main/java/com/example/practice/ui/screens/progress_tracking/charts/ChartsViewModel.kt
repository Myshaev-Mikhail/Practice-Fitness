package com.example.practice.ui.screens.progress_tracking.charts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.StepsActivityStats
import com.example.practice.domain.models.StepsRecord
import com.example.practice.domain.usecase.StepsUseCase
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsAction
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsSideEffect
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsState
import com.example.practice.ui.screens.progress_tracking.charts.actions.MonthStepsUi
import com.example.practice.ui.screens.progress_tracking.charts.actions.StepsRecordPeriodUi
import com.example.practice.ui.screens.progress_tracking.charts.actions.StepsRecordUi
import com.example.practice.ui.screens.progress_tracking.charts.actions.TodayStepsUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

class ChartsViewModel(
    private val stepsUseCase: StepsUseCase
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(ChartsState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<ChartsSideEffect>(ChartsSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    init {
        countStepsMonth()
        observeTodaySteps()
        observeStepsRecords()
        observePermissionSteps()
    }

    fun handleUiAction(action: ChartsAction) {
        when (action) {
            is ChartsAction.ProgressTrackingPressed -> {
                sideEffectFlow.value = ChartsSideEffect.ShowProgressTracking
            }

            is ChartsAction.StepsPermissionChanged -> {
                viewModelScope.launch {
                    setPermissionSteps(action.permission)
                }
            }
        }
    }

    private fun countStepsMonth() {
        val monthRanges = getRecentMonthRanges()
        val monthStepFlows = getMonthlySteps(monthRanges)

        combine(monthStepFlows) { monthSteps ->
            buildStepsChartUi(
                months = monthRanges.map { it.title },
                steps = monthSteps.map { it.roundStepsToThousands() }
            )
        }
            .onEach { monthSteps ->
                uiStateFlow.value = uiStateFlow.value.copy(
                    monthSteps = monthSteps
                )
            }
            .launchIn(viewModelScope)
    }

    private fun observeTodaySteps() {
        val todayRange = getTodayRange()

        stepsUseCase.getStepsActivityStatsForAPeriod(
            fromMillis = todayRange.fromMillis,
            toMillis = todayRange.toMillis
        )
            .onEach { todayStats ->
                uiStateFlow.value = uiStateFlow.value.copy(
                    todayStepsUi = todayStats.toTodayStepsUi(todayRange.title)
                )
            }
            .launchIn(viewModelScope)
    }

    private fun observeStepsRecords() {
        combine(
            stepsUseCase.getRecordDay(),
            stepsUseCase.getRecordWeek(),
            stepsUseCase.getRecordMonth(),
            stepsUseCase.getRecordYear()
        ) { dayRecord, weekRecord, monthRecord, yearRecord ->
            listOf(
                dayRecord.toStepsRecordUi(StepsRecordPeriodUi.DAY),
                weekRecord.toStepsRecordUi(StepsRecordPeriodUi.WEEK),
                monthRecord.toStepsRecordUi(StepsRecordPeriodUi.MONTH),
                yearRecord.toStepsRecordUi(StepsRecordPeriodUi.YEAR)
            )
        }
            .onEach { records ->
                uiStateFlow.value = uiStateFlow.value.copy(
                    stepsRecordsUi = records
                )
            }
            .launchIn(viewModelScope)
    }

    private fun getRecentMonthRanges(): List<MonthRange> {
        val monthFormat = SimpleDateFormat("LLLL", Locale.getDefault())

        return (3 downTo 0).map { monthsAgo ->
            val start = Calendar.getInstance().apply {
                add(Calendar.MONTH, -monthsAgo)
                set(Calendar.DAY_OF_MONTH, 1)
                clearTime()
            }

            val end = (start.clone() as Calendar).apply {
                add(Calendar.MONTH, 1)
            }

            MonthRange(
                title = monthFormat.format(start.time),
                fromMillis = start.timeInMillis,
                toMillis = end.timeInMillis
            )
        }
    }

    private fun getTodayRange(): DayRange {
        val dayFormat = SimpleDateFormat("d MMMM", Locale.getDefault())

        val start = Calendar.getInstance().apply {
            clearTime()
        }

        val end = (start.clone() as Calendar).apply {
            add(Calendar.DAY_OF_MONTH, 1)
        }

        return DayRange(
            title = dayFormat.format(start.time),
            fromMillis = start.timeInMillis,
            toMillis = end.timeInMillis
        )
    }

    private fun buildStepsChartUi(
        months: List<String>,
        steps: List<Float>
    ): MonthStepsUi {
        val minSteps = steps.minOrNull() ?: 0f
        val maxSteps = steps.maxOrNull() ?: 0f

        val rawRange = maxSteps - minSteps

        val padding = when {
            rawRange == 0f && maxSteps == 0f -> 1f
            rawRange == 0f -> maxOf(maxSteps * 0.2f, 0.1f)
            else -> rawRange * 0.7f
        }

        val chartMin = (minSteps - padding).coerceAtLeast(0f)
        val chartMax = maxSteps + padding
        val chartRange = (chartMax - chartMin).coerceAtLeast(0.1f)

        val normalizedSteps = steps.map { step ->
            ((step - chartMin) / chartRange)
                .coerceIn(0f, 1f)
        }

        val labelStep = chartRange / 3f

        val yLabels = listOf(
            chartMax,
            chartMin + labelStep * 2,
            chartMin + labelStep,
            chartMin
        ).map { it.roundToOneDecimal() }

        return MonthStepsUi(
            month = months,
            normalizeSteps = normalizedSteps,
            fromMaxToMinSteps = yLabels
        )
    }

    private fun getMonthlySteps(monthRanges: List<MonthRange>) =
        monthRanges.map { range ->
            stepsUseCase.getStepsSumForAPeriod(
                fromMillis = range.fromMillis,
                toMillis = range.toMillis
            )
        }

    private fun Int.roundStepsToThousands(): Float {
        return this / 1000f
    }

    private fun Float.roundToOneDecimal(): Float {
        return (this * 10f).roundToInt() / 10f
    }

    private fun StepsActivityStats.toTodayStepsUi(date: String): TodayStepsUi {
        return TodayStepsUi(
            date = date,
            steps = steps,
            distance = distanceMeters.toKilometers(),
            calories = calories,
            goalOfSteps = DEFAULT_GOAL_STEPS,
            goalProgress = (steps.toFloat() / DEFAULT_GOAL_STEPS).coerceIn(0f, 1f)
        )
    }

    private fun StepsRecord.toStepsRecordUi(period: StepsRecordPeriodUi): StepsRecordUi {
        return StepsRecordUi(
            period = period,
            dateText = formatRecordDate(
                period = period,
                startDateMillis = startDateMillis,
                endDateMillis = endDateMillis
            ),
            steps = steps.formatCompactRecordValue(),
            distance = distanceMeters.toKilometers(),
            calories = calories.formatCompactRecordValue()
        )
    }

    private fun Float.toKilometers(): Float {
        return (this / METERS_IN_KILOMETER).roundToOneDecimal()
    }

    private fun Int.formatCompactRecordValue(): String {
        return when {
            this >= 1_000_000 -> "${this / 1_000_000}м"
            this >= 100_000 -> "${this / 1_000}к"
            else -> formatNumberWithSpaces()
        }
    }

    private fun Int.formatNumberWithSpaces(): String {
        val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
            groupingSeparator = ' '
        }

        return DecimalFormat("#,###", symbols).format(this)
    }

    private fun formatRecordDate(
        period: StepsRecordPeriodUi,
        startDateMillis: Long?,
        endDateMillis: Long?
    ): String {
        if (startDateMillis == null) return EMPTY_RECORD_DATE

        if (period == StepsRecordPeriodUi.DAY) {
            return SimpleDateFormat("d MMMM", Locale.getDefault()).format(Date(startDateMillis))
        }

        val endInclusiveMillis = ((endDateMillis ?: startDateMillis) - 1L)
            .coerceAtLeast(startDateMillis)

        val dateFormat = when (period) {
            StepsRecordPeriodUi.YEAR -> SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            else -> SimpleDateFormat("dd.MM", Locale.getDefault())
        }

        return "${dateFormat.format(Date(startDateMillis))} - ${
            dateFormat.format(Date(endInclusiveMillis))
        }"
    }

    private fun Calendar.clearTime() {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }

    fun clearSideEffect() {
        sideEffectFlow.value = ChartsSideEffect.Empty
    }

    private data class MonthRange(
        val title: String,
        val fromMillis: Long,
        val toMillis: Long
    )

    private data class DayRange(
        val title: String,
        val fromMillis: Long,
        val toMillis: Long
    )

    private fun observePermissionSteps() {
        stepsUseCase.getPermissionSteps()
            .onEach { permission ->
                uiStateFlow.value = uiStateFlow.value.copy(
                    permissionSteps = permission
                )
            }
            .launchIn(viewModelScope)
    }

    private suspend fun setPermissionSteps(permission: Boolean) {
        stepsUseCase.setPermissionSteps(permission)
    }

    private companion object {
        const val DEFAULT_GOAL_STEPS = 12000
        const val METERS_IN_KILOMETER = 1000f
        const val EMPTY_RECORD_DATE = "-"
    }
}
