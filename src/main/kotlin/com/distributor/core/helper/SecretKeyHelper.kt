package com.distributor.core.helper

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SecretKeyHelper(
    @Value("\${application.internal.secret}") val secret: String
) {
    fun isValid(provided: String): Boolean {
        return secret == provided
    }
}
