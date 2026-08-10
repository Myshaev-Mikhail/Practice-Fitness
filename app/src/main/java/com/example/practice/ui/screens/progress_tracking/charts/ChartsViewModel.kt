package com.example.practice.ui.screens.progress_tracking.charts

import android.os.Build
import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsAction
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsSideEffect
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsState
import com.example.practice.ui.screens.progress_tracking.charts.actions.MonthStepsUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import kotlin.math.roundToInt

class ChartsViewModel() : ViewModel() {
    private val uiStateFlow = MutableStateFlow(ChartsState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<ChartsSideEffect>(ChartsSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    init {
        countStepsMonth()
    }

    fun handleUiAction(action: ChartsAction) {
        when (action) {
            is ChartsAction.ProgressTrackingPressed -> {
                sideEffectFlow.value = ChartsSideEffect.ShowProgressTracking
            }
        }
    }

    fun countStepsMonth() {
        uiStateFlow.value = uiStateFlow.value.copy(
            monthSteps = buildStepsChartUi(
                months = getRecentMonths(),
                steps = getMonthlySteps()
            )
        )
    }

    fun getRecentMonths(): List<String> {
        val locale = Locale.getDefault()

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Современный подход (API 26+)
            val formatter = DateTimeFormatter.ofPattern("LLLL", locale)
            (3 downTo 0).map { i ->
                YearMonth.now().minusMonths(i.toLong()).format(formatter)
            }
        } else {
            // Обратная совместимость (API < 26)
            val format = SimpleDateFormat("LLLL", locale)
            val calendar = Calendar.getInstance()
            (3 downTo 0).map { i ->
                val cal = calendar.clone() as Calendar
                cal.add(Calendar.MONTH, -i)
                format.format(cal.time)
            }
        }
    }

    private fun buildStepsChartUi(
        months: List<String>,
        steps: List<Int>
    ): MonthStepsUi {
        val minSteps = steps.minOrNull() ?: 0
        val maxSteps = steps.maxOrNull() ?: 0

        val rawRange = maxSteps - minSteps

        val padding = if (rawRange == 0) {
            maxOf((maxSteps * 0.2f).roundToInt(), 1)
        } else {
            (rawRange * 0.7f).roundToInt()
        }

        val chartMin = (minSteps - padding).coerceAtLeast(0)
        val chartMax = maxSteps + padding
        val chartRange = (chartMax - chartMin).coerceAtLeast(1)

        val normalizedSteps = steps.map { step ->
            ((step - chartMin).toFloat() / chartRange.toFloat())
                .coerceIn(0f, 1f)
        }

        val labelStep = chartRange / 3f

        val yLabels = listOf(
            chartMax,
            (chartMin + labelStep * 2).roundToInt(),
            (chartMin + labelStep).roundToInt(),
            chartMin
        )

        return MonthStepsUi(
            month = months,
            normalizeSteps = normalizedSteps,
            fromMaxToMinSteps = yLabels
        )
    }

    fun getMonthlySteps(): List<Int> {
        return listOf(170, 165, 155, 150)
    }

    fun clearSideEffect() {
        sideEffectFlow.value = ChartsSideEffect.Empty
    }
}
