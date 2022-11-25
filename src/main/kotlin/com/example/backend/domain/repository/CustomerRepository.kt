package com.example.backend.domain.repository

import com.example.backend.domain.model.Customer

interface CustomerRepository {
  fun findAllCustomer(): List<Customer>
  fun findCustomer(id: Long): Customer?
  fun register(book: Customer)
  fun delete(id: Long)
}
