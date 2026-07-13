package com.ecommerce.application.service

import com.ecommerce.presentation.dto.catalog.request.GetProductCatalogReq
import com.ecommerce.presentation.dto.catalog.request.GetProductCatalogByIdReq
import com.ecommerce.presentation.dto.catalog.request.GetCategoryCatalogReq
import com.ecommerce.presentation.dto.catalog.request.GetCategoryCatalogByIdReq
import com.ecommerce.presentation.dto.catalog.response.GetProductCatalogRes
import com.ecommerce.presentation.dto.catalog.response.GetProductCatalogByIdRes
import com.ecommerce.presentation.dto.catalog.response.GetCategoryCatalogRes
import com.ecommerce.presentation.dto.catalog.response.GetCategoryCatalogByIdRes
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface CatalogServiceI {
    fun getProductCatalog(@Valid dto: GetProductCatalogReq): GetProductCatalogRes
    fun getProductCatalogById(@Valid dto: GetProductCatalogByIdReq): GetProductCatalogByIdRes
    fun getCategoryCatalog(@Valid dto: GetCategoryCatalogReq): GetCategoryCatalogRes
    fun getCategoryCatalogById(@Valid dto: GetCategoryCatalogByIdReq): GetCategoryCatalogByIdRes
}
