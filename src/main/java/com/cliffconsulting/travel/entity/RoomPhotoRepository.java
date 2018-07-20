package com.cliffconsulting.travel.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cliffconsulting.travel.entity.bean.RoomPhotoBean;

@Repository
public interface RoomPhotoRepository extends JpaRepository<RoomPhotoBean, Long>{

	// TODO - why are none of these validating!
	
	@Query(value = "select p from RoomPhoto p where room_id = :room_id and url = :url", nativeQuery = true)
    RoomPhotoBean findUrlByRoomId(@Param("room_id") Long roomId, @Param("url") String url);

	@Query(value = "select p from RoomPhoto p where room_id = :room_id", nativeQuery = true)
    List<RoomPhotoBean> findByRoomId(@Param("room_id") Long roomId);

	
}

