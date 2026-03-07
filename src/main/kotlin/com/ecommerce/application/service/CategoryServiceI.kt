package com.ecommerce.application.service

import com.ecommerce.presentation.dto.category.request.*
import com.ecommerce.presentation.dto.category.response.*

interface CategoryServiceI {
    fun create(dto: CreateCategoryReq): CreateCategoryRes
    fun update(dto: UpdateCategoryReq): UpdateCategoryRes
    fun delete(token: String, id: String)
    fun getById(dto: GetCategoryByIdReq): GetCategoryByIdRes
    fun getAll(dto: GetAllCategoriesReq): GetAllCategoriesRes
}
