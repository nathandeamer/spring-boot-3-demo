package com.nathandeamer.demo.pokemon;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping(path = "/pokemon")
    public PokemonDTO get(@RequestParam String name) {
        log.info("Getting pokemon by name: {}", name);
        return pokemonService.getPokemonByName(name);
    }

}
