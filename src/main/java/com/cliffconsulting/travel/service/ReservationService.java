package com.cliffconsulting.travel.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.entity.ReservationGuestRepository;
import com.cliffconsulting.travel.entity.ReservationRepository;
import com.cliffconsulting.travel.model.Reservation;

@Service
public class ReservationService { 

    @Autowired 
    ReservationRepository repo;

    @Autowired 
    ReservationGuestRepository guestRepo;

    public boolean exists(long reservationId) {
        return repo.existsById(reservationId);
    }

    public Reservation getReservationById(long reservationId) {
        com.cliffconsulting.travel.entity.Reservation reservationDO = repo.findById(reservationId).orElse(null);
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDO, reservation);
        
        
        
        return reservation;
    }

    /**
     * Packs the guests as well
     * @param reservation
     * @return
     */
    public Reservation addReservation(Reservation reservation) {
    	
    	
        com.cliffconsulting.travel.entity.Reservation reservationDO = new com.cliffconsulting.travel.entity.Reservation();
        BeanUtils.copyProperties(reservation, reservationDO);
        reservationDO = repo.save(reservationDO);
        BeanUtils.copyProperties(reservationDO, reservation);
        return reservation;
    }


    public void updateReservation(Reservation reservation) {
        com.cliffconsulting.travel.entity.Reservation reservationDO = new com.cliffconsulting.travel.entity.Reservation();
        BeanUtils.copyProperties(reservation, reservationDO);
        repo.save(reservationDO);
    }

    public void deleteReservation(long reservationId) {
        repo.deleteById(reservationId);
    }

}
