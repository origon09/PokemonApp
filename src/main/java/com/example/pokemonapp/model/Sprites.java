package com.example.pokemonapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sprites {

//    @Value("default")
    private String front_default;
    private String front_shiny;
}
