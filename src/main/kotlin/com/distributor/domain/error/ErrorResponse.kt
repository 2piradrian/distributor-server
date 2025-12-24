package com.distributor.domain.error

data class ErrorResponse(val message: String?) {
    constructor(errorHandler: ErrorHandler) : this(errorHandler.message)
}
