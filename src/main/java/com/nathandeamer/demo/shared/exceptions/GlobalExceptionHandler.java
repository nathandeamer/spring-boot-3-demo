package com.nathandeamer.demo.shared.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ClientException.class})
    @ResponseBody()
    public ResponseEntity<ErrorResponse> handleClientException(HttpServletRequest request, ClientException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatusCode(exception.getHttpStatusCode().value())
                .url(request.getRequestURL().toString())
                .errorCode("CLIENT-000")
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity
                .status(errorResponse.getHttpStatusCode())
                .body(errorResponse);
    }

    @ExceptionHandler({ServerException.class})
    @ResponseBody()
    public ResponseEntity<ErrorResponse> handleServerException(HttpServletRequest request, ServerException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatusCode(exception.getHttpStatusCode().value())
                .url(request.getRequestURL().toString())
                .errorCode("SERVER-000")
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity
                .status(errorResponse.getHttpStatusCode())
                .body(errorResponse);
    }

}
