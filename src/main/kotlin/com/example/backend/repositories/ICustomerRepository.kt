package com.example.backend.model.repositories

import com.example.backend.model.Customer
import org.springframework.data.repository.CrudRepository

public interface ICustomerRepository : CrudRepository<Customer, Long>
