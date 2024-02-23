package com.berrekate.entities;

import com.berrekate.enums.Sexe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Benevole extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBenevole;
    private String langue1;
    private String langue2;
    private String langue3;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String cin;
    @OneToOne
    private Ville ville;
}
