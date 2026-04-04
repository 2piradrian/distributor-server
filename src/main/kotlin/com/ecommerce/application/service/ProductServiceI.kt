package com.ecommerce.application.service

import com.ecommerce.presentation.dto.product.request.*
import com.ecommerce.presentation.dto.product.response.*
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface ProductServiceI {
    fun create(@Valid dto: CreateProductReq): CreateProductRes
    fun update(@Valid dto: UpdateProductReq): UpdateProductRes
    fun delete(@Valid dto: DeleteProductReq)
    fun getById(@Valid dto: GetProductByIdReq): GetProductByIdRes
    fun getAll(@Valid dto: GetAllProductsReq): GetAllProductsRes
}
