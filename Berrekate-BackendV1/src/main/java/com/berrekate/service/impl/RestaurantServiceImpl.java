package com.berrekate.service.impl;

import com.berrekate.berrekate_repository.RestaurantRepository;
import com.berrekate.dto.RestaurantDTO;
import com.berrekate.entities.Restaurant;
import com.berrekate.service.IRestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

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
        Restaurant restaurant = restaurantRepository.getRestaurantByNomRestaurant(nom);
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
                .toList();
    }

    @Override
    public boolean deleteRestaurant(Long id) {
        return restaurantRepository.deleteByIdRestaurant(id);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantDTO.getIdRestaurant()).orElse(null);
        if (restaurant != null) {
            restaurant.setNomRestaurant(restaurantDTO.getNomRestaurant());
            restaurant.setAddresseRestaurant(restaurantDTO.getAddresseRestaurant());
            restaurant.setDescription(restaurantDTO.getDescription());
            restaurant.setTeleRestaurant(restaurantDTO.getTeleRestaurant());
            restaurant.setEmailRestaurant(restaurantDTO.getEmailRestaurant());
            restaurant.setVille(restaurantDTO.getVille());
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
                .toList();
    }
}
