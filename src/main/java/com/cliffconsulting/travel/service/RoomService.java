package com.cliffconsulting.travel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cliffconsulting.travel.entity.RoomRepository;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.model.RoomQuery;

@Service
public class RoomService { 

    @Autowired 
    RoomRepository repo;

    public boolean existsById(long roomId) {
        return repo.exists(roomId);
    }

    public Room getRoomById(long roomId) {
        com.cliffconsulting.travel.entity.Room roomDO = repo.findOne(roomId);
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


    public void updateRoom(Room room) {
        com.cliffconsulting.travel.entity.Room roomDO = new com.cliffconsulting.travel.entity.Room();
        BeanUtils.copyProperties(room, roomDO);
        repo.save(roomDO);
    }

    public void deleteRoom(long roomId) {
        repo.delete(roomId);
    }


    /**
     * Key business logic for the system
     *  make list of room_id, closest_previous_end_date d1, and subsequent_start_date d2
     *  and filter where query.start >= d1 and query.end <= d2 
     */
    public List<Room> findRoom(RoomQuery query) {
        final String METHOD = "findRoom():" + query;

        List<Room> list = new ArrayList<Room>();

        return list;
    }

}
