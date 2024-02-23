package com.berrekate.service;

import com.berrekate.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface IHotelService {
    List<HotelDTO> getAllHotels();
    HotelDTO getHotelById(long id);
    HotelDTO addHotel(HotelDTO hotel);
    void updateHotel(HotelDTO hotel, long id);
    void deleteHotel(long id);
    List<HotelDTO> getHotelsByVille(String ville);
}
