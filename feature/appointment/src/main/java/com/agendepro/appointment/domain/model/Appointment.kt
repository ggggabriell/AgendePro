package com.agendepro.appointment.domain.model

import java.sql.ClientInfoStatus
import java.time.LocalDate
import java.time.LocalTime

data class Appointment(
    val id: Int = 0,
    val client: ClientInfoStatus,
    val service: Service,
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val status: AppointmentStatus = AppointmentStatus.SCHEDULED,
    val notes: String? = null
)

enum class AppointmentStatus {
    SCHEDULED,
    COMPLETED,
    CANCELED,
    NO_SHOW,
    IN_PROGRESS,
    RESCHEDULED,
    PENDING_CONFIRMATION,
    PAID,
    UNPAID,
    AWAITING_PAYMENT
}