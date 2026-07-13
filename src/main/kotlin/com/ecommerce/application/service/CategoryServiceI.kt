package com.ecommerce.application.service

import com.ecommerce.presentation.dto.category.request.CreateCategoryReq
import com.ecommerce.presentation.dto.category.request.UpdateCategoryReq
import com.ecommerce.presentation.dto.category.request.DeleteCategoryReq
import com.ecommerce.presentation.dto.category.request.GetAllCategoriesReq
import com.ecommerce.presentation.dto.category.request.GetCategoryByIdReq
import com.ecommerce.presentation.dto.category.response.CreateCategoryRes
import com.ecommerce.presentation.dto.category.response.UpdateCategoryRes
import com.ecommerce.presentation.dto.category.response.GetAllCategoriesRes
import com.ecommerce.presentation.dto.category.response.GetCategoryByIdRes
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface CategoryServiceI {
    fun createCategory(@Valid dto: CreateCategoryReq): CreateCategoryRes
    fun updateCategory(@Valid dto: UpdateCategoryReq): UpdateCategoryRes
    fun deleteCategory(@Valid dto: DeleteCategoryReq)
    fun getCategoryById(@Valid dto: GetCategoryByIdReq): GetCategoryByIdRes
    fun getAllCategories(@Valid dto: GetAllCategoriesReq): GetAllCategoriesRes
}
