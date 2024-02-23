package com.berrekate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomHotel;
    private String addressHotel;
    private String description;
    private String teleHotel;
    private int startHotel;
    private String emailHotel;
    @ManyToOne
    private Ville ville;
}