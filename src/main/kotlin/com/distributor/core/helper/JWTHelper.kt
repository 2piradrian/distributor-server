package com.distributor.core.helper

import com.distributor.domain.entity.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey

@Component
class JWTHelper(
    @Value("\${application.jwt.secret}") val secret: String,
    @Value("\${application.jwt.expiration}") val expiration: Long
) {

    private fun getSecretKey(): SecretKey {
        return Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
    }

    private fun getExpirationDate(token: String): Date {
        return getClaims(token) { it.expiration }
    }

    private fun <T> getClaims(token: String, resolver: (Claims) -> T): T {
        return resolver(parseToken(token))
    }

    fun getSubject(token: String): String {
        return getClaims(token) { it.subject }
    }

    private fun parseToken(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .body
    }

    fun createToken(user: User): String {
        val now = Date()
        val expirationDate = Date(now.time + expiration)

        return Jwts.builder()
            .setSubject(user.id)
            .setIssuedAt(now)
            .setExpiration(expirationDate)
            .signWith(getSecretKey(), SignatureAlgorithm.HS256)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            val expirationDate = getExpirationDate(token)
            expirationDate.after(Date())
        } catch (e: Exception) {
            false
        }
    }
}
