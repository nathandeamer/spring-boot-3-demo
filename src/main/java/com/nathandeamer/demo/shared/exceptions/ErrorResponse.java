package com.nathandeamer.demo.shared.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

    @Schema(description = "The HTTP status code (same the the response status code)", example = "404")
    private final int httpStatusCode;

    @Schema(description = "The URL that triggered the error", example = "http://localhost:8080/api/v1")
    private final String url;

    @Schema(description = "An internal error code", example = "ABC-123")
    private final String errorCode;

    @Schema(description = "Error details", example = "Sorry, something went wrong!")
    private final String errorMessage;
}
