package com.berrekate.dto;

import com.berrekate.entities.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisiteurDTO extends Personne {

    private String pays;

}
