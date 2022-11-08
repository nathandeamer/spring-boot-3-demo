package com.nathandeamer.demo.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PokemonDTO {

    @Schema(description = "Pokemon ID", example = "151")
    int id;

    @Schema(description = "Pokemon Name", example= "mew")
    String name;

    @Schema(description = "Pokemon Base Experience", example= "300")
    @JsonProperty("base_experience")
    int baseExperience;

    @Schema(description = "Pokemon Weight", example = "40")
    int weight;

    @Schema(description = "Pokemon Height", example = "4")
    int height;

}
