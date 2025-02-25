package com.agendepro.calendar.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun CalendarHeader(
    currentDate: LocalDate,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "${currentDate.month.name.lowercase().replaceFirstChar { it.uppercaseChar() }}, ${currentDate.year}",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.width(8.dp))

        val rotation by animateFloatAsState(if (isExpanded) 180f else 0f, label = "arrow_rotation")

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Toggle Calendar",
            modifier = Modifier.rotate(rotation)
        )
    }
}