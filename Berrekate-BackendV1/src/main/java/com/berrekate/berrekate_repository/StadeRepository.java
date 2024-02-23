package com.berrekate.berrekate_repository;

import com.berrekate.entities.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

    boolean deleteByIdStade(Long id);
    Stade getStadeByNomStade(String nomStade);
    Stade getStadeByVilleNomVille(String nomVille);


}
