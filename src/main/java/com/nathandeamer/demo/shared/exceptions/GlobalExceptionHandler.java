package com.nathandeamer.demo.shared.exceptions;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ClientException.class})
    @ApiResponse(
            responseCode = "4xx",
            description = "Default client exception",
            content = @Content(
                    examples = {@ExampleObject(
                            value = "{\n" +
                                    "  \"httpStatusCode\": 400,\n" +
                                    "  \"url\": \"http://localhost:8080/api/v1\",\n" +
                                    "  \"errorCode\": \"ABC-400\",\n" +
                                    "  \"errorMessage\": \"Sorry, something went wrong!\"\n" +
                                    "}"
                    )},
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))
    )
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
    @ApiResponse(
            responseCode = "5xx",
            description = "Default server exception",
            content = @Content(
                    examples = {@ExampleObject(
                            value = "{\n" +
                                    "  \"httpStatusCode\": 500,\n" +
                                    "  \"url\": \"http://localhost:8080/api/v1\",\n" +
                                    "  \"errorCode\": \"ABC-500\",\n" +
                                    "  \"errorMessage\": \"Sorry, something went wrong!\"\n" +
                                    "}"
                    )},
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))
    )
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
