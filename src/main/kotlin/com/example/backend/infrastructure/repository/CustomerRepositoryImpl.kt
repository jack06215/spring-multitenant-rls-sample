package com.example.backend.infrastructure.repository

import com.example.backend.domain.model.Customer
import com.example.backend.domain.repository.CustomerRepository
import com.example.backend.infrastructure.database.generated.mapper.CustomerMapper
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class CustomerRepositoryImpl(
    private val customerMapper: CustomerMapper,
) : CustomerRepository {
    override fun find(id: Long): Customer? {
        throw NotImplementedError("Not implemented yet")
    }

    override fun insert(book: Customer): Customer {
        throw NotImplementedError("Not implemented yet")
    }

    override fun delete(id: Long): Boolean {
        throw NotImplementedError("Not implemented yet")
    }
}
