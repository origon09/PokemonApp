package com.example.pokemonapp.service;

import com.example.pokemonapp.model.MoveObject;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.PokemonObject;
import com.example.pokemonapp.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService{


    @Autowired
    private RestTemplate restTemplate;
    private final PokemonRepository pokemonRepository;
    private final String POKEMON_BASE_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final String POKEMON_MOVE_URL = "https://pokeapi.co/api/v2/move/";



    @Autowired
    public PokemonService( PokemonRepository pokemonRepository) {
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

    public void deletePokemon(long id) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if(pokemonOptional.isEmpty()) {
            throw new IllegalStateException("Pokemon with id " + id + " does not exist");
        }
        pokemonRepository.deleteById(id);
    }

    public void updatePokemon(long id, Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if(pokemonOptional.isEmpty()) {
            throw new IllegalStateException("Pokemon with id " + id + " does not exist");
        }
        pokemonRepository.findById(id)
                .map(pokemon1 -> {
                    pokemon1.setName(pokemon.getName());
                    pokemon1.setType(pokemon.getType());
                    pokemon1.setAttack(pokemon.getAttack());
                    pokemon1.setDefense(pokemon.getDefense());
                    pokemon1.setHealth(pokemon.getHealth());
                    return pokemonRepository.save(pokemon1);
                });
    }

    public PokemonObject findPokemon(String pokemonName) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String final_URL = UriComponentsBuilder.fromHttpUrl(POKEMON_BASE_URL)
                .path(pokemonName)
                .toUriString();

        System.out.println(final_URL);
        ResponseEntity<PokemonObject> response = restTemplate.exchange(
                final_URL,
                HttpMethod.GET,
                entity,
                PokemonObject.class
        );

        PokemonObject jose = PokemonObject.builder().name("Jose").order(1).id(1).build();
        System.out.println(jose);
        return response.getBody();
    }

    public MoveObject movesPokemon(int pokemonName) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String final_URL = UriComponentsBuilder.fromHttpUrl(POKEMON_MOVE_URL)
                .path(String.valueOf(pokemonName))
                .toUriString();

        System.out.println(final_URL);
        ResponseEntity<MoveObject> response = restTemplate.exchange(
                final_URL,
                HttpMethod.GET,
                entity,
                MoveObject.class
        );

        PokemonObject jose = PokemonObject.builder().name("Jose").order(1).id(1).build();
        System.out.println(jose);
        return response.getBody();
    }
}
