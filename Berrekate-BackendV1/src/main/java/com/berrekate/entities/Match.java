package com.berrekate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMatch;
    private Date dateMatch;
    private String heureMatch;
    @ManyToOne
    private Stade stadeMatch;
    @ManyToMany
    private List<Pays> pays;
    @ManyToOne
    private Ville ville;
}