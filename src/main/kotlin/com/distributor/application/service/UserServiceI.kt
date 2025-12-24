package com.distributor.application.service

import com.distributor.domain.entity.User
import com.distributor.presentation.dto.user.request.*
import com.distributor.presentation.dto.user.response.*

interface UserServiceI {
    fun auth(token: String): User
    fun auth(dto: AuthUserReq): AuthUserRes
    fun login(dto: LoginUserReq): LoginUserRes
    fun create(dto: CreateUserReq): CreateUserRes
    fun update(dto: UpdateUserReq): UpdateUserRes
    fun getById(dto: GetUserByIdReq): GetUserByIdRes
    fun createAdmin(dto: CreateAdminUserReq): CreateAdminUserRes
    fun getAllUsers(dto: GetAllUserReq): GetAllUserRes
}
