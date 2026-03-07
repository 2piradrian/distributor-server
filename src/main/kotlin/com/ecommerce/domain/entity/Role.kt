package com.ecommerce.domain.entity

import com.ecommerce.domain.error.ErrorHandler
import com.ecommerce.domain.error.ErrorType
import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class Role(
    val displayName: String
) {

    ADMIN("Administrador"),
    LOGISTICA("Logistica"),
    COMERCIAL("Comercial"),
    INVITADO("Invitado");

    companion object {
        fun fromString(value: String): Role {
            return try {
                valueOf(value.trim().uppercase().replace(" ", "_"))
            }
            catch (e: Exception) {
                throw ErrorHandler(ErrorType.INVALID_ROLE)
            }
        }
    }

    fun toMap(): Map<String, String> {
        return mapOf(
            "value" to this.name,
            "name" to this.displayName
        )
    }

}
