package com.example.backend.infrastructure.database.repository

import com.example.backend.domain.model.Customer
import com.example.backend.domain.repository.CustomerRepository
import com.example.backend.infrastructure.database.mapper.CustomerDynamicSqlSupport.Customer.customerId
import com.example.backend.infrastructure.database.mapper.CustomerDynamicSqlSupport.Customer.firstName
import com.example.backend.infrastructure.database.mapper.CustomerDynamicSqlSupport.Customer.lastName
import com.example.backend.infrastructure.database.mapper.CustomerMapper
import com.example.backend.infrastructure.database.record.CustomerRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class CustomerRepositoryImpl(
    private val customerMapper: CustomerMapper,
) : CustomerRepository {

  override fun findAllCustomer(): List<Customer> {}

  override fun findCustomer(id: Long): Customer? {}

  override fun register(book: Customer) {}

  override fun delete(id: Long) {}

  private fun convert(record: CustomerRecord): Customer {
    return Customer(record.customerId!!, record.firstName!!, record.lastName!!)
  }
}
