package com.example.pokemonapp.repository;

import com.example.pokemonapp.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    //SELECT * FROM pokemon WHERE name = ?
    @Query("SELECT p FROM Pokemon p WHERE p.name = ?1")
    Optional<Pokemon> findPokemonByName(String name);
}
