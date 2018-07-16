package com.cliffconsulting.travel.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="reservation")
@Entity
public class Reservation implements Serializable { 

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="reservation_id")
    private Long reservationId;  

    @Column(name="room_id")
    private Long roomId;  

    @Column(name="start_dt")
    private Date startDate;

    @Column(name="end_dt")    
    private Date endDate;

    @Column(name="num_guest")    
    private int numberOfGuests;

    public Reservation() {
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return String.format("Reservation[reservationId=%s, roomId=%s, startDate=%s, endDate=%s, numberOfGuests=%s]",
            reservationId, roomId, startDate, endDate, numberOfGuests);
    }
}  

