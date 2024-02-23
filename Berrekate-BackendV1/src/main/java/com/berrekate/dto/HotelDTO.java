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
    private String nomHotel;
    private String addressHotel;
    private String teleHotel;
    private String email;
    private String description;
    private int startHotel;
    private Ville ville;
}
