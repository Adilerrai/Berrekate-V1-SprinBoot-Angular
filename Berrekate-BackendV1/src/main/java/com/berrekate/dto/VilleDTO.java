package com.berrekate.dto;

import com.berrekate.entities.Hotel;
import com.berrekate.entities.Monument;
import com.berrekate.entities.Restaurant;
import com.berrekate.entities.Stade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VilleDTO {

    private Long idVille;
    private String nom;
    private String codePostal;
    private long langitude;
    private long latitude;

    private String description;

    private List<Restaurant> restaurants;

    private List<Stade> stades;

    private List<Hotel> hotels;

    private List<Monument> monuments;

}
