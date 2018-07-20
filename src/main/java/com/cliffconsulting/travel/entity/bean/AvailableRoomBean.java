package com.cliffconsulting.travel.entity.bean;

public class AvailableRoomBean {

	private Long roomId;
	private int maxGuests;
	
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public int getMaxGuests() {
		return maxGuests;
	}
	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}
	
	@Override
    public String toString() {
        return String.format("AvailableRoom[roomId=%s, maxGuests=%s]",
            roomId, maxGuests);
    }

}
