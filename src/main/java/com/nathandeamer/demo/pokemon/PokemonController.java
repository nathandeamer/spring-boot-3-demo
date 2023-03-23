package com.nathandeamer.demo.pokemon;

import io.micrometer.observation.annotation.Observed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Pokemon", description = "The Pokemon API")
/*
    WebClient example - Calling a third party API.
 */
public class PokemonController {

    private final PokemonService pokemonService;

    //@Observed(name="get_pokemon_by_name", contextualName = "get_pokemon_by_name")
    @Operation(summary = "Get a Pokemon by Name", description = "Get a Pokemon by Name")
    @GetMapping(path = "/pokemon", produces = { "application/json" })
    public PokemonDTO get(@Parameter(description = "Name of pokemon", required = true) @RequestParam String name) {
        log.info("Getting pokemon by name: {}", name);
        return pokemonService.getPokemonByName(name);
    }
}
