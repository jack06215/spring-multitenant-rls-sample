package com.example.backend.domain.customer

import com.example.backend.infrastructure.database.customer.Customer
import org.springframework.data.repository.CrudRepository

public interface ICustomerRepository : CrudRepository<Customer, Long>
