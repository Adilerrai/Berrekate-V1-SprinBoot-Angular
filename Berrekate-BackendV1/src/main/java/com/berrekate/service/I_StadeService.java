package com.berrekate.service;


import org.springframework.stereotype.Service;
import com.berrekate.dto.StadeDTO;

import java.util.List;

@Service
public interface I_StadeService {
   StadeDTO getStadeById(Long id);
    StadeDTO getStadeByName(String name);
    StadeDTO addStade(StadeDTO stadeDTO);
    List<StadeDTO> getAllStades();
    List<StadeDTO> getAllStadesByVille(String ville);
    boolean deleteStade(Long id);
    StadeDTO updateStade(StadeDTO stadeDTO);


}
