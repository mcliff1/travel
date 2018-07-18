package com.cliffconsulting.travel.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
start date 8/6/18 - 8/10/18

select rend.*, next_start_dt from 
(select r.*, start_dt max_start_prior, max_end_prior from room r left join
 (
select rm1.room_id, start_dt, max_end_prior from 
(select start_dt, room_id
    from reservation) rm1 left join 	 
(select max(end_dt) max_end_prior, room_id
    from reservation
    where end_dt < '2018-08-06'
      group by room_id) rm2 on rm1.room_id = rm2.room_id
where max_end_prior is null or start_dt > max_end_prior	  
 
) rprior on rprior.room_id = r.room_id ) rend left join

 (select min(start_dt) next_start_dt, room_id 
   from reservation where start_dt > '2018-08-10' group by room_id) rnextstart on rnextstart.room_id = rend.room_id
	 


or  select reservation res where start_dt < '2018-08-06' and end_dt < '2018-0'

*/
@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	//@Query("select r.room_id as roomId, r.max_guests as maxGuests from room r left join (select * from reservation res where start_dt < :res_end_dt and end_dt > :res_start_dt ) res on r.room_id = res.room_id where end_dt is null and start_dt is null")
    //List<AvailableRoom> findAvailableRoomsByDate(@Param("res_start_dt") Date startDate, @Param("res_end_dt") Date endDate, Pageable pageable);

}

