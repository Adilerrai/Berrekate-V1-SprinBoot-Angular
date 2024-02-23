package com.berrekate.service;

import com.berrekate.dto.RestaurantDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRestaurantService {
    RestaurantDTO getRestaurantById(Long id);
    RestaurantDTO getRestaurantByName(String name);
    RestaurantDTO getRestaurantByVille(String ville);
    List<RestaurantDTO> getAllRestaurants();
    RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO);
    List<RestaurantDTO> getAllRestaurantsByVille(String ville);

    boolean deleteRestaurant(Long id);

    RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO);


}
