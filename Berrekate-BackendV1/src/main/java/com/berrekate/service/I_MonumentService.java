package com.berrekate.service;

import com.berrekate.dto.MonumentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface I_MonumentService {
    MonumentDTO getMonumentById(Long id );
    MonumentDTO createMonument (MonumentDTO monumentDTO);
    MonumentDTO updateMonument (MonumentDTO monumentDTO);

    MonumentDTO getMonumentByVille(String ville);

    List<MonumentDTO> getAllMonuments();

}
