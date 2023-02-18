package com.example.backend.repositories

import com.example.backend.infrastructure.customer.Customer
import org.springframework.data.repository.CrudRepository

public interface ICustomerRepository : CrudRepository<Customer, Long>
