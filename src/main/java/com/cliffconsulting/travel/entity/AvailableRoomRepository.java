package com.cliffconsulting.travel.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AvailableRoomRepository {

	private static final Logger log = LoggerFactory.getLogger(AvailableRoomRepository.class);


	@Autowired
	JdbcTemplate jdbcTemplate;
    
    class AvailableRoomMapper implements RowMapper<AvailableRoom> {
    	@Override
    	public AvailableRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
    		AvailableRoom aRoom = new AvailableRoom();
    		aRoom.setRoomId(rs.getLong("room_id"));
    		aRoom.setMaxGuests(rs.getInt("max_guests"));
    		return aRoom;
    		
    	}
    }
	
	public List<AvailableRoom> findByDatesAndHotel(Date startDate, Date endDate, Long hotelId) {
		final String METHOD = "findByDatesAndHotel():";
		log.debug(METHOD + "begin");
		
	    List<AvailableRoom> list = null; 
    
	    if (hotelId != null) {
	    	final String SQL = "select r.room_id as roomId, r.max_guests as maxGuests from room r left join (select * from reservation res where end_dt > ? and start_dt < ? ) res on r.room_id = res.room_id where end_dt is null and start_dt is null and hotel_id = ?";
        
    		list = 
    			jdbcTemplate.query(SQL, new Object[] {startDate, endDate, hotelId }, new AvailableRoomMapper());
	    } else {
	    	final String SQL = "select r.room_id as roomId, r.max_guests as maxGuests from room r left join (select * from reservation res where end_dt > ? and start_dt < ? ) res on r.room_id = res.room_id where end_dt is null and start_dt is null";
    
	    	list = 
	    			jdbcTemplate.query(SQL, new Object[] {startDate, endDate }, new AvailableRoomMapper());
	    }
	    if (list != null) { log.debug(METHOD + "db returned:" + list.size()); }
	    else { log.debug(METHOD + "no available rooms for hotel"); }

    
	    log.debug(METHOD + "available rooms before guest filter:" + list);
	    return list;

	}
}
