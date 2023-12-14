package com.example.pokemonapp.controller;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public String home (){
        return "Welcome to the Pokedex";
    }

    @GetMapping("/pokedex")
    public List<Pokemon> getAllPokemon(String Authorization) {
        return pokemonService.getAllPokemons();
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
