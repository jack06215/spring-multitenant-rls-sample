package com.example.backend.web.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerDto(
        @JsonProperty("id") val id: Long,
        @JsonProperty("firstName") val firstName: String,
        @JsonProperty("lastName") val lastName: String,
)
