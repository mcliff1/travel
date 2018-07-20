package com.cliffconsulting.travel.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cliffconsulting.travel.entity.bean.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	@Query("SELECT h from hotel h where h.hotel_nm = :name")
    Hotel findByName(@Param("name") String name);
}

