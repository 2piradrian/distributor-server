package com.ecommerce.application.service

import com.ecommerce.application.use_case.subcategory.*
import com.ecommerce.presentation.dto.subcategory.mapper.*
import com.ecommerce.presentation.dto.subcategory.request.*
import com.ecommerce.presentation.dto.subcategory.response.*
import org.springframework.stereotype.Service

@Service
class SubcategoryService(
    private val create: CreateSubcategoryUseCase,
    private val update: UpdateSubcategoryUseCase,
    private val delete: DeleteSubcategoryUseCase,
    private val getById: GetSubcategoryByIdUseCase,
    private val getAll: GetAllSubcategoriesUseCase
) : SubcategoryServiceI {

    override fun createSubcategory(dto: CreateSubcategoryReq): CreateSubcategoryRes {
        val result = this.create.execute(
            command = CreateSubcategoryUseCase.Command(
                user = dto.user,
                name = dto.name!!,
                slug = dto.slug!!,
                categoryId = dto.categoryId!!
            )
        )

        return CreateSubcategoryMapper.toResponse(
            id = result.subcategory.id!!
        )
    }

    override fun updateSubcategory(dto: UpdateSubcategoryReq): UpdateSubcategoryRes {
        val result = this.update.execute(
            command = UpdateSubcategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!,
                name = dto.name!!,
                slug = dto.slug!!,
                categoryId = dto.categoryId!!
            )
        )

        return UpdateSubcategoryMapper.toResponse(
            id = result.subcategory.id!!
        )
    }

    override fun deleteSubcategory(dto: DeleteSubcategoryReq) {
        this.delete.execute(
            command = DeleteSubcategoryUseCase.Command(
                user = dto.user,
                id = dto.id!!
            )
        )
    }

    override fun getSubcategoryById(dto: GetSubcategoryByIdReq): GetSubcategoryByIdRes {
        val result = this.getById.execute(
            command = GetSubcategoryByIdUseCase.Command(
                user = dto.user,
                id = dto.id
            )
        )

        return GetSubcategoryByIdMapper.toResponse(
            subcategory = result.subcategory
        )
    }

    override fun getAllSubcategories(dto: GetAllSubcategoriesReq): GetAllSubcategoriesRes {
        val result = this.getAll.execute(
            command = GetAllSubcategoriesUseCase.Command(
                user = dto.user
            )
        )

        return GetAllSubcategoriesMapper.toResponse(
            subcategories = result.subcategories
        )
    }

}
