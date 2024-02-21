package com.berrekate.dto;

import com.berrekate.entities.Personne;
import com.berrekate.entities.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonumentDTO   {
    private Long idMonument;
    private String nom;
    private String description;
    private String latitude;
    private String longitude;
    private Ville ville;

}
