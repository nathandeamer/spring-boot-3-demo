package com.nathandeamer.demo.pokemon;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonDTO getPokemonByName(String name) {
        return pokemonClient.getPokemonByName(name);
    }
}
