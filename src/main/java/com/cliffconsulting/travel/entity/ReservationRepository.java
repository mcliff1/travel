package com.cliffconsulting.travel.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cliffconsulting.travel.entity.bean.ReservationBean;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationBean, Long>{

}

