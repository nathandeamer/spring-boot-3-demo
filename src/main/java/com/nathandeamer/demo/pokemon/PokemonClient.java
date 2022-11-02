package com.nathandeamer.demo.pokemon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Component
public class PokemonClient {

    private final WebClient client;

    public PokemonClient(@Value("${pokemon.base-url}") String pokemonBaseUrl) {
        this.client = WebClient.builder()
            .baseUrl(pokemonBaseUrl)
            .build();
    }

    public PokemonDTO getPokemonByName(String name) {
        return this.client
                .get()
                .uri("/pokemon/" + name)
                .retrieve()
                .bodyToMono(PokemonDTO.class)
                .block(Duration.ofSeconds(3));
    }

}
