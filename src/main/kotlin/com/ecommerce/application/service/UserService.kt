package com.ecommerce.application.service

import com.ecommerce.application.use_case.user.*
import com.ecommerce.domain.entity.Role
import com.ecommerce.domain.entity.Status
import com.ecommerce.domain.entity.User
import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.ecommerce.presentation.dto.user.mapper.AuthUserMapper
import com.ecommerce.presentation.dto.user.mapper.CreateAdminUserMapper
import com.ecommerce.presentation.dto.user.mapper.CreateUserMapper
import com.ecommerce.presentation.dto.user.mapper.GetAllUserMapper
import com.ecommerce.presentation.dto.user.mapper.GetUserByIdMapper
import com.ecommerce.presentation.dto.user.mapper.LoginUserMapper
import com.ecommerce.presentation.dto.user.mapper.UpdateUserMapper
import com.ecommerce.presentation.dto.user.request.AuthUserReq
import com.ecommerce.presentation.dto.user.request.CreateAdminUserReq
import com.ecommerce.presentation.dto.user.request.CreateUserReq
import com.ecommerce.presentation.dto.user.request.GetAllUserReq
import com.ecommerce.presentation.dto.user.request.GetUserByIdReq
import com.ecommerce.presentation.dto.user.request.LoginUserReq
import com.ecommerce.presentation.dto.user.request.UpdateUserReq
import com.ecommerce.presentation.dto.user.response.AuthUserRes
import com.ecommerce.presentation.dto.user.response.CreateAdminUserRes
import com.ecommerce.presentation.dto.user.response.CreateUserRes
import com.ecommerce.presentation.dto.user.response.GetAllUserRes
import com.ecommerce.presentation.dto.user.response.GetUserByIdRes
import com.ecommerce.presentation.dto.user.response.LoginUserRes
import com.ecommerce.presentation.dto.user.response.UpdateUserRes
import org.springframework.stereotype.Service

@Service
class UserService(
    private val getById: GetUserByIdUseCase,
    private val getAll: GetAllUsersUseCase,
    private val authenticate: AuthenticateUserUseCase,
    private val login: LoginUserUseCase,
    private val create: CreateUserUseCase,
    private val update: UpdateUserUseCase,
    private val createAdmin: CreateAdminUserUseCase
) : UserServiceI {

    override fun auth(dto: AuthUserReq): AuthUserRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)
        return AuthUserMapper.toResponse(user = user)
    }

    override fun tryAuth(token: String?): User? {
        if (token.isNullOrEmpty()) return null
        return try {
            return authenticate.execute(
                command = AuthenticateUserUseCase.Command(
                    token = token
                )
            ).user
        }
        catch (e: Exception) {
            null
        }
    }

    override fun login(dto: LoginUserReq): LoginUserRes {
        val result = this.login.execute(
            command = LoginUserUseCase.Command(
                username = dto.username!!,
                password = dto.password!!
            )
        )
        return LoginUserMapper.toResponse(
            token = result.token
        )
    }

    override fun create(dto: CreateUserReq): CreateUserRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val result = this.create.execute(
            command = CreateUserUseCase.Command(
                user = user,
                username = dto.username!!,
                password = dto.password!!,
                role = Role.fromString(dto.role!!)
            )
        )
        return CreateUserMapper.toResponse(
            id = result.user.id!!
        )
    }

    override fun update(dto: UpdateUserReq): UpdateUserRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val result = this.update.execute(
            command = UpdateUserUseCase.Command(
                user = user,
                userId = dto.id!!,
                username = dto.username!!,
                password = dto.password!!,
                role = Role.fromString(dto.role!!),
                status = Status.fromString(dto.status!!)
            )
        )
        return UpdateUserMapper.toResponse(
            id = result.user.id!!
        )
    }

    override fun getById(dto: GetUserByIdReq): GetUserByIdRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

        val result = this.getById.execute(
            command = GetUserByIdUseCase.Command(
                user = user,
                userId = dto.id!!
            )
        )
        return GetUserByIdMapper.toResponse(
            user = result.user
        )
    }

    override fun createAdmin(dto: CreateAdminUserReq): CreateAdminUserRes {
        val result = this.createAdmin.execute(
            command = CreateAdminUserUseCase.Command(
                secret = dto.secret!!,
                username = dto.username!!,
                password = dto.password!!
            )
        )
        return CreateAdminUserMapper.toResponse(
            user = result.user
        )
    }

    override fun getAllUsers(dto: GetAllUserReq): GetAllUserRes {
        val user: User = dto.user ?: throw ErrorHandler(ErrorType.UNAUTHORIZED)

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
