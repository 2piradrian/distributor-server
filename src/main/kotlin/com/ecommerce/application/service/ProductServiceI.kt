package com.ecommerce.application.service

import com.ecommerce.presentation.dto.product.request.*
import com.ecommerce.presentation.dto.product.response.*

interface ProductServiceI {
    fun create(dto: CreateProductReq): CreateProductRes
    fun update(dto: UpdateProductReq): UpdateProductRes
    fun delete(token: String, id: String)
    fun getById(dto: GetProductByIdReq): GetProductByIdRes
    fun getAll(dto: GetAllProductsReq): GetAllProductsRes
}
