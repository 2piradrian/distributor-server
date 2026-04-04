package com.ecommerce.application.service

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.*
import com.ecommerce.presentation.dto.user.response.*
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface UserServiceI {
    fun auth(token: String): User
    fun tryAuth(token: String?): User?
    fun auth(@Valid dto: AuthUserReq): AuthUserRes
    fun login(@Valid dto: LoginUserReq): LoginUserRes
    fun create(@Valid dto: CreateUserReq): CreateUserRes
    fun update(@Valid dto: UpdateUserReq): UpdateUserRes
    fun getById(@Valid dto: GetUserByIdReq): GetUserByIdRes
    fun createAdmin(@Valid dto: CreateAdminUserReq): CreateAdminUserRes
    fun getAllUsers(@Valid dto: GetAllUserReq): GetAllUserRes
}
