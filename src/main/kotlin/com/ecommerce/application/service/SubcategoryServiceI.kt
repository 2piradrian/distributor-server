package com.ecommerce.application.service

import com.ecommerce.presentation.dto.subcategory.request.*
import com.ecommerce.presentation.dto.subcategory.response.*
import org.springframework.validation.annotation.Validated
import jakarta.validation.Valid

@Validated
interface SubcategoryServiceI {

    fun createSubcategory(@Valid dto: CreateSubcategoryReq): CreateSubcategoryRes

    fun updateSubcategory(@Valid dto: UpdateSubcategoryReq): UpdateSubcategoryRes

    fun deleteSubcategory(@Valid dto: DeleteSubcategoryReq)

    fun getSubcategoryById(@Valid dto: GetSubcategoryByIdReq): GetSubcategoryByIdRes

    fun getAllSubcategories(@Valid dto: GetAllSubcategoriesReq): GetAllSubcategoriesRes

}
