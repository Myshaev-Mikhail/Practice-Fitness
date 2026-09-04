package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.practice.R
import com.example.practice.ui.screens.progress_tracking.charts.actions.StepsRecordPeriodUi
import com.example.practice.ui.screens.progress_tracking.charts.actions.StepsRecordUi
import io.github.composegears.valkyrie.Cup
import io.github.composegears.valkyrie.Icons

@Composable
fun StepsRecordsCard(
    records: List<StepsRecordUi>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = rememberVectorPainter(image = Icons.Cup),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = stringResource(R.string.records),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                Text(
                    text = stringResource(R.string.best_periods),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.22f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        records.forEachIndexed { index, record ->
            StepsRecordRow(
                leftColor = record.period.toColor(),
                title = record.period.toTitle(),
                dateText = record.dateText,
                steps = record.steps,
                distance = record.distance,
                calories = record.calories
            )

            if (index != records.lastIndex) {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun StepsRecordRow(
    leftColor: Color,
    title: String,
    dateText: String,
    steps: String,
    distance: Float,
    calories: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.06f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .fillMaxHeight()
                    .background(
                        color = leftColor,
                        shape = RoundedCornerShape(8.dp)
                    )
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.weight(1.35f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = dateText,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            RecordMetricColumn(
                modifier = Modifier.weight(0.95f),
                value = steps,
                title = stringResource(R.string.steps),
                valueColor = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.width(8.dp))

            RecordMetricColumn(
                modifier = Modifier.weight(0.55f),
                value = "$distance",
                title = stringResource(R.string.km_unit),
                valueColor = MaterialTheme.colorScheme.outline
            )

            Spacer(modifier = Modifier.width(8.dp))

            RecordMetricColumn(
                modifier = Modifier.weight(0.65f),
                value = calories,
                title = stringResource(R.string.kcal_unit),
                valueColor = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
private fun RecordMetricColumn(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    valueColor: Color
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleSmall,
            color = valueColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun StepsRecordPeriodUi.toColor(): Color {
    return when (this) {
        StepsRecordPeriodUi.DAY -> MaterialTheme.colorScheme.secondary
        StepsRecordPeriodUi.WEEK -> MaterialTheme.colorScheme.primary
        StepsRecordPeriodUi.MONTH -> MaterialTheme.colorScheme.secondary
        StepsRecordPeriodUi.YEAR -> MaterialTheme.colorScheme.primary
    }
}

@Composable
private fun StepsRecordPeriodUi.toTitle(): String {
    return when (this) {
        StepsRecordPeriodUi.DAY -> stringResource(R.string.day)
        StepsRecordPeriodUi.WEEK -> stringResource(R.string.week)
        StepsRecordPeriodUi.MONTH -> stringResource(R.string.month)
        StepsRecordPeriodUi.YEAR -> stringResource(R.string.year)
    }
}
