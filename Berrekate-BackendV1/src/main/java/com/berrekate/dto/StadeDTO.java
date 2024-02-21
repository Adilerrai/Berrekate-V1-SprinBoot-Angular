package com.berrekate.dto;

import com.berrekate.entities.Ville;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadeDTO  {

    private  Long idStade;
    private String nom;
    private String address;
    private String description;
    private String latitude;
    private String longitude;
    @OneToMany
    private Ville ville;


}
