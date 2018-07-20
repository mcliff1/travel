package com.cliffconsulting.travel.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cliffconsulting.travel.entity.bean.RoomPhotoBean;

@Repository
public interface RoomPhotoRepository extends JpaRepository<RoomPhotoBean, Long>{

	@Query("select p from RoomPhoto p where room_id = :room_id and url = :url")
    RoomPhotoBean findUrlByRoomId(@Param("room_id") Long roomId, @Param("url") String url);

	@Query("select p from RoomPhoto p where room_id = :room_id")
    List<RoomPhotoBean> findByRoomId(@Param("room_id") Long roomId);

	
}

