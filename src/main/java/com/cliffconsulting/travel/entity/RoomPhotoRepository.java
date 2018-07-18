package com.cliffconsulting.travel.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomPhotoRepository extends JpaRepository<RoomPhoto, Long>{

	@Query("select p from RoomPhoto p where room_id = :room_id and url = :url")
    RoomPhoto findUrlByRoomId(@Param("room_id") Long roomId, @Param("url") String url);

	@Query("select p from RoomPhoto p where room_id = :room_id")
    List<RoomPhoto> findByRoomId(@Param("room_id") Long roomId);

	
}

