package com.example.backend.infrastructure.repository

import com.example.backend.domain.model.Customer

fun Customer.asModel(): Customer {
    return Customer(this.id!!, this.firstName!!, this.lastName!!, this.tenantName!!)
}
