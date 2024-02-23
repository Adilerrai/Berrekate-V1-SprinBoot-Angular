package com.berrekate.dto;

import com.berrekate.entities.Match;
import com.berrekate.entities.Ville;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadeDTO  {

    private Long idStade;
    private String nomStade;
    private String addressStade;
    private String description;
    private String capacityStade;

    private List<Match> matches;

    private Ville ville;


}
