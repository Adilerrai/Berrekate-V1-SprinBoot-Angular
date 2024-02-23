package com.berrekate.dto;

import com.berrekate.entities.Personne;
import com.berrekate.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BenevoleDTO {
    private int idBenevole;
    private String langue1;
    private String langue2;
    private String langue3;
    private Sexe sexe;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;


}