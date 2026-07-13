package com.ecommerce.application.service

import com.ecommerce.presentation.dto.product.request.CreateProductReq
import com.ecommerce.presentation.dto.product.request.UpdateProductReq
import com.ecommerce.presentation.dto.product.request.DeleteProductReq
import com.ecommerce.presentation.dto.product.request.GetAllProductsReq
import com.ecommerce.presentation.dto.product.request.GetProductByIdReq
import com.ecommerce.presentation.dto.product.response.CreateProductRes
import com.ecommerce.presentation.dto.product.response.UpdateProductRes
import com.ecommerce.presentation.dto.product.response.GetAllProductsRes
import com.ecommerce.presentation.dto.product.response.GetProductByIdRes
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface ProductServiceI {
    fun createProduct(@Valid dto: CreateProductReq): CreateProductRes
    fun updateProduct(@Valid dto: UpdateProductReq): UpdateProductRes
    fun deleteProduct(@Valid dto: DeleteProductReq)
    fun getProductById(@Valid dto: GetProductByIdReq): GetProductByIdRes
    fun getAllProducts(@Valid dto: GetAllProductsReq): GetAllProductsRes
}
