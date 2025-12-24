package com.distributor.core.handler

import com.distributor.domain.error.ErrorHandler
import com.distributor.domain.error.ErrorType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ErrorHandler::class)
    fun handleErrorHandler(e: ErrorHandler): ResponseEntity<*> {
        return ResponseEntity
            .status(e.httpCode)
            .body(e.toResponse())
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<*> {
        return ResponseEntity
            .status(500)
            .body(ErrorHandler(ErrorType.INTERNAL_ERROR).toResponse())
    }
}
