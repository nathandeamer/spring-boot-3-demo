package com.nathandeamer.demo.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonDTO {

    int id;

    String name;

    @JsonProperty("base_experience")
    int baseExperience;

    int weight;

    int height;

}
