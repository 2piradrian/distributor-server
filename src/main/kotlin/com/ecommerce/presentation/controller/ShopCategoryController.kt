package com.ecommerce.presentation.controller

import com.ecommerce.application.service.CategoryServiceI
import com.ecommerce.presentation.dto.category.mapper.ShopGetAllCategoriesMapper
import com.ecommerce.presentation.dto.category.mapper.ShopGetCategoryByIdMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shop/categories")
class ShopCategoryController(
    private val service: CategoryServiceI
) {

    @GetMapping
    fun getShopCategoryById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = ShopGetCategoryByIdMapper.toRequest(id)
        val response = service.getShopCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun getAllShopCategories(): ResponseEntity<*> {
        val request = ShopGetAllCategoriesMapper.toRequest()
        val response = service.getAllShopCategories(request)
        return ResponseEntity.ok(response)
    }
}
