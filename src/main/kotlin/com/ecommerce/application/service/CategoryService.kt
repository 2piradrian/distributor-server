package com.ecommerce.application.service

import com.ecommerce.application.use_case.category.*
import com.ecommerce.presentation.dto.category.mapper.BackofficeCreateCategoryMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeGetAllCategoriesMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeGetCategoryByIdMapper
import com.ecommerce.presentation.dto.category.mapper.BackofficeUpdateCategoryMapper
import com.ecommerce.presentation.dto.category.mapper.ShopGetAllCategoriesMapper
import com.ecommerce.presentation.dto.category.mapper.ShopGetCategoryByIdMapper
import com.ecommerce.presentation.dto.category.request.BackofficeCreateCategoryReq
import com.ecommerce.presentation.dto.category.request.BackofficeDeleteCategoryReq
import com.ecommerce.presentation.dto.category.request.BackofficeGetAllCategoriesReq
import com.ecommerce.presentation.dto.category.request.BackofficeGetCategoryByIdReq
import com.ecommerce.presentation.dto.category.request.BackofficeUpdateCategoryReq
import com.ecommerce.presentation.dto.category.request.ShopGetAllCategoriesReq
import com.ecommerce.presentation.dto.category.request.ShopGetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.BackofficeCreateCategoryRes
import com.ecommerce.presentation.dto.category.response.BackofficeGetAllCategoriesRes
import com.ecommerce.presentation.dto.category.response.BackofficeGetCategoryByIdRes
import com.ecommerce.presentation.dto.category.response.BackofficeUpdateCategoryRes
import com.ecommerce.presentation.dto.category.response.ShopGetAllCategoriesRes
import com.ecommerce.presentation.dto.category.response.ShopGetCategoryByIdRes
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CategoryService(

    /* ==== Use Cases === */
    private val create: BackofficeCreateCategoryUseCase,
    private val update: BackofficeUpdateCategoryUseCase,
    private val delete: BackofficeDeleteCategoryUseCase,
    private val getShopById: ShopGetCategoryByIdUseCase,
    private val getShopCatalog: ShopGetAllCategoriesUseCase,
    private val getBackofficeById: BackofficeGetCategoryByIdUseCase,
    private val getBackofficeCatalog: BackofficeGetAllCategoriesUseCase

) : CategoryServiceI {

    override fun createCategory(dto: BackofficeCreateCategoryReq): BackofficeCreateCategoryRes {
        val result = this.create.execute(
            command = BackofficeCreateCategoryUseCase.Command(
                user = dto.user,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return BackofficeCreateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun updateCategory(dto: BackofficeUpdateCategoryReq): BackofficeUpdateCategoryRes {
        val result = this.update.execute(
            command = BackofficeUpdateCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!,
                name = dto.name!!,
                slug = dto.slug!!
            )
        )

        return BackofficeUpdateCategoryMapper.toResponse(
            id = result.category.id!!
        )
    }

    override fun deleteCategory(dto: BackofficeDeleteCategoryReq) {
        this.delete.execute(
            command = BackofficeDeleteCategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getShopCategoryById(dto: ShopGetCategoryByIdReq): ShopGetCategoryByIdRes {
        val result = this.getShopById.execute(
            command = ShopGetCategoryByIdUseCase.Command(
                id = dto.id
            )
        )

        return ShopGetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAllShopCategories(dto: ShopGetAllCategoriesReq): ShopGetAllCategoriesRes {
        val result = this.getShopCatalog.execute()

        return ShopGetAllCategoriesMapper.toResponse(
            categories = result.categories
        )
    }

    override fun getBackofficeCategoryById(dto: BackofficeGetCategoryByIdReq): BackofficeGetCategoryByIdRes {
        val result = this.getBackofficeById.execute(
            command = BackofficeGetCategoryByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return BackofficeGetCategoryByIdMapper.toResponse(
            category = result.category
        )
    }

    override fun getAllBackofficeCategories(dto: BackofficeGetAllCategoriesReq): BackofficeGetAllCategoriesRes {
        val result = this.getBackofficeCatalog.execute(
            command = BackofficeGetAllCategoriesUseCase.Command(
                user = dto.user
            )
        )

        return BackofficeGetAllCategoriesMapper.toResponse(
            categories = result.categories
        )
    }
}
