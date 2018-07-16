package com.cliffconsulting.travel.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cliffconsulting.travel.entity.RoomRepository;
import com.cliffconsulting.travel.model.Room;

@Service
public class RoomService { 

    @Autowired 
    RoomRepository repo;

    public boolean existsById(long roomId) {
        return repo.existsById(Long.valueOf(roomId));
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

    public boolean deleteRoom(long roomId) {
        return repo.deleteById(Long.valueOf(roomId));
    }

}
