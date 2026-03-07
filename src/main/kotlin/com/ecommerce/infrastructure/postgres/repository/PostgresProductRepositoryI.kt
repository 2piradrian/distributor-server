package com.ecommerce.infrastructure.postgres.repository

import com.ecommerce.infrastructure.postgres.model.ProductModel
import com.ecommerce.infrastructure.postgres.projections.product.ProductBasicProjection
import com.ecommerce.infrastructure.postgres.projections.product.ProductFullProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostgresProductRepositoryI : JpaRepository<ProductModel, String>, JpaSpecificationExecutor<ProductModel> {

    fun findFullById(id: String): Optional<ProductFullProjection>

    fun findBasicById(id: String): Optional<ProductBasicProjection>

    fun findFullByName(name: String): Optional<ProductFullProjection>

    fun <T> findAllBy(type: Class<T>): List<T>
}
