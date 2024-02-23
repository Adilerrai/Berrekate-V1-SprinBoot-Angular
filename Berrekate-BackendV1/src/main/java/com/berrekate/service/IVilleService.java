package com.berrekate.service;


import com.berrekate.dto.VilleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVilleService  {
     VilleDTO getVilleById(Long id);
     VilleDTO getVilleByName(String name);

     List<VilleDTO> getAllVilles();

     boolean deleteVille(String name);

     VilleDTO addVille(VilleDTO villeDTO);

     VilleDTO updateVille(VilleDTO villeDTO);



}
