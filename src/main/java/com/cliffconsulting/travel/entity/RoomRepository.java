package com.cliffconsulting.travel.entity;

import org.springframework.data.jpa.repository.JpaRepository;
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

}

