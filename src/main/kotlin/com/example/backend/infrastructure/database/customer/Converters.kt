package com.example.backend.infrastructure.database.customer

import com.example.backend.domain.customer.Customer
import com.example.backend.infrastructure.database.customer.Customer as CustomerRecord

class Converters {
    companion object {
        fun convert(source: CustomerRecord): Customer {
            return Customer(source.id!!, source.firstName!!, source.lastName!!)
        }

        fun convert(source: Customer, tenantName: String): CustomerRecord {
            return CustomerRecord(source.id, source.firstName, source.lastName, tenantName)
        }

        fun convert(customers: Iterable<CustomerRecord>): List<Customer> {
            return customers.map(Companion::convert)
        }
    }
}
