package com.ecommerce.presentation.controller

import com.ecommerce.application.service.UserServiceI
import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.mapper.AuthUserMapper
import com.ecommerce.presentation.dto.user.mapper.CreateAdminUserMapper
import com.ecommerce.presentation.dto.user.mapper.CreateUserMapper
import com.ecommerce.presentation.dto.user.mapper.GetAllUserMapper
import com.ecommerce.presentation.dto.user.mapper.GetUserByIdMapper
import com.ecommerce.presentation.dto.user.mapper.LoginUserMapper
import com.ecommerce.presentation.dto.user.mapper.UpdateUserMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val service: UserServiceI
) {

    @GetMapping
    fun getById(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetUserByIdMapper.toRequest(user, id)
        val response = this.service.getById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun getAll(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = GetAllUserMapper.toRequest(user)
        val response = this.service.getAllUsers(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/auth")
    fun auth(
        @RequestAttribute("authenticatedUser") user: User?
    ): ResponseEntity<*> {
        val request = AuthUserMapper.toRequest(user)
        val response = this.service.auth(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun create(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateUserMapper.toRequest(user, payload)
        val response = this.service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun update(
        @RequestAttribute("authenticatedUser") user: User?,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateUserMapper.toRequest(user, id, payload)
        val response = this.service.update(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/admin")
    fun createAdmin(
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateAdminUserMapper.toRequest(payload)
        val response = this.service.createAdmin(request)
        return ResponseEntity.status(201).body(response)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = LoginUserMapper.toRequest(payload)
        val response = this.service.login(request)
        return ResponseEntity.ok(response)
    }
}
