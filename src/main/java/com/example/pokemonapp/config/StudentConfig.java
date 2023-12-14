package com.example.pokemonapp.config;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(PokemonRepository repository) {
        return args -> {
            Pokemon squirtle = new Pokemon(
                    "Squirtle",
                    "Water",
                    25,
                    20,
                    25

            );
            Pokemon bulbusaur = new Pokemon(
                    "Bulbasaur",
                    "Grass",
                    20,
                    20,
                    30

            );
            repository.saveAll(
                    List.of(squirtle, bulbusaur)
            );

        };
    }
}
