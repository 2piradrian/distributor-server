package com.ecommerce.application.service

import com.ecommerce.domain.entity.User
import com.ecommerce.presentation.dto.user.request.AuthUserReq
import com.ecommerce.presentation.dto.user.request.LoginUserReq
import com.ecommerce.presentation.dto.user.request.CreateUserReq
import com.ecommerce.presentation.dto.user.request.UpdateUserReq
import com.ecommerce.presentation.dto.user.request.GetUserByIdReq
import com.ecommerce.presentation.dto.user.request.CreateAdminUserReq
import com.ecommerce.presentation.dto.user.request.GetAllUserReq
import com.ecommerce.presentation.dto.user.response.AuthUserRes
import com.ecommerce.presentation.dto.user.response.LoginUserRes
import com.ecommerce.presentation.dto.user.response.CreateUserRes
import com.ecommerce.presentation.dto.user.response.UpdateUserRes
import com.ecommerce.presentation.dto.user.response.GetUserByIdRes
import com.ecommerce.presentation.dto.user.response.CreateAdminUserRes
import com.ecommerce.presentation.dto.user.response.GetAllUserRes
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface UserServiceI {
    fun tryAuth(token: String?): User?
    fun auth(@Valid dto: AuthUserReq): AuthUserRes
    fun login(@Valid dto: LoginUserReq): LoginUserRes
    fun create(@Valid dto: CreateUserReq): CreateUserRes
    fun update(@Valid dto: UpdateUserReq): UpdateUserRes
    fun getById(@Valid dto: GetUserByIdReq): GetUserByIdRes
    fun createAdmin(@Valid dto: CreateAdminUserReq): CreateAdminUserRes
    fun getAllUsers(@Valid dto: GetAllUserReq): GetAllUserRes
}
