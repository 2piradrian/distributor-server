package com.distributor.domain.entity

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class Status(val displayName: String) {

    ACTIVE("Activo"),
    INACTIVE("Inactivo");

    companion object {
        fun fromString(value: String): Status {
            return try {
                valueOf(value.trim().uppercase().replace(" ", "_"))
            } catch (e: Exception) {
                throw ErrorHandler(ErrorType.INVALID_STATUS)
            }
        }
    }

    fun toMap(): Map<String, String> {
        return mapOf(
            "value" to this.name,
            "name" to this.displayName
        )
    }

    fun getValue(): String {
        return this.name
    }

    fun getName(): String {
        return this.displayName
    }
}
