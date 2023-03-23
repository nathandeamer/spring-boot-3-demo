package com.nathandeamer.demo.pokemon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Slf4j
@Configuration
public class PokemonClientConfiguration {

    @Bean
    PokemonClient pokemonClient(@Value("${pokemon.base-url}") String pokemonBaseUrl) {
        WebClient webClient = WebClient.builder()
//                .defaultStatusHandler(HttpStatusCode::isError, this::handleError)
                .baseUrl(pokemonBaseUrl)
                .build();

        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build()
                .createClient(PokemonClient.class);
    }


// TODO: Can't get the original request with the defaultStatusHandler.
//    private Mono<? extends Throwable> handleError(ClientResponse clientResponse) {
//        return clientResponse.bodyToMono(String.class)
//                .flatMap(errorString -> {
//                    if (clientResponse.statusCode().is4xxClientError()) {
//                        if (HttpStatus.NOT_FOUND.value() == clientResponse.statusCode().value()) {
//                            return Mono.error(new PokemonNotFoundException(clientResponse.statusCode(), errorString));
//                        }
//                        return Mono.error(new ClientException(clientResponse.statusCode(), errorString));
//                    }
//                    return Mono.error(new ClientException(clientResponse.statusCode(), errorString));
//                });
//    }

}
