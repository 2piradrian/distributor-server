package com.ecommerce.application.service

import com.ecommerce.presentation.dto.category.request.*
import com.ecommerce.presentation.dto.category.response.*
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface CategoryServiceI {
    fun createCategory(@Valid dto: CreateBackofficeCategoryReq): CreateBackofficeCategoryRes
    fun updateCategory(@Valid dto: UpdateBackofficeCategoryReq): UpdateBackofficeCategoryRes
    fun deleteCategory(@Valid dto: DeleteBackofficeCategoryReq)
    fun getShopCategoryById(@Valid dto: GetShopCategoryByIdReq): GetShopCategoryByIdRes
    fun getAllShopCategories(@Valid dto: GetAllShopCategoriesReq): GetAllShopCategoriesRes
    fun getBackofficeCategoryById(@Valid dto: GetBackofficeCategoryByIdReq): GetBackofficeCategoryByIdRes
    fun getAllBackofficeCategories(@Valid dto: GetAllBackofficeCategoriesReq): GetAllBackofficeCategoriesRes
}
