package com.nathandeamer.demo.pokemon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
public class PokemonNotFoundException extends RuntimeException {

    private HttpStatusCode httpStatusCode;

    public PokemonNotFoundException(HttpStatusCode httpStatusCode, String name) {
        super(String.format("Could not find pokemon for name: %s", name));
        this.httpStatusCode = httpStatusCode;
    }
}
