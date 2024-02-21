package com.berrekate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStade;
    private String nom;
    private String address;
    private String description;
    private String latitude;
    private String longitude;

    @ManyToOne
    private Ville ville;
}