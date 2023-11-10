package com.example.pokemonapp.Controller;

import com.example.pokemonapp.Model.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class PokemonController {

    @GetMapping
    public String home (){
        return "Welcome to the Pokedex";
    }

    @GetMapping("/Pokedex")
    public HashMap<Pokemon, String> getAllPokemon(String Authorization) {
        return null;
    }

    @PostMapping("/addPokemon")
    public Pokemon addPokemon(String Authorization, Pokemon pokemon) {
        return null;
    }

    @DeleteMapping("/deletePokemon")
    public Pokemon deletePokemon(String Authorization, int id) {
        return null;
    }

    @PutMapping("/updatePokemon")
    public Pokemon updatePokemon(String Authorization, int id){
        return null;
    }
}
