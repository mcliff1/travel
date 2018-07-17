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

import com.cliffconsulting.travel.entity.HotelRepository;
import com.cliffconsulting.travel.model.Hotel;
import com.cliffconsulting.travel.service.HotelService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {HotelService.class, HotelApiController.class, HotelRepository.class})
@WebMvcTest(value = HotelApiController.class, secure=false)
public class HotelApiControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	private HotelService hotelService;

	@MockBean
	private HotelRepository hotelRepo;

	
	private Hotel mockHotel;
	private Hotel mockHotel2;

	private String mockHotelJson;
	private String mockHotelJson2;
	
	public HotelApiControllerTest( ) {
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
	public void testAddHotel() throws Exception {
		final String METHOD = "testAddHotel():";
		System.out.println(METHOD + "start");
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
		

		//System.out.println(METHOD + "result:" + result);
		//System.out.println(METHOD + "response:" + result.getResponse());
		//System.out.println(METHOD + "content:" + result.getResponse().getContentAsString());

		//String expected = "{ 'hotelId':1, 'name': 'The Landmark' }";
		
		JSONAssert.assertEquals(mockHotelJson,  result.getResponse().getContentAsString(), false);
		
		
	}

	
	@Test
	public void testPutHotel() throws Exception {
		final String METHOD = "testPutHotel():";
		System.out.println(METHOD + "start");
				
		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.put("/hotel")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockHotelJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		

		//System.out.println(METHOD + "response:" + result.getResponse());
		//System.out.println(METHOD + "content:" + result.getResponse().getContentAsString());
		//System.out.println(METHOD + "status:" + result.getResponse().getStatus());

		//String expected = "{ 'hotelId':1, 'name': 'The Landmark' }";
		
		// invalid input
		//assertEquals(405,  result.getResponse().getStatus());
		
		// invalid input
		assertEquals(200,  result.getResponse().getStatus());
		
		
	}

	
	
	@Test
	public void testPutInvalidHotel() throws Exception {
		final String METHOD = "testPutInvalidHotel():";
		System.out.println(METHOD + "start");
		//Mockito
		//.when(hotelService.updateHotel(Mockito.any(Hotel.class)))
		//.thenReturn(mockHotel);
				

		Hotel mockHotelbad = new Hotel();
		mockHotelbad.setHotelId(null);
		mockHotelbad.setName("Mocktelbad");
		mockHotelbad.setAddress("Farm");
		mockHotelbad.setCity("Southby");;
		mockHotelbad.setPhone("(888) 123-AWAY");
		mockHotelbad.setStars(1);

		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.put("/hotel")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"somethingwithnoid\": \"anythingbad\"}")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		
		//String expected = "{ 'hotelId':1, 'name': 'The Landmark' }";
		
		// invalid input
		//assertEquals(405,  result.getResponse().getStatus());
		
		// invalid input
		assertEquals(400,  result.getResponse().getStatus());
		
		
	}


	
	@Test
	public void testPutNonExistingHotel() throws Exception {
		final String METHOD = "testPutNonExistingHotel():";
		System.out.println(METHOD + "start");
		
		// only find mock1
		//Mockito.when(hotelService.updateHotel(Mockito.any(Hotel.class))).doThrow(new ApiException(200, "")););
		
		Mockito.doThrow(new ApiException(404, "not found")).when(hotelService).updateHotel(Mockito.any(Hotel.class));
		
		
		//.thenReturn(mockHotel);
		//Mockito
		//.when(hotelRepo.existsById(mockHotel2.getHotelId()))
		//.thenReturn(false);
				
		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.put("/hotel")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockHotelJson2)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		
		assertEquals(404,  result.getResponse().getStatus());
	}


	
	
	
}


