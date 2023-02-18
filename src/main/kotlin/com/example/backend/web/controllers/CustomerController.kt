package com.example.backend.web.controller

import com.example.backend.core.ThreadLocalStorage
import com.example.backend.repositories.ICustomerRepository
import com.example.backend.web.converters.Converters
import com.example.backend.web.model.CustomerDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class CustomerController {

    @Autowired
    private lateinit var repository: ICustomerRepository

    @GetMapping("/customers")
    fun getAll(): List<CustomerDto> {
        val customers = repository.findAll()
        return Converters.convert(customers)
    }

    @GetMapping("/customers/{id}")
    public fun get(@PathVariable("id") id: Long): CustomerDto {
        val customer = repository.findById(id).orElse(null)
        return Converters.convert(customer)
    }

    @PostMapping("/customers")
    fun post(@RequestBody customer: CustomerDto): CustomerDto {
        val tenantName = ThreadLocalStorage.getTenantName()

        // Convert to the Domain Object:
        val source = Converters.convert(customer, tenantName)

        // Store the Entity:
        val result = repository.save(source)

        // Return the DTO:
        return Converters.convert(result)
    }

    @DeleteMapping("/customers/{id}")
    fun delete(@PathVariable("id") id: Long) {
        repository.deleteById(id)
    }
}
