package com.distributor.application.service

import com.distributor.presentation.dto.category.request.*
import com.distributor.presentation.dto.category.response.*

interface CategoryServiceI {
    fun create(dto: CreateCategoryReq): CreateCategoryRes
    fun update(dto: UpdateCategoryReq): UpdateCategoryRes
    fun delete(token: String, id: String)
    fun getById(dto: GetCategoryByIdReq): GetCategoryByIdRes
    fun getAll(dto: GetAllCategoriesReq): GetAllCategoriesRes
}
