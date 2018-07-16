package com.cliffconsulting.travel.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
//public interface HotelRepository extends CrudRepository<Hotel, Long> {

    Hotel findByHotelId(String hotelId);
    Hotel findByName(String name);
}

