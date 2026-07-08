package com.ecommerce.application.service

import com.ecommerce.application.use_case.category.*
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.presentation.dto.category.mapper.*
import com.ecommerce.presentation.dto.category.request.*
import com.ecommerce.presentation.dto.category.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CategoryService(

    /* ==== Use Cases === */
    private val create: CreateCategoryUseCase,
    private val update: UpdateCategoryUseCase,
    private val delete: DeleteCategoryUseCase,
    private val getById: GetCategoryByIdUseCase,
    private val getAll: GetAllCategoriesUseCase

) : CategoryServiceI {

    override fun create(dto: CreateCategoryReq): CreateCategoryRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val result = this.create.execute(
            command = CreateCategoryUseCase.Command(
                user = user,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return CreateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun update(dto: UpdateCategoryReq): UpdateCategoryRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val result = this.update.execute(
            command = UpdateCategoryUseCase.Command(
                user = user,
                id = dto.id!!,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return UpdateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun delete(dto: DeleteCategoryReq) {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        this.delete.execute(
            command = DeleteCategoryUseCase.Command(
                user = user,
                id = dto.id!!
            )
        )
    }

    override fun getById(dto: GetCategoryByIdReq): GetCategoryByIdRes {
        val user: User? = dto.user

        val result = this.getById.execute(
            command = GetCategoryByIdUseCase.Command(
                user = user,
                id = dto.id!!
            )
        )

        return GetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAll(dto: GetAllCategoriesReq): GetAllCategoriesRes {
        val user: User? = dto.user

        val result = this.getAll.execute(
            command = GetAllCategoriesUseCase.Command(
                user = user
            )
        )

        return GetAllCategoriesMapper.toResponse(
            categories = result.categories
        )
    }
}
