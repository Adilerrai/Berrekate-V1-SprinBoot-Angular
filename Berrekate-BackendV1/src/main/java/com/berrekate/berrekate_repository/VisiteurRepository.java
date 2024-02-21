package com.berrekate.berrekate_repository;

import com.berrekate.entities.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    List<Visiteur> getVisiteurByPays(String pays);
    Boolean deleteById(long id);



}

