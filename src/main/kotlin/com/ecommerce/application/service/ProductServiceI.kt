package com.ecommerce.application.service

import com.ecommerce.presentation.dto.product.request.ShopGetAllProductsReq
import com.ecommerce.presentation.dto.product.request.ShopGetProductByIdReq
import com.ecommerce.presentation.dto.product.response.ShopGetAllProductsRes
import com.ecommerce.presentation.dto.product.response.ShopGetProductByIdRes
import com.ecommerce.presentation.dto.product.request.BackofficeCreateProductReq
import com.ecommerce.presentation.dto.product.request.BackofficeUpdateProductReq
import com.ecommerce.presentation.dto.product.request.BackofficeDeleteProductReq
import com.ecommerce.presentation.dto.product.request.BackofficeGetAllProductsReq
import com.ecommerce.presentation.dto.product.request.BackofficeGetProductByIdReq
import com.ecommerce.presentation.dto.product.response.BackofficeCreateProductRes
import com.ecommerce.presentation.dto.product.response.BackofficeUpdateProductRes
import com.ecommerce.presentation.dto.product.response.BackofficeGetAllProductsRes
import com.ecommerce.presentation.dto.product.response.BackofficeGetProductByIdRes
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface ProductServiceI {
    fun backofficeCreateProduct(@Valid dto: BackofficeCreateProductReq): BackofficeCreateProductRes
    fun backofficeUpdateProduct(@Valid dto: BackofficeUpdateProductReq): BackofficeUpdateProductRes
    fun backofficeDeleteProduct(@Valid dto: BackofficeDeleteProductReq)
    fun shopGetProductById(@Valid dto: ShopGetProductByIdReq): ShopGetProductByIdRes
    fun shopGetAllProducts(@Valid dto: ShopGetAllProductsReq): ShopGetAllProductsRes
    fun backofficeGetProductById(@Valid dto: BackofficeGetProductByIdReq): BackofficeGetProductByIdRes
    fun backofficeGetAllProducts(@Valid dto: BackofficeGetAllProductsReq): BackofficeGetAllProductsRes
}
