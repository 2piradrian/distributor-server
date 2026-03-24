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

    @Column(nullable = true)
    var offerPrice: Double? = null

    @Column(nullable = false)
    var stock: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var category: CategoryModel? = null

    @Column(nullable = true)
    var mainImage: String? = null

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_images", joinColumns = [JoinColumn(name = "product_id")])
    @Column(name = "image_url")
    var images: List<String> = mutableListOf()

    @Column(nullable = false)
    var isVisible: Boolean = true

    @Column(nullable = false, updatable = false)
    var createdAt: Date = Date()

    @Column(nullable = false)
    var updatedAt: Date = Date()
}
