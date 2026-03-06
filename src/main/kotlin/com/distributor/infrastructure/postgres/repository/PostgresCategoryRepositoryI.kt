package com.distributor.infrastructure.postgres.repository

import com.distributor.infrastructure.postgres.model.CategoryModel
import com.distributor.infrastructure.postgres.projections.category.CategoryBasicProjection
import com.distributor.infrastructure.postgres.projections.category.CategoryFullProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostgresCategoryRepositoryI : JpaRepository<CategoryModel, String> {

    fun findFullById(id: String): Optional<CategoryFullProjection>

    fun findBasicById(id: String): Optional<CategoryBasicProjection>

    fun findFullByName(name: String): Optional<CategoryFullProjection>

    fun <T> findAllBy(type: Class<T>): List<T>
}
