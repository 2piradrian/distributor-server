package com.distributor.application.service

import com.distributor.application.use_case.user.*
import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status
import com.distributor.domain.entity.User
import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.distributor.presentation.dto.user.mapper.*
import com.distributor.presentation.dto.user.request.*
import com.distributor.presentation.dto.user.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val getById: GetUserByIdUseCase,
    private val getAll: GetAllUsersUseCase,
    private val authenticate: AuthenticateUserUseCase,
    private val login: LoginUserUseCase,
    private val create: CreateUserUseCase,
    private val update: UpdateUserUseCase,
    private val createAdmin: CreateAdminUserUseCase
) : UserServiceI {

    override fun auth(token: String): User {
        val result = this.authenticate.execute(
            command = AuthenticateUserUseCase.Command(
                token = token
            )
        )
        return result.user
    }

    override fun auth(dto: AuthUserReq): AuthUserRes {
        val result = this.authenticate.execute(
            command = AuthenticateUserUseCase.Command(
                token = dto.token
            )
        )
        return AuthUserMapper.toResponse(
            user = result.user
        )
    }

    override fun login(dto: LoginUserReq): LoginUserRes {
        val result = this.login.execute(
            command = LoginUserUseCase.Command(
                username = dto.username,
                password = dto.password
            )
        )
        return LoginUserMapper.toResponse(
            token = result.token
        )
    }

    override fun create(dto: CreateUserReq): CreateUserRes {
        val user = this.auth(dto.token)
        
        val result = this.create.execute(
            command = CreateUserUseCase.Command(
                user = user,
                username = dto.username,
                password = dto.password,
                role = Role.fromString(dto.role)
            )
        )
        return CreateUserMapper.toResponse(
            id = result.user.id!!
        )
    }

    override fun update(dto: UpdateUserReq): UpdateUserRes {
        val user = this.auth(dto.token)
        
        val result = this.update.execute(
            command = UpdateUserUseCase.Command(
                user = user,
                userId = dto.id,
                username = dto.username,
                password = dto.password,
                role = Role.fromString(dto.role),
                status = Status.fromString(dto.status)
            )
        )
        return UpdateUserMapper.toResponse(
            id = result.user.id!!
        )
    }

    override fun getById(dto: GetUserByIdReq): GetUserByIdRes {
        val user = this.auth(dto.token)
        
        val result = this.getById.execute(
            command = GetUserByIdUseCase.Command(
                user = user,
                userId = dto.id
            )
        )
        return GetUserByIdMapper.toResponse(
            user = result.user
        )
    }

    override fun createAdmin(dto: CreateAdminUserReq): CreateAdminUserRes {
        val result = this.createAdmin.execute(
            command = CreateAdminUserUseCase.Command(
                secret = dto.secret,
                username = dto.username,
                password = dto.password
            )
        )
        return CreateAdminUserMapper.toResponse(
            user = result.user
        )
    }

    override fun getAllUsers(dto: GetAllUserReq): GetAllUserRes {
        val user = this.auth(dto.token)
        
        val result = this.getAll.execute(
            command = GetAllUsersUseCase.Command(
                user = user
            )
        )
        return GetAllUserMapper.toResponse(
            users = result.users
        )
    }
}
