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

//import com.cliffconsulting.travel.entity.RoomRepository;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.service.RoomService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {RoomService.class, RoomApiController.class})
@WebMvcTest(value = RoomApiController.class, secure=false)
public class RoomApiControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	private RoomService roomService;

	//@MockBean
	//private RoomRepository roomRepo;

	
	private Room mockRoom;
	private Room mockRoom2;

	private String mockRoomJson;
	private String mockRoomJson2;
	
	public RoomApiControllerTest( ) {
		mockRoom = new Room();
		mockRoom.setRoomId(99L);
		mockRoom.setDescription("Mocktel");
		mockRoom.setMaxGuests(4);

		mockRoom2 = new Room();
		mockRoom2.setRoomId(100L);
		mockRoom2.setDescription("Mocktel2");
		mockRoom2.setMaxGuests(2);

		
		mockRoomJson = "{\"description\" : \"Mocktel\", "
				+ "\"roomId\" : 99, "
				+ "\"maxGuests\" : 4"
				+ "}";

		mockRoomJson2 = "{\"description\" : \"Mocktel2\", "
				+ "\"roomId\" : 100, "
				+ "\"maxGuests\" : 2"
				+ "}";

	}
	
	@Test
	public void testAddRoom() throws Exception {
		final String METHOD = "testAddRoom():";
		System.out.println(METHOD + "start");
		Mockito
		.when(roomService.addRoom(Mockito.any(Room.class)))
		.thenReturn(mockRoom);
				
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.post("/room")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockRoomJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
			
		JSONAssert.assertEquals(mockRoomJson,  result.getResponse().getContentAsString(), false);
		
		
	}

	
	@Test
	public void testPutRoom() throws Exception {
		final String METHOD = "testPutRoom():";
		System.out.println(METHOD + "start");
				
		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.put("/room")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockRoomJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		

		//System.out.println(METHOD + "response:" + result.getResponse());
		//System.out.println(METHOD + "content:" + result.getResponse().getContentAsString());
		//System.out.println(METHOD + "status:" + result.getResponse().getStatus());

		//String expected = "{ 'RoomId':1, 'name': 'The Landmark' }";
		
		// invalid input
		//assertEquals(405,  result.getResponse().getStatus());
		
		// invalid input
		assertEquals(200,  result.getResponse().getStatus());
		
		
	}

	
	
	@Test
	public void testPutInvalidRoom() throws Exception {
		final String METHOD = "testPutInvalidRoom():";
		System.out.println(METHOD + "start");
		//Mockito
		//.when(RoomService.updateRoom(Mockito.any(Room.class)))
		//.thenReturn(mockRoom);
				


		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.put("/room")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"somethingwithnoid\": \"anythingbad\"}")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		
		//String expected = "{ 'RoomId':1, 'name': 'The Landmark' }";
		
		// invalid input
		//assertEquals(405,  result.getResponse().getStatus());
		
		// invalid input
		assertEquals(400,  result.getResponse().getStatus());
		
		
	}


	
	@Test
	public void testPutNonExistingRoom() throws Exception {
		final String METHOD = "testPutNonExistingRoom():";
		System.out.println(METHOD + "start");
		
		// only find mock1
		//Mockito.when(RoomService.updateRoom(Mockito.any(Room.class))).doThrow(new ApiException(200, "")););
		
		Mockito.doThrow(new ApiException(404, "not found")).when(roomService).updateRoom(Mockito.any(Room.class));
		
		RequestBuilder reqBuilder = 
				MockMvcRequestBuilders
				.put("/room")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockRoomJson2)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		
		assertEquals(404,  result.getResponse().getStatus());
	}


	
	
	
}


