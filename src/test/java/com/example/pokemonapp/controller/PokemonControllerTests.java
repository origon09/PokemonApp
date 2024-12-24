package com.example.pokemonapp.controller;

import java.util.*;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.PokemonObject;
import com.example.pokemonapp.repository.PokemonRepository;
import com.example.pokemonapp.service.PokemonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class PokemonControllerTests {

    @Autowired
    PokemonController pokemonController;

    @Mock
    PokemonService pokemonService;
    @Mock
    PokemonRepository pokemonRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        initMocks(this);

    }

    @Test
    void getAllPokemon() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pokemon/pokedex"))
                .andExpect(status().isOk());
    }
//    @Test
//    void addPokemonTest() throws Exception{
//
//        Pokemon pokemon = Pokemon.builder().attack(21).defense(21).health(21).name("TURTLE-MAN").type("T").build();
//        String authorization="p";
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/pokemon/addPokemon")
//                        .header("Authorization", authorization))
//                .andExpect(status().isOk());
//    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}