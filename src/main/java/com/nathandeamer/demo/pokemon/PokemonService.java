package com.nathandeamer.demo.pokemon;

import com.nathandeamer.demo.shared.exceptions.ClientException;
import com.nathandeamer.demo.shared.exceptions.ServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonDTO getPokemonByName(String name) {
        try {
            return pokemonClient.getPokemonByName(name);
        } catch (WebClientResponseException e) {
            log.error("getPokemonByName through exception {}", e.getMessage(), e);
            if (e.getStatusCode().is4xxClientError()) {
                if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new PokemonNotFoundException(e.getStatusCode(), name);
                }
                throw new ClientException(e.getStatusCode(), e.getResponseBodyAsString());
            }
            throw new ServerException(e.getStatusCode(), e.getResponseBodyAsString());
        }
    }
}
