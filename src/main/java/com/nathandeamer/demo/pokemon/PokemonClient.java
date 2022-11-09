package com.nathandeamer.demo.pokemon;

import com.nathandeamer.demo.shared.exceptions.ClientException;
import com.nathandeamer.demo.shared.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
                .onStatus(HttpStatusCode::isError, clientResponse -> processError(clientResponse, name))
                .bodyToMono(PokemonDTO.class)
                .block();
    }

    private Mono<? extends Throwable> processError(ClientResponse clientResponse, String name) {

        return clientResponse.bodyToMono(String.class)
                .flatMap(errorString -> {
                    if (clientResponse.statusCode().is4xxClientError()) {
                        if (HttpStatus.NOT_FOUND.value() == clientResponse.statusCode().value()) {
                            return Mono.error(new PokemonNotFoundException(clientResponse.statusCode(), name));
                        }
                        return Mono.error(new ClientException(clientResponse.statusCode(), errorString));
                    }
                    return Mono.error(new ServerException(clientResponse.statusCode(), errorString));
                });
    }

}
