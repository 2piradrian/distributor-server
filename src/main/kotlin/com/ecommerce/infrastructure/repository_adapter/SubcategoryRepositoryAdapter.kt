package com.ecommerce.infrastructure.repository_adapter

import com.ecommerce.infrastructure.postgres.mapper.SubcategoryEntityMapper
import com.ecommerce.infrastructure.postgres.repository.PostgresSubcategoryRepositoryI
import com.ecommerce.domain.entity.Subcategory
import com.ecommerce.domain.repository.SubcategoryRepositoryI
import org.springframework.stereotype.Repository

@Repository
class SubcategoryRepositoryAdapter(
    private val subcategoryRepository: PostgresSubcategoryRepositoryI
) : SubcategoryRepositoryI {

    override fun getById(id: String): Subcategory? {
        val model = subcategoryRepository.findById(id).orElse(null)
        return SubcategoryEntityMapper.toDomain(model)
    }

    override fun getByName(name: String): Subcategory? {
        val model = subcategoryRepository.findByName(name).orElse(null)
        return SubcategoryEntityMapper.toDomain(model)
    }

    override fun getAll(): List<Subcategory> {
        val models = subcategoryRepository.findAll()
        return SubcategoryEntityMapper.toDomain(models)
    }

    override fun save(subcategory: Subcategory): Subcategory {
        val model = SubcategoryEntityMapper.toModel(subcategory)!!
        val saved = subcategoryRepository.save(model)
        return SubcategoryEntityMapper.toDomain(saved)!!
    }

    override fun update(subcategory: Subcategory): Subcategory {
        return this.save(subcategory)
    }

    override fun delete(id: String) {
        subcategoryRepository.deleteById(id)
    }
}
