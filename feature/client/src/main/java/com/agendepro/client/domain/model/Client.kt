package com.agendepro.client.domain.model

data class Client(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val category: ClientCategory = ClientCategory.NEW,
    val notes: String? = null,
    val birthday: String? = null,
    val address: String? = null,
    val gender: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)