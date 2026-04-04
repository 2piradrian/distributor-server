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
    fun getById(@Valid dto: GetCategoryByIdReq): GetCategoryByIdRes
    fun getAll(@Valid dto: GetAllCategoriesReq): GetAllCategoriesRes
}
