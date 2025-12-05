package com.agendepro.calendar.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import com.agendepro.design_system.ui.MaterialThemeExtensions.spacing
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import com.agendepro.ui.R as UiR

@Composable
fun CalendarHeader(
    currentDate: LocalDate,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    val locale = Locale.getDefault()
    val monthName = currentDate.month.getDisplayName(TextStyle.FULL, locale)
        .replaceFirstChar { it.titlecase(locale) }
    val year = currentDate.year

    val rotation by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onToggle() }
            .padding(MaterialTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "${monthName}, $year",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = stringResource(UiR.string.content_desc_arrow_down),
            modifier = Modifier.rotate(rotation)
        )
    }
}
