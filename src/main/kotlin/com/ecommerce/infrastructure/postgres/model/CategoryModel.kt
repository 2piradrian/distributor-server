package com.ecommerce.infrastructure.postgres.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "categories")
class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    var id: String? = null

    @Column(nullable = false, unique = true)
    lateinit var name: String

    @Column(nullable = false, unique = true)
    lateinit var slug: String

    @Column(nullable = false, updatable = false)
    var createdAt: Date = Date()

    @Column(nullable = false)
    var updatedAt: Date = Date()
}
