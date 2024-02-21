package com.berrekate.dto;

import com.berrekate.entities.Personne;
import com.berrekate.entities.Ville;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    private Long idRestaurant;
    private String nom ;
    private String addresse;
    private String description;
    private String tele;
    private String email;
    private Ville ville;

}
