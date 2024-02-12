package com.zerobase.api.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackages = ["com.zerobase.api"])
class ExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(e: CustomException):
            ResponseEntity<ErrorResponse.ErrorResponseDto> {
        e.printStackTrace()
        return ErrorResponse(e).toResponseEntity()
    }


    @ExceptionHandler(RuntimeException::class)
    fun customExceptionHandler(e: RuntimeException):
            ResponseEntity<ErrorResponse.ErrorResponseDto> {
        e.printStackTrace()
        return ErrorResponse(CustomException(CustomErrorCode.INTERNAL_SERVER_ERROR)).toResponseEntity()
    }
}