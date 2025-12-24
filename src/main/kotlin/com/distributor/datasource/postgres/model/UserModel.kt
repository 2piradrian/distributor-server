package com.distributor.datasource.postgres.model

import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "users")
data class UserModel(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    val id: String? = null,

    @Column(unique = true)
    val username: String? = null,

    @Column
    val password: String? = null,

    @Enumerated(EnumType.STRING)
    val role: Role? = null,

    @Enumerated(EnumType.STRING)
    val status: Status? = null,

    @Column
    val createdAt: Date? = null,

    @Column
    val updatedAt: Date? = null
)
