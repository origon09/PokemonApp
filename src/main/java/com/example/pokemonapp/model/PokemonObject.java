package com.example.pokemonapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PokemonObject {
    private int id;
    private String name;
    private String base_experience;
    private int height;

    private boolean is_default;
    private int order;
    private int weight;
    private List<PokemonAbility> pokemonAbilityList;
    private String location_area_encounters;
    private List<PokemonMove> pokemonMoveList;
    private Sprites sprites;



    public PokemonObject(String name, String base_experience, int height, boolean is_default, int order, int weight, List<PokemonAbility> pokemonAbilityList, String location_area_encounters, List<PokemonMove> pokemonMoveList) {
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.is_default = is_default;
        this.order = order;
        this.weight = weight;
        this.pokemonAbilityList = pokemonAbilityList;
        this.location_area_encounters = location_area_encounters;
        this.pokemonMoveList = pokemonMoveList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonAbility> getPokemonAbilityList() {
        return pokemonAbilityList;
    }

    public void setPokemonAbilityList(List<PokemonAbility> pokemonAbilityList) {
        this.pokemonAbilityList = pokemonAbilityList;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public List<PokemonMove> getPokemonMoveList() {
        return pokemonMoveList;
    }

    public void setPokemonMoveList(List<PokemonMove> pokemonMoveList) {
        this.pokemonMoveList = pokemonMoveList;
    }
}
