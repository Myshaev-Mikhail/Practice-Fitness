package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun CalendarWidget(
    modifier: Modifier = Modifier
) {
    val calendar = remember { Calendar.getInstance() }

    var currentMonth by remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
    var currentYear by remember { mutableStateOf(calendar.get(Calendar.YEAR)) }
    var selectedDay by remember { mutableStateOf<Int?>(calendar.get(Calendar.DAY_OF_MONTH)) }
    var monthMenuExpanded by remember { mutableStateOf(false) }

    val months = listOf(
        "January", "February", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November", "December"
    )

    val daysOfWeek = listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")

    val tempCalendar = remember(currentMonth, currentYear) {
        Calendar.getInstance().apply {
            set(Calendar.YEAR, currentYear)
            set(Calendar.MONTH, currentMonth)
            set(Calendar.DAY_OF_MONTH, 1)
        }
    }

    val daysInMonth = tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val startOffset = (tempCalendar.get(Calendar.DAY_OF_WEEK) + 5) % 7
    val weeksCount = (startOffset + daysInMonth + 6) / 7

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Divider(color = MaterialTheme.colorScheme.onPrimary)
        Spacer(Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Choose Date",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(Modifier.width(12.dp))

            Text(
                text = months[currentMonth],
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .rotate(90f)
                    .clickable { monthMenuExpanded = true }
            )

            DropdownMenu(
                expanded = monthMenuExpanded,
                onDismissRequest = { monthMenuExpanded = false }
            ) {
                months.forEachIndexed { index, month ->
                    DropdownMenuItem(
                        text = { Text(month) },
                        onClick = {
                            currentMonth = index
                            selectedDay = null
                            monthMenuExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(4.dp))
        Divider(color = MaterialTheme.colorScheme.onPrimary)

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            daysOfWeek.forEach {
                Box(
                    modifier = Modifier
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .padding(4.dp)
                ) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .border(
                    2.dp,
                    MaterialTheme.colorScheme.secondary,
                    RoundedCornerShape(28.dp)
                )
                .padding(12.dp)
        ) {
            Column {
                repeat(weeksCount) { week ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(7) { column ->
                            val index = week * 7 + column
                            val dayNumber = index - startOffset + 1
                            val validDay = dayNumber.takeIf { it in 1..daysInMonth }
                            val isSelected = validDay == selectedDay

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .clickable(enabled = validDay != null) {
                                        selectedDay = validDay
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                if (validDay != null) {
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .background(
                                                if (isSelected)
                                                    MaterialTheme.colorScheme.secondary
                                                else Color.Transparent,
                                                CircleShape
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = validDay.toString(),
                                            style = MaterialTheme.typography.titleSmall,
                                            color = if (column == 6)
                                                MaterialTheme.colorScheme.onSecondary
                                            else MaterialTheme.colorScheme.primary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}