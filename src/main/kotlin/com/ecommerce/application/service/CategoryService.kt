package com.ecommerce.application.service

import com.ecommerce.application.use_case.category.*
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.category.mapper.*
import com.ecommerce.presentation.dto.category.request.*
import com.ecommerce.presentation.dto.category.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CategoryService(
    /* ==== Dependencies === */
    private val userService: UserServiceI,

    /* ==== Use Cases === */
    private val create: CreateCategoryUseCase,
    private val update: UpdateCategoryUseCase,
    private val delete: DeleteCategoryUseCase,
    private val getById: GetCategoryByIdUseCase,
    private val getAll: GetAllCategoriesUseCase
) : CategoryServiceI {

    override fun create(dto: CreateCategoryReq): CreateCategoryRes {
        val user: User = this.userService.auth(dto.token)

        val result = this.create.execute(
            command = CreateCategoryUseCase.Command(
                user = user,
                name = dto.name
            )
        )

        return CreateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun update(dto: UpdateCategoryReq): UpdateCategoryRes {
        val user: User = this.userService.auth(dto.token)

        val result = this.update.execute(
            command = UpdateCategoryUseCase.Command(
                user = user,
                id = dto.id,
                name = dto.name
            )
        )

        return UpdateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun delete(token: String, id: String) {
        val user: User = this.userService.auth(token)

        this.delete.execute(
            command = DeleteCategoryUseCase.Command(
                user = user,
                id = id
            )
        )
    }

    override fun getById(dto: GetCategoryByIdReq): GetCategoryByIdRes {
        val user: User? = this.userService.tryAuth(dto.token)

        val result = this.getById.execute(
            command = GetCategoryByIdUseCase.Command(
                user = user,
                id = dto.id
            )
        )

        return GetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAll(dto: GetAllCategoriesReq): GetAllCategoriesRes {
        val user: User? = this.userService.tryAuth(dto.token)

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
