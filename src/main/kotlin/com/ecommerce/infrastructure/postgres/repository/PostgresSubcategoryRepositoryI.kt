package com.ecommerce.infrastructure.postgres.repository

import com.ecommerce.infrastructure.postgres.model.SubcategoryModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PostgresSubcategoryRepositoryI : JpaRepository<SubcategoryModel, String> {
    fun findByName(name: String): Optional<SubcategoryModel>
}
