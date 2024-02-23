package com.berrekate.dto;

import com.berrekate.entities.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    private Long idRestaurant;
    private String nomRestaurant;
    private String addresseRestaurant;
    private String description;
    private String teleRestaurant;
    private String emailRestaurant;
    private Ville ville;

}
