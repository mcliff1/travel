package com.cliffconsulting.travel.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cliffconsulting.travel.entity.ReservationRepository;
import com.cliffconsulting.travel.model.Reservation;

@Service
public class ReservationService { 

    @Autowired 
    ReservationRepository repo;

    public Reservation getReservationById(long reservationId) {
        com.cliffconsulting.travel.entity.Reservation reservationDO = repo.findOne(reservationId);
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDO, reservation);
        return reservation;
    }

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
        repo.delete(reservationId);
    }

}
