package com.cliffconsulting.travel.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.entity.ReservationGuestRepository;
import com.cliffconsulting.travel.entity.ReservationRepository;
import com.cliffconsulting.travel.model.Reservation;
import com.cliffconsulting.travel.model.ReservationGuests;

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
        reservation.setRoomId(Long.toString(reservationDO.getRoomId()));
        reservation.setStartDate(getLocalDate(reservationDO.getStartDate()));
        reservation.setEndDate(getLocalDate(reservationDO.getEndDate()));
        List<ReservationGuests> guestList = new ArrayList<ReservationGuests>();
        List<com.cliffconsulting.travel.entity.ReservationGuest> guestsDO = guestRepo.findGuestsByReservationId(reservationId);
        guestsDO.stream()
        	.forEach(guestDO -> {
        		ReservationGuests guest = new ReservationGuests();
        		BeanUtils.copyProperties(guestDO,  guest);
        		guestList.add(guest);
        	});
        reservation.setGuests(guestList);
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

        reservationDO.setRoomId(Long.valueOf(reservation.getRoomId()));
        reservationDO.setStartDate(getSQLDate(reservation.getStartDate()));
        reservationDO.setEndDate(getSQLDate(reservation.getEndDate()));

        reservationDO = repo.save(reservationDO);
        BeanUtils.copyProperties(reservationDO, reservation);

        //List<com.cliffconsulting.travel.entity.ReservationGuest> guestsDO = guestRepo.findGuestsByReservationId(reservationId);
        List<ReservationGuests> guestList = new ArrayList<ReservationGuests>();
        reservation.getGuests().stream()
        	.forEach(guest -> {
        		com.cliffconsulting.travel.entity.ReservationGuest guestDO = new com.cliffconsulting.travel.entity.ReservationGuest();
        		//ReservationGuests guest = new ReservationGuests();
        		BeanUtils.copyProperties(guest,  guestDO);
        		guestDO = guestRepo.save(guestDO);
        		BeanUtils.copyProperties(guestDO, guest);
        		guestList.add(guest);
        	});
        reservation.setGuests(guestList);
        
        return reservation;
    }


    public void updateReservation(Reservation reservation) {
        com.cliffconsulting.travel.entity.Reservation reservationDO = new com.cliffconsulting.travel.entity.Reservation();
        BeanUtils.copyProperties(reservation, reservationDO);
        reservationDO.setRoomId(Long.valueOf(reservation.getRoomId()));
        reservationDO.setStartDate(getSQLDate(reservation.getStartDate()));
        reservationDO.setEndDate(getSQLDate(reservation.getEndDate()));

        repo.save(reservationDO);
        
        reservation.getGuests().stream()
        	.forEach(guest -> {
        		com.cliffconsulting.travel.entity.ReservationGuest guestDO = new com.cliffconsulting.travel.entity.ReservationGuest();
        		BeanUtils.copyProperties(guest,  guestDO);
        		guestDO = guestRepo.save(guestDO);
        	});
    }

    public void deleteReservation(long reservationId) {
        repo.deleteById(reservationId);
        guestRepo.deleteByReservationId(reservationId);
        
    }

    
    public java.util.Date getSQLDate(org.threeten.bp.LocalDate date) {
    	final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
    	return new java.util.Date(MILLIS_IN_DAY * date.toEpochDay());
    }
    
    public org.threeten.bp.LocalDate getLocalDate(java.util.Date date) {
    	final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
    	return org.threeten.bp.LocalDate.ofEpochDay(date.getTime() / MILLIS_IN_DAY);
    }

}
