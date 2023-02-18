package com.example.backend.domain.repository

import com.example.backend.domain.model.Customer

interface CustomerRepository {
    fun find(id: Long): Customer?
    fun insert(customer: Customer): Customer
    fun delete(id: Long): Boolean
}
