package com.example.backend.model

import javax.persistence.*

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
