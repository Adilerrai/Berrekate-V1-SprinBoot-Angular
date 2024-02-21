package com.berrekate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVille;
    private String nom;
    private String codePostal;
    private long langitude;
    private long latitude;

    private String description;

    @OneToMany(mappedBy = "ville", fetch = FetchType.EAGER)
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "ville" , fetch = FetchType.EAGER)
    private List<Stade> stades;

    @OneToMany(mappedBy = "ville" , fetch = FetchType.EAGER)
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "ville" , fetch = FetchType.EAGER)
    private List<Monument> monuments;

}
