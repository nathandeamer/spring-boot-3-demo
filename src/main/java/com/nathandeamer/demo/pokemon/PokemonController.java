package com.nathandeamer.demo.pokemon;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
public class PokemonController {

    private final PokemonService pokemonService;



    @Operation(summary = "Get a Pokemon by Name", description = "Get a Pokemon by Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = PokemonDTO.class)))
    })
    @GetMapping(path = "/pokemon", produces = { "application/json" })
    public PokemonDTO get(@Parameter(description = "Name of pokemon", required = true) @RequestParam String name) {
        log.info("Getting pokemon by name: {}", name);
        return pokemonService.getPokemonByName(name);
    }
}
