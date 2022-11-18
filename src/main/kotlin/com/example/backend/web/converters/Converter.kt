// @file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.example.backend.web.converters
// import java.util.List
import com.example.backend.model.Customer
import com.example.backend.web.model.CustomerDto
import java.util.stream.Collectors
import java.util.stream.StreamSupport

class Converters {
  companion object {
    fun convert(source: Customer): CustomerDto {
      return CustomerDto(source.id!!, source.firstName!!, source.lastName!!)
    }

    fun convert(source: CustomerDto, tenantName: String): Customer {
      return Customer(source.id, source.firstName, source.lastName, tenantName)
    }

    fun convert(customers: Iterable<Customer>): List<CustomerDto> {
      // return StreamSupport.stream(customers.spliterator(), false)
      //     .map(Converters::convert)
      //     .collect(Collectors.toList())
      return customers.map(Converters::convert)
    }
  }
}
