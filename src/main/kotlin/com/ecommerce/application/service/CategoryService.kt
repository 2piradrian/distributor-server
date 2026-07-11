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

    override fun createCategory(dto: CreateBackofficeCategoryReq): CreateBackofficeCategoryRes {
        val result = this.create.execute(
            command = CreateCategoryUseCase.Command(
                user = dto.user,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return CreateBackofficeCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun updateCategory(dto: UpdateBackofficeCategoryReq): UpdateBackofficeCategoryRes {
        val result = this.update.execute(
            command = UpdateCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return UpdateBackofficeCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun deleteCategory(dto: DeleteBackofficeCategoryReq) {
        this.delete.execute(
            command = DeleteCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getShopCategoryById(dto: GetShopCategoryByIdReq): GetShopCategoryByIdRes {
        val result = this.getShopById.execute(
            command = GetShopCategoryByIdUseCase.Command(
                id = dto.id
            )
        )

        return GetShopCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAllShopCategories(dto: GetAllShopCategoriesReq): GetAllShopCategoriesRes {
        val result = this.getShopCatalog.execute()

        return GetAllShopCategoriesMapper.toResponse(
            categories = result.categories
        )
    }

    override fun getBackofficeCategoryById(dto: GetBackofficeCategoryByIdReq): GetBackofficeCategoryByIdRes {
        val result = this.getBackofficeById.execute(
            command = GetBackofficeCategoryByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return GetBackofficeCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAllBackofficeCategories(dto: GetAllBackofficeCategoriesReq): GetAllBackofficeCategoriesRes {
        val result = this.getBackofficeCatalog.execute(
            command = GetBackofficeCategoriesCatalogUseCase.Command(
                user = dto.user
            )
        )

        return GetAllBackofficeCategoriesMapper.toResponse(
            categories = result.categories
        )
    }
}
