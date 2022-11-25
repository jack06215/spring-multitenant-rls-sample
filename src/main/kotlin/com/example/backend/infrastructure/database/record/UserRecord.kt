package com.example.backend.infrastructure.database.record

data class UserRecord(
    var id: Long? = null,
    var name: String? = null,
    var age: Long? = null,
    var profile: String? = null
)