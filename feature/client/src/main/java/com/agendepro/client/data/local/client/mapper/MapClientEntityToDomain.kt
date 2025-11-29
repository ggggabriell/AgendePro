package com.agendepro.client.data.local.client.mapper

import com.agendepro.client.domain.model.Address
import com.agendepro.client.domain.model.Client
import com.agendepro.client.domain.model.ClientCategory
import com.agendepro.database.ClientEntity
import kotlinx.serialization.json.Json

fun ClientEntity.toDomain(): Client {
    val address = this.address?.let {
        Json.decodeFromString<Address>(it)
    } ?: Address("", "", "", "", "")

    return Client(
        id = this.id,
        name = this.name,
        email = this.email.orEmpty(),
        phone = this.phone.orEmpty(),
        category = ClientCategory.fromString(this.category),
        notes = this.notes.orEmpty(),
        birthday = this.birthday.orEmpty(),
        address = address,
        gender = this.gender.orEmpty(),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}