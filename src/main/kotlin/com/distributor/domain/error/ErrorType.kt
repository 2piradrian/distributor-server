package com.distributor.domain.error

enum class ErrorType(val message: String, val httpCode: Int) {
    UNAUTHORIZED("Unauthorized", 401),
    INVALID_PASSWORD("Invalid password", 400),

    MISSING_REQUIRED_FIELDS("Missing required fields", 400),
    INVALID_FIELDS("Invalid fields", 400),

    INVALID_ROLE("Invalid Role", 400),
    INVALID_STATUS("Invalid Status", 400),

    PRODUCT_ALREADY_EXISTS("Product already exists", 400),
    USERNAME_ALREADY_EXISTS("Username already exists", 400),

    USER_NOT_FOUND("User not found", 404),

    INTERNAL_ERROR("Internal error", 500),
}
