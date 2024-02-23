package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.StadeRepository;
import com.berrekate.dto.StadeDTO;
import com.berrekate.entities.Stade;
import com.berrekate.service.IStadeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StadeServiceImpl implements IStadeService {

    private final StadeRepository stadeRepository;
    private final ModelMapper modelMapper;

    public StadeServiceImpl(StadeRepository stadeRepository, ModelMapper modelMapper) {
        this.stadeRepository = stadeRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public StadeDTO getStadeById(long id) {
        Stade stade = stadeRepository.findById(id).get();
        return modelMapper.map(stade, StadeDTO.class);
    }

    @Override
    public StadeDTO getStadeByName(String name) {
        Stade stade = stadeRepository.getStadeByNomStade(name);
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
                .toList();
    }

    @Override
    public StadeDTO getAllStadeByVille(String ville) {
        Stade stade = stadeRepository.getStadeByVilleNomVille(ville);
        return modelMapper.map(stade, StadeDTO.class);
    }

    @Override
    public boolean deleteStade(long id) {
         return stadeRepository.deleteByIdStade(id);

    }

    @Override
    public StadeDTO updateStade(StadeDTO stadeDTO) {
        Stade stade = stadeRepository.findById(stadeDTO.getIdStade()).orElse(null);
        if (stade != null) {
            stade.setNomStade(stadeDTO.getNomStade());
            stade.setAddressStade(stadeDTO.getAddressStade());
            stade.setDescription(stadeDTO.getDescription());
            stade.setCapacityStade(stadeDTO.getCapacityStade());
            stade.setVille(stadeDTO.getVille());
            stade = stadeRepository.save(stade);
        }
        return modelMapper.map(stade, StadeDTO.class);
    }
}
