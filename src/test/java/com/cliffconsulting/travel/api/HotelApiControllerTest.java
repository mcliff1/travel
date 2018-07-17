package com.cliffconsulting.travel.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cliffconsulting.travel.model.Hotel;
import com.cliffconsulting.travel.service.HotelService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {HotelService.class, HotelApiController.class})
@WebMvcTest(value = HotelApiController.class, secure=false)
public class HotelApiControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	private HotelService hotelService;
	
	private Hotel mockHotel;

	private String mockHotelJson;
	
	public HotelApiControllerTest( ) {
		mockHotel = new Hotel();
		mockHotel.setHotelId(99L);
		mockHotel.setName("Mocktel");
		mockHotel.setAddress("123 Funny Farm");
		mockHotel.setCity("Cambridge");;
		mockHotel.setPhone("(212) 123-AWAY");
		mockHotel.setStars(4);
		
		mockHotelJson = "{\"name\" : \"Mocktel\", "
				+ "\"hotelId\" : 99, "
				+ "\"address\" : \"123 Funny Farm\", "
				+ "\"city\" : \"Cambridge\", "
				+ "\"phone\" : \"(212) 123-AWAY\", "
				+ "\"stars\" : 4"
				+ "}";
	}
	
	@Test
	public void testAddHotel() throws Exception {
		System.out.println("***start");
		Mockito
		.when(hotelService.addHotel(Mockito.any(Hotel.class)))
		.thenReturn(mockHotel);
				
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.post("/hotel")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockHotelJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		

		System.out.println("result:" + result);
		System.out.println("response:" + result.getResponse());
		System.out.println("content:" + result.getResponse().getContentAsString());

		//String expected = "{ 'hotelId':1, 'name': 'The Landmark' }";
		
		JSONAssert.assertEquals(mockHotelJson,  result.getResponse().getContentAsString(), false);
		
		
	}

	
	@Test
	public void testAddInvalidHotel() throws Exception {
				
		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.post("/hotel")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"name\" : \"ok name\", \"extraparam\" : \"should error\"}")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		

		System.out.println("status:" + result.getResponse().getStatus());

		//String expected = "{ 'hotelId':1, 'name': 'The Landmark' }";
		
		// invalid input
		assertEquals(405,  result.getResponse().getStatus());
		
		
	}

	
	
	
}


