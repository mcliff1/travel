package com.cliffconsulting.travel.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cliffconsulting.travel.entity.bean.ReservationGuestBean;

@Repository
public interface ReservationGuestRepository extends JpaRepository<ReservationGuestBean, Long>{

	@Query("select g from ReservationGuest g where reservation_id = :reservation_id")
    List<ReservationGuestBean> findGuestsByReservationId(@Param("reservation_id") Long reservationId);

	@Transactional
	@Query("delete from ReservationGuest where reservation_id = :reservation_id")
	void deleteByReservationId(@Param("reservation_id") Long reservationId);
	
}

