package com.ecommerce.application.service

import com.ecommerce.presentation.dto.category.request.ShopGetAllCategoriesReq
import com.ecommerce.presentation.dto.category.request.ShopGetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.ShopGetAllCategoriesRes
import com.ecommerce.presentation.dto.category.response.ShopGetCategoryByIdRes
import com.ecommerce.presentation.dto.category.request.BackofficeCreateCategoryReq
import com.ecommerce.presentation.dto.category.request.BackofficeUpdateCategoryReq
import com.ecommerce.presentation.dto.category.request.BackofficeDeleteCategoryReq
import com.ecommerce.presentation.dto.category.request.BackofficeGetAllCategoriesReq
import com.ecommerce.presentation.dto.category.request.BackofficeGetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.BackofficeCreateCategoryRes
import com.ecommerce.presentation.dto.category.response.BackofficeUpdateCategoryRes
import com.ecommerce.presentation.dto.category.response.BackofficeGetAllCategoriesRes
import com.ecommerce.presentation.dto.category.response.BackofficeGetCategoryByIdRes
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface CategoryServiceI {
    fun backofficeCreateCategory(@Valid dto: BackofficeCreateCategoryReq): BackofficeCreateCategoryRes
    fun backofficeUpdateCategory(@Valid dto: BackofficeUpdateCategoryReq): BackofficeUpdateCategoryRes
    fun backofficeDeleteCategory(@Valid dto: BackofficeDeleteCategoryReq)
    fun shopGetCategoryById(@Valid dto: ShopGetCategoryByIdReq): ShopGetCategoryByIdRes
    fun shopGetAllCategories(@Valid dto: ShopGetAllCategoriesReq): ShopGetAllCategoriesRes
    fun backofficeGetCategoryById(@Valid dto: BackofficeGetCategoryByIdReq): BackofficeGetCategoryByIdRes
    fun backofficeGetAllCategories(@Valid dto: BackofficeGetAllCategoriesReq): BackofficeGetAllCategoriesRes
}
