package com.berrekate.berrekate_repository;

import com.berrekate.entities.Monument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentRepository extends JpaRepository<Monument, Long> {
    @Query("SELECT m FROM Monument m WHERE m.ville.nomVille = :ville")
    Monument getMonumentsByVille(@Param("ville") String ville);
}