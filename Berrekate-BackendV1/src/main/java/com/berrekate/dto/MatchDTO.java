package com.berrekate.dto;

import com.berrekate.entities.Pays;
import com.berrekate.entities.Stade;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO{

    private long idMatch;
    private Date dateMatch;
    private String heureMatch;
    @ManyToOne
    private Stade stadeMatch;
    @ManyToMany
    private List<Pays> pays;

}

