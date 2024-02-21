package com.berrekate.dto;

import com.berrekate.entities.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO{
    private Long idHotel;
    private String nom;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String latitude;
    private String longitude;
    private Ville ville;
}
