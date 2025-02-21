package com.agendepro.appointment.domain.model

data class Service(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val duration: Int,
)
