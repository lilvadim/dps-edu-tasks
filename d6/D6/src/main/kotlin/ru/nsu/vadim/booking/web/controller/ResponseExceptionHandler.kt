package ru.nsu.vadim.booking.web.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import ru.nsu.vadim.booking.web.dto.ErrorResponse

@ControllerAdvice
class ResponseExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        val requestUrl = (request as ServletWebRequest).request.requestURI
        val errorResponse = ErrorResponse(requestUrl, ex.message ?: "")
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}