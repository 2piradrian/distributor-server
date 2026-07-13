package com.ecommerce.application.service

import com.ecommerce.application.use_case.catalog.*
import com.ecommerce.presentation.dto.catalog.mapper.*
import com.ecommerce.presentation.dto.catalog.request.*
import com.ecommerce.presentation.dto.catalog.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CatalogService(
    private val getProductCatalog: GetProductCatalogUseCase,
    private val getProductCatalogById: GetProductCatalogByIdUseCase,
    private val getCategoryCatalog: GetCategoryCatalogUseCase,
    private val getCategoryCatalogById: GetCategoryCatalogByIdUseCase
) : CatalogServiceI {

    override fun getProductCatalog(dto: GetProductCatalogReq): GetProductCatalogRes {
        val result = getProductCatalog.execute(
            command = GetProductCatalogUseCase.Command(
                filters = dto.filters
            )
        )
        return GetProductCatalogMapper.toResponse(result.products)
    }

    override fun getProductCatalogById(dto: GetProductCatalogByIdReq): GetProductCatalogByIdRes {
        val result = getProductCatalogById.execute(
            command = GetProductCatalogByIdUseCase.Command(
                id = dto.id
            )
        )
        return GetProductCatalogByIdMapper.toResponse(result.product)
    }

    override fun getCategoryCatalog(dto: GetCategoryCatalogReq): GetCategoryCatalogRes {
        val result = getCategoryCatalog.execute()
        return GetCategoryCatalogMapper.toResponse(result.categories)
    }

    override fun getCategoryCatalogById(dto: GetCategoryCatalogByIdReq): GetCategoryCatalogByIdRes {
        val result = getCategoryCatalogById.execute(
            command = GetCategoryCatalogByIdUseCase.Command(
                id = dto.id
            )
        )
        return GetCategoryCatalogByIdMapper.toResponse(result.category)
    }
}
