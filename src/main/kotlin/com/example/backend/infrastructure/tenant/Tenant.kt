package com.example.backend.infrastructure.tenant

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Tenant {
    @Column(name = "tenant_name") var tenantName: String? = null
}
