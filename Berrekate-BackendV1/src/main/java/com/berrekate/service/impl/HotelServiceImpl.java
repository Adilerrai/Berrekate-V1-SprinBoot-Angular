package com.berrekate.service.impl;

import com.berrekate.dto.HotelDTO;
import com.berrekate.entities.Hotel;
import com.berrekate.berrekate_repository.HotelRepository;
import com.berrekate.service.IHotelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//Implementation des services de l'Hotel class avec l'utilisation du DTO mapping
@Service
public class HotelServiceImpl implements IHotelService {

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
                .toList();
    }


    @Override
    public HotelDTO getHotelById(long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return modelMapper.map(hotel, HotelDTO.class);

    }

    @Override
    public HotelDTO addHotel(HotelDTO hotel) {
        return modelMapper.map(hotelRepository.save(modelMapper.map(hotel, Hotel.class)), HotelDTO.class);
    }

    @Override
    public void updateHotel(HotelDTO hotel, long id) {
        Hotel hotel1 = hotelRepository.findById(id).orElse(null);
        if (hotel1 != null) {
            hotel1.setNomHotel(hotel.getNomHotel());
            hotel1.setAddressHotel(hotel.getAddressHotel());
            hotel1.setVille(hotel.getVille());
            hotel1.setDescription(hotel.getDescription());
            hotel1.setTeleHotel(hotel.getTeleHotel());
            hotel1.setStartHotel(hotel.getStartHotel());
            hotel1.setStartHotel(hotel.getStartHotel());
        }
    }


    @Override
    public void deleteHotel(long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelDTO> getHotelsByVille(String ville) {
        List<Hotel> hotels = hotelRepository.findByVille(ville);
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class)).toList();

    }


}
