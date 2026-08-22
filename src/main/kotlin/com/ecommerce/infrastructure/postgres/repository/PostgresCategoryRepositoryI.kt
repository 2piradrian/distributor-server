package com.ecommerce.infrastructure.postgres.repository

import com.ecommerce.infrastructure.postgres.model.CategoryModel
import com.ecommerce.infrastructure.postgres.projections.category.CategoryBasicProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryFullProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryPublicBasicProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryPublicFullProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PostgresCategoryRepositoryI : JpaRepository<CategoryModel, String> {

    fun findFullById(id: String): Optional<CategoryFullProjection>

    fun findBasicById(id: String): Optional<CategoryBasicProjection>

    fun findPublicFullById(id: String): Optional<CategoryPublicFullProjection>

    fun findPublicBasicById(id: String): Optional<CategoryPublicBasicProjection>

    fun findFullByName(name: String): Optional<CategoryFullProjection>

    fun <T> findAllBy(type: Class<T>): List<T>
}
