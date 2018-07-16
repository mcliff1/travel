package com.cliffconsulting.travel.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Table(name="hotel")
@Entity
public class Room implements Serializable { 

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="room_id")
    private Long roomId;  

    @Column(name="hotel_id")
    private Long hotelId;  

    private String description;

    @Column(name="max_guests")    
    private int maxGuests;

    public Room() {
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    @Override
    public String toString() {
        return String.format("Room[roomId=%s, hotelId=%s, description=%s, maxGuests=%s]",
            roomId, hotelId, description, maxGuests);
    }
}  

