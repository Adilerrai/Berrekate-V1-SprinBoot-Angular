package com.berrekate.service.impl;

import com.berrekate.entities.Benevole;
import com.berrekate.berrekate_repository.BenevoleRepository;
import com.berrekate.service.I_BenevoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.berrekate.dto.BenevoleDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BenevoleServiceImpl implements I_BenevoleService {

    private final BenevoleRepository benevoleRepository;
    private final ModelMapper modelMapper;
    public BenevoleServiceImpl(BenevoleRepository benevoleRepository, ModelMapper modelMapper) {
        this.benevoleRepository = benevoleRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<BenevoleDTO> getAllBenevole() {
        List<Benevole> benevoles = benevoleRepository.findAll();
        return  benevoles.stream()
                .map(benevole -> modelMapper.map(benevole, BenevoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BenevoleDTO getBenevoleById(Long id) {
        Benevole benevole = benevoleRepository.findById(id).orElse(null);
        return modelMapper.map(benevole, BenevoleDTO.class);
    }

    @Override
    public BenevoleDTO getBenevoleByLangue(String langue) {
        Benevole benevole = benevoleRepository.findByLangue(langue);
        return modelMapper.map(benevole, BenevoleDTO.class);
    }

    @Override
    public BenevoleDTO addBenevole(BenevoleDTO benevoleDTO) {
        return modelMapper.map(benevoleRepository.save(modelMapper.map(benevoleDTO, Benevole.class)), BenevoleDTO.class);
    }

    @Override
    public BenevoleDTO updateBenevole(BenevoleDTO benevoleDTO) {
        Benevole benevole = benevoleRepository.findById((long) benevoleDTO.getIdBenevole()).orElse(null);
        if (benevole != null) {
            benevole.setNom(benevoleDTO.getNom());
            benevole.setPrenom(benevoleDTO.getPrenom());
            benevole.setLangue(benevoleDTO.getLangue());
            benevole.setTelephone(benevoleDTO.getTelephone());
            benevole.setEmail(benevoleDTO.getEmail());

            return modelMapper.map(benevoleRepository.save(benevole), BenevoleDTO.class);
        }
        return null;
    }

    @Override
    public void deleteBenevole(Long id) {
        benevoleRepository.deleteById(id);
    }
}
