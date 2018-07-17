package com.cliffconsulting.travel.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.model.Hotel;

@Service
public class HotelService { 

    @Autowired 
    HotelRepository repo;

    private static final Logger log = LoggerFactory.getLogger(HotelService.class);

    public boolean exists(long hotelId) {
        return repo.existsById(hotelId);
    }

    public Hotel getHotelById(long hotelId) {
        com.cliffconsulting.travel.entity.Hotel hotelDO = repo.findById(hotelId).orElse(null);
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }

    public Hotel addHotel(Hotel hotel) {
        final String METHOD = "addHotel():";
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

    public boolean deleteHotel(long hotelId) {
        if (!repo.existsById(hotelId)) return false;
        repo.deleteById(hotelId);
        return true;
    }

}
