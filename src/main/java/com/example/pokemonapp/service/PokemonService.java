package com.example.pokemonapp.service;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService{


    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }


    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public void addPokemon(Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findPokemonByName(pokemon.getName());
        if (pokemonOptional.isPresent()) {
            throw new IllegalStateException("Pokemon already exists");
        }
        pokemonRepository.save(pokemon);
    }
}
