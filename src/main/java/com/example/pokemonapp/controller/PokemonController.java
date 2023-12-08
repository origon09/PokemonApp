package com.example.pokemonapp.controller;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin
public class PokemonController {

    private PokemonService pokemonService;

    @GetMapping
    public String home (){
        return "Welcome to the Pokedex";
    }

    @GetMapping("/Pokedex")
    public HashMap<Pokemon, String> getAllPokemon(String Authorization) {
        return null;
    }

    @PostMapping("/addPokemon")
    public Pokemon addPokemon(String Authorization, @RequestBody Pokemon pokemon) {
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
