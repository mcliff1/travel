package com.cliffconsulting.travel.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.model.Hotel;

@Service
public class HotelService { 

    @Autowired 
    HotelRepository repo;

    public Hotel getHotelById(long hotelId) {
        com.cliffconsulting.travel.entity.Hotel hotelDO = repo.findOne(hotelId);
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }

    public Hotel addHotel(Hotel hotel) {
        com.cliffconsulting.travel.entity.Hotel hotelDO = new com.cliffconsulting.travel.entity.Hotel();
        BeanUtils.copyProperties(hotel, hotelDO);
        hotelDO = repo.save(hotelDO);
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }


    public void updateHotel(Hotel hotel) {
        com.cliffconsulting.travel.entity.Hotel hotelDO = new com.cliffconsulting.travel.entity.Hotel();
        BeanUtils.copyProperties(hotel, hotelDO);
        repo.save(hotelDO);
    }

    public void deleteHotel(long hotelId) {
        repo.delete(hotelId);
    }

}
