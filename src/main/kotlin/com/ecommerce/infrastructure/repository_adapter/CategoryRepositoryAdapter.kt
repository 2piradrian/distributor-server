package com.ecommerce.infrastructure.repository_adapter

import com.ecommerce.infrastructure.postgres.mapper.CategoryEntityMapper
import com.ecommerce.infrastructure.postgres.projections.category.CategoryBasicProjection
import com.ecommerce.infrastructure.postgres.projections.category.CategoryFullProjection
import com.ecommerce.infrastructure.postgres.repository.PostgresCategoryRepositoryI
import com.ecommerce.domain.entity.Category
import com.ecommerce.domain.repository.CategoryRepositoryI
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryAdapter(
    private val categoryRepository: PostgresCategoryRepositoryI
) : CategoryRepositoryI {

    override fun getById(id: String): Category? {
        val model = this.categoryRepository.findFullById(id).orElse(null)
        return CategoryEntityMapper.toDomain(model)
    }

    override fun getBasicById(id: String): Category? {
        val model = this.categoryRepository.findBasicById(id).orElse(null)
        return CategoryEntityMapper.toDomain(model)
    }

    override fun getByName(name: String): Category? {
        val model = this.categoryRepository.findFullByName(name).orElse(null)
        return CategoryEntityMapper.toDomain(model)
    }

    override fun getAll(): List<Category> {
        val models = this.categoryRepository.findAllBy(CategoryFullProjection::class.java)
        return CategoryEntityMapper.toDomain(models, CategoryEntityMapper::toDomain)
    }

    override fun getAllBasic(): List<Category> {
        val models = this.categoryRepository.findAllBy(CategoryBasicProjection::class.java)
        return CategoryEntityMapper.toDomain(models, CategoryEntityMapper::toDomain)
    }

    override fun save(category: Category): Category {
        val categoryModel = CategoryEntityMapper.toModel(category)!!
        val saved = this.categoryRepository.save(categoryModel)
        return CategoryEntityMapper.toDomain(saved)!!
    }

    override fun update(category: Category): Category {
        return this.save(category)
    }

    override fun delete(id: String) {
        this.categoryRepository.deleteById(id)
    }
}
