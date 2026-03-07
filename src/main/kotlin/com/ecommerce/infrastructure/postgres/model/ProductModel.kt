package com.ecommerce.infrastructure.postgres.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "products")
class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    var id: String? = null

    @Column(nullable = false, unique = true)
    lateinit var name: String

    @Column(nullable = false)
    lateinit var description: String

    @Column(nullable = false)
    var price: Double = 0.0

    @Column(nullable = false)
    var stock: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var category: CategoryModel? = null

    @Column(nullable = false, updatable = false)
    var createdAt: Date = Date()

    @Column(nullable = false)
    var updatedAt: Date = Date()
}
