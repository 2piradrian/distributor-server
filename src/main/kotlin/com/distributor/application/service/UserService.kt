package com.distributor.application.service

import com.distributor.application.use_case.user.*
import com.distributor.domain.entity.Role
import com.distributor.domain.entity.Status
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

    override fun auth(token: String): com.distributor.domain.entity.User {
        val result = authenticate.execute(AuthenticateUserUseCase.Command(token))
        return result.user
    }

    override fun auth(dto: AuthUserReq): AuthUserRes {
        val result = authenticate.execute(AuthenticateUserUseCase.Command(dto.token))
        return AuthUserMapper.toResponse(result.user)
    }

    override fun login(dto: LoginUserReq): LoginUserRes {
        val result = login.execute(LoginUserUseCase.Command(dto.username, dto.password))
        return LoginUserMapper.toResponse(result.token)
    }

    override fun create(dto: CreateUserReq): CreateUserRes {
        val user = auth(dto.token)
        
        val result = create.execute(
            CreateUserUseCase.Command(
                user,
                dto.username,
                dto.password,
                Role.fromString(dto.role)
            )
        )
        return CreateUserMapper.toResponse(result.user.id)
    }

    override fun update(dto: UpdateUserReq): UpdateUserRes {
        val user = auth(dto.token)
        
        val result = update.execute(
            UpdateUserUseCase.Command(
                user,
                dto.id,
                dto.username,
                dto.password,
                Role.fromString(dto.role),
                Status.fromString(dto.status)
            )
        )
        return UpdateUserMapper.toResponse(result.user.id)
    }

    override fun getById(dto: GetUserByIdReq): GetUserByIdRes {
        val user = auth(dto.token)
        
        val result = getById.execute(
            GetUserByIdUseCase.Command(user, dto.id)
        )
        return GetUserByIdMapper.toResponse(result.user)
    }

    override fun createAdmin(dto: CreateAdminUserReq): CreateAdminUserRes {
        val result = createAdmin.execute(
            CreateAdminUserUseCase.Command(
                dto.secret,
                dto.username,
                dto.password
            )
        )
        return CreateAdminUserMapper.toResponse(result.user)
    }

    override fun getAllUsers(dto: GetAllUserReq): GetAllUserRes {
        val user = auth(dto.token)
        
        val result = getAll.execute(
            GetAllUsersUseCase.Command(user)
        )
        return GetAllUserMapper.toResponse(result.users)
    }
}
