package com.example.backend.model

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Tenant {
  @Column(name = "tenant_name") var tenantName: String? = null
}
