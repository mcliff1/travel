package com.cliffconsulting.travel.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.api.ApiException;
import com.cliffconsulting.travel.entity.AvailableRoom;
import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.entity.RoomPhoto;
import com.cliffconsulting.travel.entity.RoomPhotoRepository;
import com.cliffconsulting.travel.entity.RoomRepository;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.model.RoomQuery;

@Service
public class RoomService { 

    @Autowired 
    RoomRepository repo;

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired 
    RoomPhotoRepository photoRepo;

    @Autowired 
    HotelRepository hotelRepo;

    private static final Logger log = LoggerFactory.getLogger(RoomService.class);

    
    public boolean existsById(long roomId) {
        return repo.existsById(roomId);
    }

    public Room getRoomById(long roomId) {
        com.cliffconsulting.travel.entity.Room roomDO = 
            repo.findById(roomId).orElse(null);

        // repo.findById(roomId).orElseThrow(() -> new NotFoundEntity(roomId));
        // Optional<Foo> fooOpt = repo.findById(id);
        // if (fooOpt.isPresent()) {
        //    Foo foo = fooOpt.get();
        //    ...
        // } else { throw not FoundException() }
        Room room = new Room();
        BeanUtils.copyProperties(roomDO, room);
        return room;
    }

    public Room addRoom(Room room) {
        com.cliffconsulting.travel.entity.Room roomDO = new com.cliffconsulting.travel.entity.Room();
        BeanUtils.copyProperties(room, roomDO);
        roomDO = repo.save(roomDO);
        BeanUtils.copyProperties(roomDO, room);
        return room;
    }


    public void updateRoom(Room room) throws ApiException {
    	final String METHOD = "updateRoom():";
    	log.info(METHOD + room);
    	try {
    		if (room.getRoomId() == null) { throw new ApiException(400, "null id"); }
    		log.info("calling repo on:" + room.getRoomId());
    		if (!repo.existsById(room.getRoomId())) { throw new ApiException(404, "room not found"); }
    		
    		// make the update
    		com.cliffconsulting.travel.entity.Room roomDO = new com.cliffconsulting.travel.entity.Room();
            BeanUtils.copyProperties(room, roomDO);
            repo.save(roomDO);

    	} catch (Exception e) {
    		if (e instanceof ApiException) { throw e; }
    		else throw new ApiException(405, e.getMessage());
    	}
    }
    
    
    
    public void deleteRoom(long roomId) {
        repo.deleteById(roomId);
    }

    
    /**
     * @param roomId
     * @param url
     */
    public void uploadPhoto(long roomId, String url) {
    	
    	RoomPhoto existing = photoRepo.findUrlByRoomId(roomId, url);
    	RoomPhoto photo = new RoomPhoto();
    	photo.setRoomId(roomId);
    	photo.setUrl(url);
    	
    	if (existing != null) {
    		photo.setPhotoId(existing.getPhotoId());
    	}
        photoRepo.save(photo);
    }

    
    class AvailableRoomMapper implements RowMapper<AvailableRoom> {
    	@Override
    	public AvailableRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
    		AvailableRoom aRoom = new AvailableRoom();
    		aRoom.setRoomId(rs.getLong("room_id"));
    		aRoom.setMaxGuests(rs.getInt("max_guests"));
    		return aRoom;
    		
    	}
    }

    /**
     * Key business logic for the system
     *  make list of room_id, closest_previous_end_date d1, and subsequent_start_date d2
     *  and filter where query.start >= d1 and query.end <= d2 
     */
    public List<Room> findRoom(RoomQuery query) {
        final String METHOD = "findRoom():";
        log.debug(METHOD + query);
        
        List<AvailableRoom> list = null; 
        
        if (query.getHotelName() != null) {
        	com.cliffconsulting.travel.entity.Hotel hotel = hotelRepo.findByName(query.getHotelName());
        	if (hotel != null) {
        		final String SQL = "select r.room_id as roomId, r.max_guests as maxGuests from room r left join (select * from reservation res where end_dt > ? and start_dt < ? ) res on r.room_id = res.room_id where end_dt is null and start_dt is null and hotel_id = ?";
            
        		list = 
        			jdbcTemplate.query(SQL, new Object[] {query.getStartDate(), query.getEndDate(), hotel.getHotelId() }, new AvailableRoomMapper());
        	}    	
        } else {
        	final String SQL = "select r.room_id as roomId, r.max_guests as maxGuests from room r left join (select * from reservation res where end_dt > ? and start_dt < ? ) res on r.room_id = res.room_id where end_dt is null and start_dt is null";
        
        	list = 
        		jdbcTemplate.query(SQL, new Object[] {query.getStartDate(), query.getEndDate() }, new AvailableRoomMapper());
        }
        
        log.debug(METHOD + "available rooms before guest filter:" + list);
        
        return new ArrayList<Room>();
    }
    
}
