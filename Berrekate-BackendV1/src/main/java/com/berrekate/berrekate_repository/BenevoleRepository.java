package com.berrekate.berrekate_repository;

import com.berrekate.entities.Benevole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenevoleRepository extends JpaRepository<Benevole, Long> {
    Benevole findByLangue(String langue);
}
