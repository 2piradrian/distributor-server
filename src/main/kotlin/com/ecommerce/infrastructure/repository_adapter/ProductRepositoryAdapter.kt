package com.ecommerce.infrastructure.repository_adapter

import com.ecommerce.domain.entity.Product
import com.ecommerce.domain.filters.ProductFilters
import com.ecommerce.domain.repository.ProductRepositoryI
import com.ecommerce.infrastructure.postgres.mapper.ProductEntityMapper
import com.ecommerce.infrastructure.postgres.model.ProductModel
import com.ecommerce.infrastructure.postgres.projections.product.ProductBasicProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductFullProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductPublicBasicProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductPublicFullProjection
import com.ecommerce.infrastructure.postgres.repository.PostgresProductRepositoryI
import com.ecommerce.infrastructure.postgres.specification.ProductSpecification
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryAdapter(
    private val productRepository: PostgresProductRepositoryI
) : ProductRepositoryI {

    override fun getById(id: String): Product? {
        val model = productRepository.findFullById(id).orElse(null)
        return ProductEntityMapper.toDomain(model)
    }

    override fun getBasicById(id: String): Product? {
        val model = productRepository.findBasicById(id).orElse(null)
        return ProductEntityMapper.toDomain(model)
    }

    override fun getPublicById(id: String): Product? {
        val model = productRepository.findPublicFullById(id).orElse(null)
        return ProductEntityMapper.toDomain(model)
    }

    override fun getPublicBasicById(id: String): Product? {
        val model = productRepository.findPublicBasicById(id).orElse(null)
        return ProductEntityMapper.toDomain(model)
    }

    override fun getByName(name: String): Product? {
        val model = productRepository.findFullByName(name).orElse(null)
        return ProductEntityMapper.toDomain(model)
    }

    override fun getAll(filters: ProductFilters?): List<Product> {
        val spec = ProductSpecification.build(filters)

        val models = productRepository.findBy(spec) { query: FluentQuery.FetchableFluentQuery<ProductModel> ->
            query.`as`(ProductFullProjection::class.java).all()
        }

        return ProductEntityMapper.toDomain(models, ProductEntityMapper::toDomain)
    }

    override fun getAllPublic(filters: ProductFilters?): List<Product> {
        val spec = ProductSpecification.build(filters)

        val models = productRepository.findBy(spec) { query: FluentQuery.FetchableFluentQuery<ProductModel> ->
            query.`as`(ProductPublicFullProjection::class.java).all()
        }

        return ProductEntityMapper.toDomain(models, ProductEntityMapper::toDomain)
    }

    override fun getAllBasic(filters: ProductFilters?): List<Product> {
        val spec = ProductSpecification.build(filters)

        val models = productRepository.findBy(spec) { query: FluentQuery.FetchableFluentQuery<ProductModel> ->
            query.`as`(ProductBasicProjection::class.java).all()
        }

        return ProductEntityMapper.toDomain(models, ProductEntityMapper::toDomain)
    }

    override fun getAllPublicBasic(filters: ProductFilters?): List<Product> {
        val spec = ProductSpecification.build(filters)

        val models = productRepository.findBy(spec) { query: FluentQuery.FetchableFluentQuery<ProductModel> ->
            query.`as`(ProductPublicBasicProjection::class.java).all()
        }

        return ProductEntityMapper.toDomain(models, ProductEntityMapper::toDomain)
    }

    override fun save(product: Product): Product {
        val productModel = ProductEntityMapper.toModel(product)!!
        val saved = this.productRepository.save(productModel)
        return ProductEntityMapper.toDomain(saved)!!
    }

    override fun update(product: Product): Product {
        return this.save(product)
    }

    override fun delete(id: String) {
        this.productRepository.deleteById(id)
    }
}
