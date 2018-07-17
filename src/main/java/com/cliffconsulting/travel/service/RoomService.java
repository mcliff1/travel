package com.cliffconsulting.travel.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliffconsulting.travel.api.ApiException;
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
    RoomPhotoRepository photoRepo;

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

    

    /**
     * Key business logic for the system
     *  make list of room_id, closest_previous_end_date d1, and subsequent_start_date d2
     *  and filter where query.start >= d1 and query.end <= d2 
     */
    public List<Room> findRoom(RoomQuery query) {
        final String METHOD = "findRoom():";
        log.debug(METHOD + query);

        List<Room> list = new ArrayList<Room>();

        return list;
    }

}
