package com.nathandeamer.demo.pokemon;

import com.nathandeamer.demo.shared.exceptions.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PokemonExceptionHandler {

    @ExceptionHandler({PokemonNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiResponse(
            responseCode = "404",
            description = "Pokemon not found",
            content = @Content(
                    examples = {@ExampleObject(
                            value = "{\n" +
                                    "  \"httpStatusCode\": 404,\n" +
                                    "  \"url\": \"http://localhost:8080/api/v1\",\n" +
                                    "  \"errorCode\": \"POKE-404\",\n" +
                                    "  \"errorMessage\": \"Pokemon not found\"\n" +
                                    "}"
                    )},
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))
    )
    public ResponseEntity<ErrorResponse> handlePokemonNotFoundException(HttpServletRequest request, PokemonNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatusCode(exception.getHttpStatusCode().value())
                .url(request.getRequestURL().toString())
                .errorCode("POKE-404")
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity
                .status(errorResponse.getHttpStatusCode())
                .body(errorResponse);
    }

}
