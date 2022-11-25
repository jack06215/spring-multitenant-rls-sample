package com.example.backend.domain.model

data class Customer(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val tenantName: String,
)
