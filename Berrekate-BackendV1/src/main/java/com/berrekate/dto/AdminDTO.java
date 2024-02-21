package com.berrekate.dto;

import com.berrekate.entities.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO extends Personne {
    private int idAdmin;
    private String language;
    private String sexe;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
}
