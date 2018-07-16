package com.cliffconsulting.travel.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.model.Hotel;

@Service
public class HotelService implements IHotelService {

    @Autowired 
    HotelRepository repo;

    @Override
    public Hotel getHotelById(long hotelId) {
        com.cliffconsulting.travel.entity.Hotel hotelDO = repo.findOne(hotelId);
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }
}
