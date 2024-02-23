package com.berrekate.service;


import org.springframework.stereotype.Service;
import com.berrekate.dto.StadeDTO;

import java.util.List;

@Service
public interface IStadeService {
   StadeDTO getStadeById(long id);
    StadeDTO getStadeByName(String name);
    StadeDTO addStade(StadeDTO stadeDTO);
    List<StadeDTO> getAllStades();

    StadeDTO getAllStadeByVille(String ville);

    boolean deleteStade(long id);
    StadeDTO updateStade(StadeDTO stadeDTO);


}
