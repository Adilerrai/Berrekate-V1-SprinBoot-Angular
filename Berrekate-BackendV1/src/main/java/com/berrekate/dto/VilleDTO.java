package com.berrekate.dto;

import com.berrekate.entities.*;
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
    private String nomVille;
    private String codePostal;
    private String description;
    private List<Restaurant> restaurants;
    private List<Stade> stades;
    private List<Hotel> hotels;
    private List<Monument> monuments;
    private List<Match> matches;

}
