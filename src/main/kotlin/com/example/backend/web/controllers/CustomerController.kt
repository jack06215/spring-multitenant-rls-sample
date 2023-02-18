package com.example.backend.web.controller

import com.example.backend.core.ThreadLocalStorage
import com.example.backend.domain.customer.Customer
import com.example.backend.infrastructure.customer.Converters
import com.example.backend.repositories.ICustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.backend.model.Customer as CustomerRecord

@RestController
@CrossOrigin
class CustomerController {

    @Autowired
    private lateinit var repository: ICustomerRepository

    @GetMapping("/customers")
    fun getAll(): List<Customer> {
        val customers: Iterable<CustomerRecord> = repository.findAll()
        return Converters.convert(customers)
    }

    @GetMapping("/customers/{id}")
    public fun get(@PathVariable("id") id: Long): Customer {
        val customer: CustomerRecord = repository.findById(id).orElse(null)
        return Converters.convert(customer)
    }

    @PostMapping("/customers")
    fun post(@RequestBody customer: Customer): Customer {
        val tenantName = ThreadLocalStorage.getTenantName()

        // Convert to the Domain Object:
        val source = Converters.convert(customer, tenantName)

        // Store the Entity:
        val result: CustomerRecord = repository.save(source)

        // Return the DTO:
        return Converters.convert(result)
    }

    @DeleteMapping("/customers/{id}")
    fun delete(@PathVariable("id") id: Long) {
        repository.deleteById(id)
    }
}
