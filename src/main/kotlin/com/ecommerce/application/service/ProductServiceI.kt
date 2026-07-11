package com.ecommerce.application.service

import com.ecommerce.presentation.dto.product.request.*
import com.ecommerce.presentation.dto.product.response.*
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface ProductServiceI {
    fun createProduct(@Valid dto: CreateBackofficeProductReq): CreateBackofficeProductRes
    fun updateProduct(@Valid dto: UpdateBackofficeProductReq): UpdateBackofficeProductRes
    fun deleteProduct(@Valid dto: DeleteBackofficeProductReq)
    fun getShopProductById(@Valid dto: GetShopProductByIdReq): GetShopProductByIdRes
    fun getAllShopProducts(@Valid dto: GetAllShopProductsReq): GetAllShopProductsRes
    fun getBackofficeProductById(@Valid dto: GetBackofficeProductByIdReq): GetBackofficeProductByIdRes
    fun getAllBackofficeProducts(@Valid dto: GetAllBackofficeProductsReq): GetAllBackofficeProductsRes
}
