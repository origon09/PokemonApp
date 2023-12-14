package com.example.pokemonapp.service;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
