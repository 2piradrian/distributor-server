package com.distributor.presentation.controller

import com.distributor.application.service.UserServiceI
import com.distributor.presentation.dto.user.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val service: UserServiceI
) {

    @GetMapping
    fun getById(
        @RequestHeader("Authorization") token: String,
        @RequestParam id: String
    ): ResponseEntity<*> {
        val request = GetUserByIdMapper.toRequest(token, id)
        val response = service.getById(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun getAll(
        @RequestHeader("Authorization") token: String
    ): ResponseEntity<*> {
        val request = GetAllUserMapper.toRequest(token)
        val response = service.getAllUsers(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/auth")
    fun auth(
        @RequestHeader("Authorization") token: String
    ): ResponseEntity<*> {
        val request = AuthUserMapper.toRequest(token)
        val response = service.auth(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun create(
        @RequestHeader("Authorization") token: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateUserMapper.toRequest(token, payload)
        val response = service.create(request)
        return ResponseEntity.status(201).body(response)
    }

    @PutMapping
    fun update(
        @RequestHeader("Authorization") token: String,
        @RequestParam id: String,
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = UpdateUserMapper.toRequest(token, id, payload)
        val response = service.update(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/admin")
    fun createAdmin(
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = CreateAdminUserMapper.toRequest(payload)
        val response = service.createAdmin(request)
        return ResponseEntity.status(201).body(response)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody payload: Map<String, Any>
    ): ResponseEntity<*> {
        val request = LoginUserMapper.toRequest(payload)
        val response = service.login(request)
        return ResponseEntity.ok(response)
    }
}
