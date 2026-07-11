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
    private val getShopById: GetShopCategoryByIdUseCase,
    private val getShopCatalog: GetShopCategoriesCatalogUseCase,
    private val getBackofficeById: GetBackofficeCategoryByIdUseCase,
    private val getBackofficeCatalog: GetBackofficeCategoriesCatalogUseCase

) : CategoryServiceI {

    override fun create(dto: CreateCategoryReq): CreateCategoryRes {
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

    override fun update(dto: UpdateCategoryReq): UpdateCategoryRes {
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

    override fun delete(dto: DeleteCategoryReq) {
        this.delete.execute(
            command = DeleteCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getShopById(dto: GetCategoryByIdReq): GetCategoryByIdRes {
        val result = this.getShopById.execute(
            command = GetShopCategoryByIdUseCase.Command(
                id = dto.id!!
            )
        )

        return GetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getShopCatalog(dto: GetAllCategoriesReq): GetAllCategoriesRes {
        val result = this.getShopCatalog.execute(
            command = GetShopCategoriesCatalogUseCase.Command()
        )

        return GetAllCategoriesMapper.toResponse(
            categories = result.categories
        )
    }

    override fun getBackofficeById(dto: GetCategoryByIdReq): GetCategoryByIdRes {
        val result = this.getBackofficeById.execute(
            command = GetBackofficeCategoryByIdUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )

        return GetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getBackofficeCatalog(dto: GetAllCategoriesReq): GetAllCategoriesRes {
        val result = this.getBackofficeCatalog.execute(
            command = GetBackofficeCategoriesCatalogUseCase.Command(
                user = dto.user
            )
        )

        return GetAllCategoriesMapper.toResponse(
            categories = result.categories
        )
    }
}
