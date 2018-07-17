package com.cliffconsulting.travel.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	@Query("SELECT h from Hotel h where h.name = :namea")
    Hotel findByName(@Param("namea") String name);
}

