package com.agendepro.client.domain.model

enum class ClientCategory {
    NEW,
    RECURRING,
    VIP,
    BLACKLISTED,
    INACTIVE;

    companion object {
        fun fromString(value: String): ClientCategory {
            return entries.find { it.name.equals(value, ignoreCase = true) }
                ?: throw IllegalArgumentException("Invalid value: $value")
        }
    }
}
