package com.nathandeamer.demo.pokemon;

import com.nathandeamer.demo.shared.exceptions.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PokemonExceptionHandler {

    @ExceptionHandler({PokemonNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
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
