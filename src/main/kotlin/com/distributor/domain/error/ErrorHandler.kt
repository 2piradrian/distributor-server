package com.distributor.domain.error

class ErrorHandler(errorType: ErrorType) : RuntimeException(errorType.message) {
    val httpCode: Int = errorType.httpCode

    fun toResponse(): ErrorResponse {
        return ErrorResponse(this)
    }
}
