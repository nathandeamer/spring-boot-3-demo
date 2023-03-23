package com.nathandeamer.demo.pokemon;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonClient pokemonClient;
    private final ObservationRegistry observationRegistry;

    public PokemonDTO getPokemonByName(String name) {
        return Observation.createNotStarted("my.observation", observationRegistry)
                .observe(() -> pokemonClient.getPokemonByName(name));
    }
}
