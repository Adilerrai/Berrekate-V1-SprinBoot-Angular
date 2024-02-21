package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.VilleRepository;
import com.berrekate.dto.VilleDTO;
import com.berrekate.entities.Ville;
import com.berrekate.service.I_VilleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements I_VilleService {
    private VilleRepository villeRepository;
    private ModelMapper modelMapper;

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
        Ville ville = villeRepository.getVilleByNom(name);
        return modelMapper.map(ville, VilleDTO.class);
    }

    @Override
    public List<VilleDTO> getAllVilles() {
        List<Ville> villes = villeRepository.findAll();
        return villes.stream()
                .map(ville -> modelMapper.map(ville, VilleDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }


    @Override
    public boolean deleteVille(String name) {
        return villeRepository.deleteByName(name);
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
            ville.setNom(villeDTO.getNom());
            ville.setHotels(villeDTO.getHotels());
            ville.setMonuments(villeDTO.getMonuments());
            ville.setRestaurants(villeDTO.getRestaurants());
            ville.setCodePostal(villeDTO.getCodePostal());
            ville.setStades(villeDTO.getStades());
            ville.setLangitude(villeDTO.getLangitude());
            ville.setLatitude(villeDTO.getLatitude());
            ville.setMonuments(villeDTO.getMonuments());
            ville = villeRepository.save(ville);
        }
        return modelMapper.map(ville, VilleDTO.class);
    }
}
