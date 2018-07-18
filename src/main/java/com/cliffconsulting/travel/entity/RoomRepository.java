package com.cliffconsulting.travel.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	//@Query("select r.room_id as roomId, r.max_guests as maxGuests from room r left join (select * from reservation res where start_dt < :res_end_dt and end_dt > :res_start_dt ) res on r.room_id = res.room_id where end_dt is null and start_dt is null")
    //List<AvailableRoom> findAvailableRoomsByDate(@Param("res_start_dt") Date startDate, @Param("res_end_dt") Date endDate, Pageable pageable);

}

