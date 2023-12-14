package com.example.pokemonapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Pokemon {

    public Pokemon(String name, String type, int attack, int defense, int health) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    @Id
    @SequenceGenerator(
            name = "pokemon_sequence",
            sequenceName = "pokemon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pokemon_sequence"
    )
    private Long id;
    private String name;
    private String type;
    private int attack;
    private int defense;
    private int health;


}
