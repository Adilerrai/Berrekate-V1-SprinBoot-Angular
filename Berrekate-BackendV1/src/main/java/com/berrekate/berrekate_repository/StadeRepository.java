package com.berrekate.berrekate_repository;

import com.berrekate.entities.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

    List<Stade> getStadesByVille(String ville);

    Stade getStadeByNom(String name);
    boolean deleteByIdStade(Long id);
}
