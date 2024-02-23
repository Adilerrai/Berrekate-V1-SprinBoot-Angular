package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.VilleRepository;
import com.berrekate.dto.VilleDTO;
import com.berrekate.entities.Ville;
import com.berrekate.service.IVilleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements IVilleService {
    private final VilleRepository villeRepository;
    private final ModelMapper modelMapper;

    public VilleServiceImpl(VilleRepository villeRepository, ModelMapper modelMapper) {
        this.villeRepository = villeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VilleDTO getVilleById(Long id) {
        Ville ville = villeRepository.findById(id).orElse(null);
        return modelMapper.map(ville, VilleDTO.class);
    }

    @Override
    public VilleDTO getVilleByName(String name) {
        Ville ville = villeRepository.getVilleByNomVille(name);
        return modelMapper.map(ville, VilleDTO.class);
    }

    @Override
    public List<VilleDTO> getAllVilles() {
        List<Ville> villes = villeRepository.findAll();
        return villes.stream()
                .map(ville -> modelMapper.map(ville, VilleDTO.class))
                .toList();
    }


    @Override
    public boolean deleteVille(String name) {
        return villeRepository.deleteByNomVille(name);
    }

    @Override
    public VilleDTO addVille(VilleDTO villeDTO) {
        Ville ville = modelMapper.map(villeDTO, Ville.class);
        ville = villeRepository.save(ville);
        return modelMapper.map(ville, VilleDTO.class);
    }

    @Override
    public VilleDTO updateVille(VilleDTO villeDTO) {
        Ville ville = villeRepository.findById(villeDTO.getIdVille()).orElse(null);
        if (ville != null) {
            ville.setNomVille(villeDTO.getNomVille());
            ville.setHotels(villeDTO.getHotels());
            ville.setMonuments(villeDTO.getMonuments());
            ville.setRestaurants(villeDTO.getRestaurants());
            ville.setCodePostal(villeDTO.getCodePostal());
            ville.setStades(villeDTO.getStades());
            ville.setMonuments(villeDTO.getMonuments());
            ville = villeRepository.save(ville);
        }
        return modelMapper.map(ville, VilleDTO.class);
    }
}
