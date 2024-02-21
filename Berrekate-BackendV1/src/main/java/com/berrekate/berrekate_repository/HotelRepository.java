package com.berrekate.berrekate_repository;

import com.berrekate.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    List<Hotel> findByVille(String ville);
}
