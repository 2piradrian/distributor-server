package com.ecommerce.application.service

import com.ecommerce.application.use_case.category.*
import com.ecommerce.presentation.dto.category.mapper.*
import com.ecommerce.presentation.dto.category.request.*
import com.ecommerce.presentation.dto.category.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CategoryService(
    private val create: CreateCategoryUseCase,
    private val update: UpdateCategoryUseCase,
    private val delete: DeleteCategoryUseCase,
    private val getById: GetCategoryByIdUseCase,
    private val getAll: GetAllCategoriesUseCase
) : CategoryServiceI {

    override fun createCategory(dto: CreateCategoryReq): CreateCategoryRes {
        val result = this.create.execute(
            command = CreateCategoryUseCase.Command(
                user = dto.user,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return CreateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun updateCategory(dto: UpdateCategoryReq): UpdateCategoryRes {
        val result = this.update.execute(
            command = UpdateCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return UpdateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun deleteCategory(dto: DeleteCategoryReq) {
        this.delete.execute(
            command = DeleteCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getCategoryById(dto: GetCategoryByIdReq): GetCategoryByIdRes {
        val result = this.getById.execute(
            command = GetCategoryByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return GetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAllCategories(dto: GetAllCategoriesReq): GetAllCategoriesRes {
        val result = this.getAll.execute(
            command = GetAllCategoriesUseCase.Command(
                user = dto.user
            )
        )

        return GetAllCategoriesMapper.toResponse(
            categories = result.categories
        )
    }
}
