package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.MonumentRepository;
import com.berrekate.dto.MonumentDTO;
import com.berrekate.entities.Monument;
import com.berrekate.service.IMonumentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MonumentServiceImpl implements IMonumentService {


    private final MonumentRepository monumentRepository;
    private final ModelMapper modelMapper;

    public MonumentServiceImpl(MonumentRepository monumentRepository, ModelMapper modelMapper) {
        this.monumentRepository = monumentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MonumentDTO getMonumentByVille(String ville){
        Monument monument = monumentRepository.getMonumentsByVille(ville);
        return modelMapper.map(monument, MonumentDTO.class);
    }

    @Override
    public List<MonumentDTO> getAllMonuments() {
        List<Monument> monuments = monumentRepository.findAll();
        return monuments.stream()
                .map(monument -> modelMapper.map(monument, MonumentDTO.class))
                .toList();
    }
    @Override
    public MonumentDTO getMonumentById(Long id) {
        Monument monument = monumentRepository.getOne(id);
        return modelMapper.map(monument, MonumentDTO.class);

    }
    @Override
    public MonumentDTO createMonument(MonumentDTO monumentDTO) {
        Monument monument = modelMapper.map(monumentDTO, Monument.class);
        monument = monumentRepository.save(monument);
        return modelMapper.map(monument, MonumentDTO.class);
    }

    @Override
    public MonumentDTO updateMonument(MonumentDTO monumentDTO) {

       Monument monument = monumentRepository.findById(monumentDTO.getIdMonument()).orElse(null);
        if (monument != null) {
            monument.setNomMonument(monumentDTO.getNom());
            monument.setDescription(monumentDTO.getDescription());
            monument.setVille(monumentDTO.getVille());
        }
        return modelMapper.map(monument, MonumentDTO.class);
    }


}
