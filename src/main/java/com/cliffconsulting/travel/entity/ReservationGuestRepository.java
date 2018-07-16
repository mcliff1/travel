package com.cliffconsulting.travel.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationGuestRepository extends JpaRepository<ReservationGuest, Long>{

}

