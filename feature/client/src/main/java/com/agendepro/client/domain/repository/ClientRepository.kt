package com.agendepro.client.domain.repository

import com.agendepro.client.domain.model.Client
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    fun getAll(): Flow<List<Client>>
    fun getById(id: Long): Flow<Client?>
    suspend fun insert(client: Client)
    suspend fun update(client: Client)
    suspend fun delete(id: Long)
}
