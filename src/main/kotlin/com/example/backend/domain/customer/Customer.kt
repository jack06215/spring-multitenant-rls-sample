package com.example.backend.domain.customer

import com.fasterxml.jackson.annotation.JsonProperty

data class Customer(
    @JsonProperty("id") val id: Long,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("lastName") val lastName: String,
)
