package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.RestaurantRepository;
import com.berrekate.dto.RestaurantDTO;
import com.berrekate.entities.Restaurant;
import com.berrekate.service.I_RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements I_RestaurantService {

    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ModelMapper modelMapper) {
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.getOne(id);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    @Override
    public RestaurantDTO getRestaurantByName(String nom) {
        Restaurant restaurant = restaurantRepository.getRestaurantByNom(nom);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    @Override
    public RestaurantDTO getRestaurantByVille(String ville) {
        Restaurant restaurant = restaurantRepository.getRestaurantByVille(ville);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteRestaurant(Long id) {
        return restaurantRepository.deleteByIdRestaurant(id);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantDTO.getIdRestaurant()).orElse(null);
        if (restaurant != null) {
            restaurant.setNom(restaurantDTO.getNom());
            restaurant.setVille(restaurantDTO.getVille());
            restaurant.setDescription(restaurantDTO.getDescription());
            restaurant.setTele(restaurantDTO.getTele());
            restaurant.setEmail(restaurantDTO.getEmail());
            restaurant = restaurantRepository.save(restaurant);
        }
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    @Override
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = modelMapper.map(restaurantDTO, Restaurant.class);
        restaurant = restaurantRepository.save(restaurant);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    @Override
    public List<RestaurantDTO> getAllRestaurantsByVille(String ville){
        List<Restaurant> restaurants = restaurantRepository.getRestaurantsByVille(ville);
        return restaurants.stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class))
                .collect(Collectors.toList());
    }
}
