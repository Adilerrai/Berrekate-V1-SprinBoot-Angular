package com.berrekate.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Blob image;

}
