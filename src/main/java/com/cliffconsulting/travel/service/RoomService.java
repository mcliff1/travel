package com.cliffconsulting.travel.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.api.ApiException;
import com.cliffconsulting.travel.entity.AvailableRoomRepository;
import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.entity.RoomPhotoRepository;
import com.cliffconsulting.travel.entity.RoomRepository;
import com.cliffconsulting.travel.entity.bean.AvailableRoomBean;
import com.cliffconsulting.travel.entity.bean.Hotel;
import com.cliffconsulting.travel.entity.bean.RoomBean;
import com.cliffconsulting.travel.entity.bean.RoomPhotoBean;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.model.RoomQuery;

@Service
public class RoomService { 

    @Autowired 
    RoomRepository repo;

    @Autowired
    AvailableRoomRepository availRepo;
    
    @Autowired 
    RoomPhotoRepository photoRepo;

    @Autowired 
    HotelRepository hotelRepo;

    private static final Logger log = LoggerFactory.getLogger(RoomService.class);

    
    public boolean existsById(long roomId) {
        return repo.existsById(roomId);
    }

    public Room getRoomById(long roomId) {
        RoomBean roomDO = 
            repo.findById(roomId).orElse(null);

        // repo.findById(roomId).orElseThrow(() -> new NotFoundEntity(roomId));
        // Optional<Foo> fooOpt = repo.findById(id);
        // if (fooOpt.isPresent()) {
        //    Foo foo = fooOpt.get();
        //    ...
        // } else { throw not FoundException() }
        Room room = new Room();
        BeanUtils.copyProperties(roomDO, room);
        
        
        //  need to pull in the images
        List<RoomPhotoBean> photoList = photoRepo.findByRoomId(roomId);
        List<String> urlList = new ArrayList<String>();
        if (photoList != null) {
        
            photoList.stream()
        		.forEach(photo -> urlList.add(photo.getUrl()));
        }
        room.setPhotoUrls(urlList);;
        
        return room;
    }

    public Room addRoom(Room room) {
        RoomBean roomDO = new RoomBean();
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
    		RoomBean roomDO = new RoomBean();
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
    	
    	RoomPhotoBean existing = photoRepo.findUrlByRoomId(roomId, url);
    	RoomPhotoBean photo = new RoomPhotoBean();
    	photo.setRoomId(roomId);
    	photo.setUrl(url);
    	
    	if (existing != null) {
    		photo.setPhotoId(existing.getPhotoId());
    	}
        photoRepo.save(photo);
    }

    
    class AvailableRoomMapper implements RowMapper<AvailableRoomBean> {
    	@Override
    	public AvailableRoomBean mapRow(ResultSet rs, int rowNum) throws SQLException {
    		AvailableRoomBean aRoom = new AvailableRoomBean();
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
        
        List<AvailableRoomBean> list = null;
        Long hotelId = null;
        if (query.getHotelName() != null) {
        	Hotel hotel = hotelRepo.findByName(query.getHotelName());
        	if (hotel != null) {
        		hotelId = hotel.getHotelId();
        	}
        }
        final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        java.sql.Date startDate = new java.sql.Date(MILLIS_IN_DAY * query.getStartDate().toEpochDay());
        java.sql.Date endDate = new java.sql.Date(MILLIS_IN_DAY * query.getEndDate().toEpochDay());
        
        		
        list = availRepo.findByDatesAndHotel(startDate, endDate, hotelId);
        
        log.debug(METHOD + "available rooms before guest filter:" + list);
        //Stream<AvailableRoom> roomMatchs = 
        List<Room> roomList = new ArrayList<Room>();
        
        list.stream()
        	.filter(r -> r.getMaxGuests() >= query.getGuests())
        	.forEach(r -> roomList.add(getRoomById(r.getRoomId())));
        log.debug(METHOD + "return:" + roomList);
        return roomList;
    }
    
}
