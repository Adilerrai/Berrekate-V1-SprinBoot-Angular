package com.berrekate.berrekate_repository;

import com.berrekate.entities.Benevole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BenevoleRepository extends JpaRepository<Benevole, Long> {
    @Query("SELECT b FROM Benevole b WHERE b.langue1 = :langue OR b.langue2 = :langue OR b.langue3 = :langue")
    Benevole findByLangue1OrLangue2OrLangue3(@Param("langue") String langue);
}