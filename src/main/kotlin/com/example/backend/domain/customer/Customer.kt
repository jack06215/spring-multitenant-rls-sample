package com.example.backend.domain.customer

import com.fasterxml.jackson.annotation.JsonProperty

data class Customer(
    @JsonProperty("id") val id: Long,
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_ame") val lastName: String,
)
