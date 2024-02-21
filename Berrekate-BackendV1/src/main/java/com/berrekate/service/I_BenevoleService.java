package com.berrekate.service;

import com.berrekate.dto.BenevoleDTO;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface I_BenevoleService  {
    List<BenevoleDTO> getAllBenevole();
    BenevoleDTO getBenevoleById(Long id);
    BenevoleDTO getBenevoleByLangue(String langue);
    BenevoleDTO addBenevole(BenevoleDTO benevoleDTO);
    BenevoleDTO updateBenevole(BenevoleDTO benevoleDTO);
    void deleteBenevole(Long id);




}
