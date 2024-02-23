package com.berrekate.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    private String nomRestaurant;
    private String addresseRestaurant;
    private String description;
    private String teleRestaurant;
    private String emailRestaurant;
    @ManyToOne
    private Ville ville;
}
