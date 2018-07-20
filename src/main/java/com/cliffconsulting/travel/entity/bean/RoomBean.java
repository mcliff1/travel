package com.cliffconsulting.travel.entity.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class RoomBean implements Serializable { 

    private static final long serialVersionUID = 14653464122345L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="room_id")
    private Long roomId;  

    @Column(name="hotel_id")
    private Long hotelId;  

    private String description;

    @Column(name="max_guests")    
    private int maxGuests;

    private Date startAvailDate;

    private Date endAvailDate;

    
    public RoomBean() {
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
        return String.format("Room[roomId=%s, hotelId=%s, description=%s, maxGuests=%s, startAvailDate=%, endAvailDate=%]",
            roomId, hotelId, description, maxGuests, startAvailDate, endAvailDate);
    }

	public Date getStartAvailDate() {
		return startAvailDate;
	}

	public void setStartAvailDate(Date startAvailDate) {
		this.startAvailDate = startAvailDate;
	}

	public Date getEndAvailDate() {
		return endAvailDate;
	}

	public void setEndAvailDate(Date endAvailDate) {
		this.endAvailDate = endAvailDate;
	}
}  

