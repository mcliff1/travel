package com.cliffconsulting.travel.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cliffconsulting.travel.entity.bean.Hotel;




@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {HotelRepository.class})
@ComponentScan
@EntityScan(basePackages={"com.cliffconsulting.travel.entity"})
@EnableJpaRepositories(basePackages={"com.cliffconsulting.travel.entity"})
public class HotelRepositoryTest {
	
	//@Autowired
	//private TestEntityManager entityManager;
	
	@Autowired
	private HotelRepository repo;
	
	@Test
	public void whenFindByName() {
		// given
		Hotel testHotel = new Hotel();
		testHotel.setName("The Landmark");
		//entityManager.merge(testHotel);
		//entityManager.persist(testHotel);
		//entityManager.flush();
		
		// when
		Hotel found = repo.findByName(testHotel.getName());
		
		// then
		assertThat(found).isNotNull();
		assertThat(found.getName()).isEqualTo(testHotel.getName());
	}
	
}
