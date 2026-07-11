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
    fun getShopById(@Valid dto: GetProductByIdReq): GetProductByIdRes
    fun getShopCatalog(@Valid dto: GetAllProductsReq): GetAllProductsRes
    fun getBackofficeById(@Valid dto: GetProductByIdReq): GetProductByIdRes
    fun getBackofficeCatalog(@Valid dto: GetAllProductsReq): GetAllProductsRes
}
