package com.berrekate.berrekate_repository;

import com.berrekate.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
    Ville getVilleByNomVille(String name);
    boolean deleteByNomVille(String name);

}
