package com.example.backend.infrastructure.database.record

data class CustomerRecord(
    var customerId: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var tenantName: String? = null
)