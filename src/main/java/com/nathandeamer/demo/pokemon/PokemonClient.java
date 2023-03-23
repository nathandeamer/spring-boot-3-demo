package com.nathandeamer.demo.pokemon;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface PokemonClient {

    @GetExchange("/pokemon/{name}")
    PokemonDTO getPokemonByName(@PathVariable String name);


}
