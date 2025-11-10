package com.agendepro.client.domain.repository

import com.agendepro.client.domain.model.Client

interface ClientRepository {
    suspend fun getAll(): List<Client>
    suspend fun getById(id: Long): Client?
    suspend fun insert(client: Client)
    suspend fun delete(id: Long)
}