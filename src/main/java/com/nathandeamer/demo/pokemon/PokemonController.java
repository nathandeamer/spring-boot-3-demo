package com.nathandeamer.demo.pokemon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping(path = "/pokemon")
    public PokemonDTO get(@RequestParam String name) {
        return pokemonService.getPokemonByName(name);
    }

}
