package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.StadeRepository;
import com.berrekate.dto.StadeDTO;
import com.berrekate.entities.Stade;
import com.berrekate.service.I_StadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StadeServiceImpl implements I_StadeService {

    private final StadeRepository stadeRepository;
    private final ModelMapper modelMapper;

    public StadeServiceImpl(StadeRepository stadeRepository, ModelMapper modelMapper) {
        this.stadeRepository = stadeRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public StadeDTO getStadeById(Long id) {
        Stade stade = stadeRepository.findById(id).get();
        return modelMapper.map(stade, StadeDTO.class);
    }

    @Override
    public StadeDTO getStadeByName(String name) {
        Stade stade = stadeRepository.getStadeByNom(name);
        return modelMapper.map(stade, StadeDTO.class);
    }



    @Override
    public StadeDTO addStade(StadeDTO stadeDTO) {
        Stade stade = modelMapper.map(stadeDTO, Stade.class);
        stade = stadeRepository.save(stade);
        return modelMapper.map(stade, StadeDTO.class);
    }

    @Override
    public List<StadeDTO> getAllStades() {
        List<Stade> stades = stadeRepository.findAll();
        return stades.stream()
                .map(stade -> modelMapper.map(stade, StadeDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<StadeDTO> getAllStadesByVille(String ville) {
        List<Stade> stades = stadeRepository.getStadesByVille(ville);
        return stades.stream()
                .map(stade -> modelMapper.map(stade, StadeDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public boolean deleteStade(Long id) {
         return stadeRepository.deleteByIdStade(id);

    }

    @Override
    public StadeDTO updateStade(StadeDTO stadeDTO) {
        Stade stade = stadeRepository.findById(stadeDTO.getIdStade()).orElse(null);
        if (stade != null) {
            stade.setNom(stadeDTO.getNom());
            stade.setVille(stadeDTO.getVille());
            stade.setDescription(stadeDTO.getDescription());
            stade.setLongitude(stadeDTO.getLongitude());
            stade.setLatitude(stadeDTO.getLatitude());
            stade.setAddress(stadeDTO.getAddress());
            stade = stadeRepository.save(stade);

        }
        return modelMapper.map(stade, StadeDTO.class);
    }
}
