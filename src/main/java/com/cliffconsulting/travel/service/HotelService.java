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

    public Hotel existsById(long hotelId) {
        return repo.existsById(hotelId);
    }

    public Hotel getHotelById(long hotelId) {
        com.cliffconsulting.travel.entity.Hotel hotelDO = repo.findOne(hotelId);
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }

    public Hotel addHotel(Hotel hotel) {
        final String METHOD = "addHotel():";
        log.info(METHOD + "1:" + hotel);
        com.cliffconsulting.travel.entity.Hotel hotelDO = new com.cliffconsulting.travel.entity.Hotel();
        BeanUtils.copyProperties(hotel, hotelDO);
        log.info(METHOD + "2:" + hotelDO);
        hotelDO = repo.save(hotelDO);
        log.info(METHOD + "3:" + hotelDO);
        BeanUtils.copyProperties(hotelDO, hotel);
        log.info(METHOD + "4:" + hotel);
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
