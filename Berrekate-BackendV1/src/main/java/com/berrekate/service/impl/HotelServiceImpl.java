package com.berrekate.service.impl;

import com.berrekate.dto.HotelDTO;
import com.berrekate.entities.Hotel;
import com.berrekate.berrekate_repository.HotelRepository;
import com.berrekate.service.I_HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//Implementation des services de l'Hotel class avec l'utilisation du DTO mapping
@Service
public class HotelServiceImpl implements I_HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;


    public HotelServiceImpl(HotelRepository hotelRepository, ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();

        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO getHotelById(int id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return modelMapper.map(hotel, HotelDTO.class);

    }

    @Override
    public HotelDTO addHotel(HotelDTO hotel) {
        return modelMapper.map(hotelRepository.save(modelMapper.map(hotel, Hotel.class)), HotelDTO.class);
    }


    @Override
    public void updateHotel(HotelDTO hotel, int id) {
        Hotel hotel1 = hotelRepository.findById(id).orElse(null);
        if (hotel1 != null) {
            hotel1.setName(hotel.getNom());
            hotel1.setAddress(hotel.getAddress());
            hotel1.setTelephone(hotel.getPhone());
            hotel1.setEmail(hotel.getEmail());
            hotel1.setDescription(hotel.getDescription());
            modelMapper.map(hotelRepository.save(hotel1), HotelDTO.class);
        }
    }

    @Override
    public void deleteHotel(int id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelDTO> getHotelsByVille(String ville) {
        List<Hotel> hotels = hotelRepository.findByVille(ville);
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class)).collect(Collectors.toList());

    }


}
