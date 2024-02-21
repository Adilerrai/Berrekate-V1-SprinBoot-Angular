package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.VisiteurRepository;
import com.berrekate.dto.VisiteurDTO;
import com.berrekate.entities.Visiteur;
import com.berrekate.service.I_VisiteurService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisiteurServiceImpl implements I_VisiteurService {


    private VisiteurRepository visiteurRepository;

    private ModelMapper modelMapper;

    public VisiteurServiceImpl(VisiteurRepository visiteurRepository, ModelMapper modelMapper) {
        this.visiteurRepository = visiteurRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VisiteurDTO saveVisiteur(VisiteurDTO visiteur) {
        Visiteur visiteurEntity = modelMapper.map(visiteur, Visiteur.class);
        visiteurEntity = visiteurRepository.save(visiteurEntity);
        return modelMapper.map(visiteurEntity, VisiteurDTO.class);
    }

    @Override
    public VisiteurDTO updateVisiteur(VisiteurDTO visiteur) {
        Visiteur visiteurEntity = modelMapper.map(visiteur, Visiteur.class);
        visiteurEntity = visiteurRepository.save(visiteurEntity);
        return modelMapper.map(visiteurEntity, VisiteurDTO.class);
    }

    @Override
    public Boolean deleteVisiteur(long id) {
        return visiteurRepository.deleteById(id);
    }

    @Override
    public VisiteurDTO getVisiteur(Long id) {
        Visiteur visiteurEntity = visiteurRepository.getOne(id);
        return modelMapper.map(visiteurEntity, VisiteurDTO.class);
    }



    @Override
    public List<VisiteurDTO> getVisiteursByPays(String pays) {
        List<Visiteur> visiteurEntity = visiteurRepository.getVisiteurByPays(pays);
        return visiteurEntity.stream().map(visiteur -> modelMapper.map(visiteur, VisiteurDTO.class)).toList();

    }

    @Override
    public List<VisiteurDTO> getVisiteurs() {
        List<Visiteur> visiteurEntity = visiteurRepository.findAll();
        return visiteurEntity.stream().map(visiteur -> modelMapper.map(visiteur, VisiteurDTO.class)).toList();
    }
}
