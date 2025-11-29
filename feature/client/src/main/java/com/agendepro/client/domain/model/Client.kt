package com.agendepro.client.domain.model

data class Client(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val category: ClientCategory = ClientCategory.NEW,
    val notes: String,
    val birthday: String,
    val address: Address,
    val gender: String,
    val createdAt: Long,
    val updatedAt: Long
)