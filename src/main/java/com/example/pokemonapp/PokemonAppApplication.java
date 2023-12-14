package com.example.pokemonapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PokemonAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonAppApplication.class, args);
    }

}
