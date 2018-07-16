package com.cliffconsulting.travel.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomPhotoRepository extends JpaRepository<RoomPhoto, Long>{

}

