package com.example.pokemonapp.controller;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.PokemonObject;
import com.example.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public void addPokemon(String Authorization, @RequestBody Pokemon pokemon) {
        pokemonService.addPokemon(pokemon);
    }

    @DeleteMapping("/deletePokemon")
    public void deletePokemon(String Authorization, long id) {
        pokemonService.deletePokemon(id);
    }

    @PutMapping("/updatePokemon")
    public Pokemon updatePokemon(String Authorization, long id, @RequestBody Pokemon pokemon) {
        pokemonService.updatePokemon(id, pokemon);
        return pokemon;
    }

    @GetMapping("/find/{pokemonName}")
    public PokemonObject findPokemon(String Authorization, @PathVariable String pokemonName){
        System.out.println("This is the pokmeon being passed in for search: " + pokemonName);
        return pokemonService.findPokemon(pokemonName);
    }

}
