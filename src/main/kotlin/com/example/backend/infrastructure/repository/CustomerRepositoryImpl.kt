package com.example.backend.infrastructure.repository

import com.example.backend.domain.model.Customer
import com.example.backend.domain.repository.CustomerRepository
import com.example.backend.infrastructure.database.generated.record.CustomerRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class CustomerRepositoryImpl(
) : CustomerRepository {

    override fun findAllCustomer(): List<Customer> {
        throw NotImplementedError("Not implemented yet")
    }

    override fun findCustomer(id: Long): Customer? {
        throw NotImplementedError("Not implemented yet")
    }

    override fun register(book: Customer) {
        throw NotImplementedError("Not implemented yet")
    }

    override fun delete(id: Long) {
        throw NotImplementedError("Not implemented yet")
    }

    private fun convert(record: CustomerRecord): Customer {
        return Customer(record.customerId!!, record.firstName!!, record.lastName!!, record.tenantName!!)
    }
}
