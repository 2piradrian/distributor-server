package com.ecommerce.application.service

import com.ecommerce.presentation.dto.category.request.*
import com.ecommerce.presentation.dto.category.response.*
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface CategoryServiceI {
    fun create(@Valid dto: CreateCategoryReq): CreateCategoryRes
    fun update(@Valid dto: UpdateCategoryReq): UpdateCategoryRes
    fun delete(@Valid dto: DeleteCategoryReq)
    fun getShopById(@Valid dto: GetCategoryByIdReq): GetCategoryByIdRes
    fun getShopCatalog(@Valid dto: GetAllCategoriesReq): GetAllCategoriesRes
    fun getBackofficeById(@Valid dto: GetCategoryByIdReq): GetCategoryByIdRes
    fun getBackofficeCatalog(@Valid dto: GetAllCategoriesReq): GetAllCategoriesRes
}
