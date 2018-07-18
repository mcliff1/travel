package com.cliffconsulting.travel.service;

import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.model.Hotel;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {HotelService.class})
public class HotelServiceTest {

    @MockBean
    HotelRepository hotelRepo;

    @Autowired
    HotelService hotelService;

    
	private Hotel mockHotel;
	private Hotel mockHotel2;

	private String mockHotelJson;
	private String mockHotelJson2;
	
	public HotelServiceTest( ) {
		mockHotel = new Hotel();
		mockHotel.setHotelId(99L);
		mockHotel.setName("Mocktel");
		mockHotel.setAddress("123 Funny Farm");
		mockHotel.setCity("Cambridge");;
		mockHotel.setPhone("(212) 123-AWAY");
		mockHotel.setStars(4);

		mockHotel2 = new Hotel();
		mockHotel2.setHotelId(100L);
		mockHotel2.setName("Mocktel2");
		mockHotel2.setAddress("6 Sad Street");
		mockHotel2.setCity("Boston");;
		mockHotel2.setPhone("(954) WAY-5667");
		mockHotel2.setStars(2);

		
		mockHotelJson = "{\"name\" : \"Mocktel\", "
				+ "\"hotelId\" : 99, "
				+ "\"address\" : \"123 Funny Farm\", "
				+ "\"city\" : \"Cambridge\", "
				+ "\"phone\" : \"(212) 123-AWAY\", "
				+ "\"stars\" : 4"
				+ "}";

		mockHotelJson2 = "{\"name\" : \"Mocktel2\", "
				+ "\"hotelId\" : 100, "
				+ "\"address\" : \"6 Sad Street\", "
				+ "\"city\" : \"Boston\", "
				+ "\"phone\" : \"(954) WAY-5667\", "
				+ "\"stars\" : 2"
				+ "}";
	}    
    
    @Test
    public void testHaveAMockRepo() {
        assertNotNull(hotelRepo);
    }

	
    

//    @Test
//    public void testFindTheGreatestFromAllData_NoValues() {
//        assertNull(hotelService.getHotelById(10012));
//    }
}
