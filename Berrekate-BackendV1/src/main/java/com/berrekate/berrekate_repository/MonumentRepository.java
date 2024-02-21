package com.berrekate.berrekate_repository;

import com.berrekate.entities.Monument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentRepository extends JpaRepository<Monument, Long> {

    Monument getMonumentsByVille(String ville);
}
