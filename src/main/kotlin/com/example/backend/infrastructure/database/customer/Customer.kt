package com.example.backend.infrastructure.database.customer

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "sample", name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    var id: Long? = null,
    @Column(name = "first_name") var firstName: String? = null,
    @Column(name = "last_name") var lastName: String? = null,
    @Column(name = "tenant_name") var tenantName: String? = null
)
