package com.berrekate.berrekate_repository;

import com.berrekate.dto.RestaurantDTO;
import com.berrekate.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant getRestaurantByVille(String ville);
    List<Restaurant> getRestaurantsByVille (String ville);

    Restaurant getRestaurantByNom(String nom);
    boolean deleteByIdRestaurant(Long id);

}
