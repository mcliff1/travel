package com.cliffconsulting.travel.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.api.ApiException;
import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.model.Hotel;

@Service
public class HotelService { 

    private static final Logger log = LoggerFactory.getLogger(HotelService.class);

	
    @Autowired 
    HotelRepository repo;

    public boolean exists(long hotelId) {
        return repo.existsById(hotelId);
    }

    public Hotel getHotelById(long hotelId) {
        com.cliffconsulting.travel.entity.bean.Hotel hotelDO = repo.findById(hotelId).orElse(null);
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }

    public Hotel addHotel(Hotel hotel) {
        final String METHOD = "addHotel():";
        log.debug(METHOD + hotel);
        com.cliffconsulting.travel.entity.bean.Hotel hotelDO = new com.cliffconsulting.travel.entity.bean.Hotel();
        BeanUtils.copyProperties(hotel, hotelDO);
        hotelDO = repo.save(hotelDO);
        BeanUtils.copyProperties(hotelDO, hotel);
        return hotel;
    }


    public void updateHotel(Hotel hotel) throws ApiException {
    	final String METHOD = "updateHotel():";
    	log.info(METHOD + hotel);
    	try {
    		if (hotel.getHotelId() == null) { throw new ApiException(400, "null id"); }
    		log.info("calling repo on:" + hotel.getHotelId());
    		if (!repo.existsById(hotel.getHotelId())) { throw new ApiException(404, "hotel not found"); }
    		
    		com.cliffconsulting.travel.entity.bean.Hotel hotelDO = new com.cliffconsulting.travel.entity.bean.Hotel();
    		BeanUtils.copyProperties(hotel, hotelDO);
    		repo.save(hotelDO);
    	} catch (Exception e) {
    		if (e instanceof ApiException) { throw e; }
    		else throw new ApiException(405, e.getMessage());
    	}
    }

    public boolean deleteHotel(long hotelId) {
        if (!repo.existsById(hotelId)) return false;
        repo.deleteById(hotelId);
        return true;
    }

}
