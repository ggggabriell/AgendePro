package com.agendepro.client.data.local.client

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.agendepro.client.data.local.client.mapper.toDomain
import com.agendepro.client.domain.model.Client
import com.agendepro.client.domain.repository.ClientRepository
import com.agendepro.database.ClientQueries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LocalClientRepositoryImpl(
    private val clientQueries: ClientQueries
) : ClientRepository {

    override fun getAll(): Flow<List<Client>> {
        return clientQueries.selectAll()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list -> list.map { it.toDomain() } }
    }

    override fun getById(id: Long): Flow<Client?> {
        return clientQueries.selectById(id)
            .asFlow()
            .mapToOneOrNull(Dispatchers.Default)
            .map { it?.toDomain() }
    }

    override suspend fun insert(client: Client) {
        clientQueries.insertClient(
            name = client.name,
            email = client.email,
            phone = client.phone,
            category = client.category.name,
            notes = client.notes,
            birthday = client.birthday,
            gender = client.gender,
            address = client.address.let { Json.encodeToString(it) },
            createdAt = client.createdAt,
            updatedAt = client.updatedAt
        )
    }

    override suspend fun update(client: Client) {
        clientQueries.updateClient(
            name = client.name,
            email = client.email,
            phone = client.phone,
            category = client.category.name,
            notes = client.notes,
            birthday = client.birthday,
            gender = client.gender,
            address = client.address.let { Json.encodeToString(it) },
            updatedAt = client.updatedAt,
            id = client.id
        )
    }

    override suspend fun delete(id: Long) {
        clientQueries.deleteById(id)
    }
}