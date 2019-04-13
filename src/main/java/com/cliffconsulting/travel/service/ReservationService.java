package com.cliffconsulting.travel.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.entity.ReservationGuestRepository;
import com.cliffconsulting.travel.entity.ReservationRepository;
import com.cliffconsulting.travel.entity.bean.ReservationBean;
import com.cliffconsulting.travel.entity.bean.ReservationGuestBean;
import com.cliffconsulting.travel.model.Reservation;
import com.cliffconsulting.travel.model.ReservationGuest;

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
        ReservationBean reservationDO = repo.findById(reservationId).orElse(null);
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDO, reservation);
        reservation.setStartDate(getLocalDate(reservationDO.getStartDate()));
        reservation.setEndDate(getLocalDate(reservationDO.getEndDate()));
        List<ReservationGuest> guestList = new ArrayList<ReservationGuest>();
        List<ReservationGuestBean> guestsDO = guestRepo.findGuestsByReservationId(reservationId);
        guestsDO.stream()
        	.forEach(guestDO -> {
        		ReservationGuest guest = new ReservationGuest();
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
    	
        ReservationBean reservationDO = new ReservationBean();
        BeanUtils.copyProperties(reservation, reservationDO);

        reservationDO.setStartDate(getSQLDate(reservation.getStartDate()));
        reservationDO.setEndDate(getSQLDate(reservation.getEndDate()));

        reservationDO = repo.save(reservationDO);
        BeanUtils.copyProperties(reservationDO, reservation);

        //List<com.cliffconsulting.travel.entity.ReservationGuest> guestsDO = guestRepo.findGuestsByReservationId(reservationId);
        List<ReservationGuest> guestList = new ArrayList<ReservationGuest>();
        reservation.getGuests().stream()
        	.forEach(guest -> {
        		ReservationGuestBean guestDO = new ReservationGuestBean();
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
        ReservationBean reservationDO = new ReservationBean();
        BeanUtils.copyProperties(reservation, reservationDO);
        reservationDO.setStartDate(getSQLDate(reservation.getStartDate()));
        reservationDO.setEndDate(getSQLDate(reservation.getEndDate()));

        repo.save(reservationDO);
        
        reservation.getGuests().stream()
        	.forEach(guest -> {
        		ReservationGuestBean guestDO = new ReservationGuestBean();
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
