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
    private String langue;
    private Sexe sexe;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;


}