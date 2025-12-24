package com.distributor.datasource.postgres.model

import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status
import jakarta.persistence.*
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "users")
class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    var id: String? = null

    @Column(nullable = false, unique = true)
    lateinit var username: String

    @Column(nullable = false)
    lateinit var password: String

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    lateinit var role: Role

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    lateinit var status: Status

    @Column(nullable = false, updatable = false)
    var createdAt: Date = Date()

    @Column(nullable = false)
    var updatedAt: Date = Date()
}
