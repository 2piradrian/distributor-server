package com.distributor.core.helper

import com.distributor.domain.entity.Token
import com.distributor.domain.entity.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthHelper(
    private val passwordEncoder: PasswordEncoder,
    private val jwtHelper: JWTHelper
) {

    fun hashPassword(password: String): String {
        return passwordEncoder.encode(password)
    }

    fun validatePassword(user: User, password: String): Boolean {
        return passwordEncoder.matches(password, user.password)
    }

    fun createToken(user: User): Token {
        return Token(jwtHelper.createToken(user))
    }

    fun validateToken(rawHeader: String?): String? {
        if (rawHeader.isNullOrBlank()) {
            return null
        }

        if (!rawHeader.startsWith("Bearer ")) {
            return null
        }

        val tokenValue = rawHeader.substring(7).trim()

        return try {
            if (jwtHelper.validateToken(tokenValue)) {
                tokenValue
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun getSubject(token: String): String {
        return jwtHelper.getSubject(token)
    }
}
