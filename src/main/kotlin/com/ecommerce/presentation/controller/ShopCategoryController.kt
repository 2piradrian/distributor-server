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
    fun shopGetCategoryById(
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = ShopGetCategoryByIdMapper.toRequest(id)
        val response = service.shopGetCategoryById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/catalog")
    fun shopGetAllCategories(): ResponseEntity<*> {
        val request = ShopGetAllCategoriesMapper.toRequest()
        val response = service.shopGetAllCategories(request)
        return ResponseEntity.ok(response)
    }
}
