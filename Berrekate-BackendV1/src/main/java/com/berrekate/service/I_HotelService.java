package com.berrekate.service;

import com.berrekate.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface I_HotelService {
    List<HotelDTO> getAllHotels();
    HotelDTO getHotelById(int id);
    HotelDTO addHotel(HotelDTO hotel);
    void updateHotel(HotelDTO hotel, int id);
    void deleteHotel(int id);
    List<HotelDTO> getHotelsByVille(String ville);
}
