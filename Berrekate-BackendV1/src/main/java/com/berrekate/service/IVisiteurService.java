package com.berrekate.service;

import com.berrekate.dto.VisiteurDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVisiteurService {

    VisiteurDTO saveVisiteur(VisiteurDTO visiteur);
    VisiteurDTO updateVisiteur(VisiteurDTO visiteur);
    Boolean deleteVisiteur(long id);
    VisiteurDTO getVisiteur(Long id);

    List<VisiteurDTO> getVisiteursByPays(String pays);
    List<VisiteurDTO> getVisiteurs();


}
