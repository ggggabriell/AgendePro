package com.agendepro.client.domain.model

data class Client(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val category: ClientCategory = ClientCategory.NEW,
    val notes: String? = null,
    )

enum class ClientCategory {
    NEW,
    RECURRING,
    VIP,
    BLACKLISTED,
    INACTIVE
}