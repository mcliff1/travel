package com.cliffconsulting.travel.api;

import com.cliffconsulting.travel.model.Hotel;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.service.HotelService;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

@CrossOrigin
@Controller
public class HotelApiController implements HotelApi {

    @Autowired
    HotelService hotelService; 

    private static final Logger log = LoggerFactory.getLogger(HotelApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public HotelApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Hotel> addHotel(@ApiParam(value = "Hotel object that needs to be added" ,required=true )  @Valid @RequestBody Hotel body) {
        String accept = request.getHeader("Accept");
/*
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Hotel>(objectMapper.readValue("{  \"address\" : \"123 South Main Street\",  \"city\" : \"Denver\",  \"phone\" : \"(303) 555-STAY\",  \"name\" : \"The Landmark\",  \"hotelId\" : 0,  \"stars\" : 6}", Hotel.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Hotel>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Hotel>(HttpStatus.NOT_IMPLEMENTED);
*/
        final String METHOD = "add():";
        Hotel hotel = hotelService.addHotel(body);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
    }

    /**
     * Deletes a Hotel
     */
    public ResponseEntity<Void> deleteHotel(@ApiParam(value = "Hotel id to delete",required=true) @PathVariable("hotelId") Long hotelId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        final String METHOD = "delete():";
        String accept = request.getHeader("Accept");
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Room>> getAvailableRooms(@ApiParam(value = "ID of hotel to return",required=true) @PathVariable("hotelId") Long hotelId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Room>>(objectMapper.readValue("[ {  \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ],  \"endAvailDate\" : \"2000-01-23\",  \"maxGuests\" : 1,  \"description\" : \"1 bed suite with King\",  \"hotelId\" : 6,  \"roomId\" : 0,  \"startAvailDate\" : \"2000-01-23\"}, {  \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ],  \"endAvailDate\" : \"2000-01-23\",  \"maxGuests\" : 1,  \"description\" : \"1 bed suite with King\",  \"hotelId\" : 6,  \"roomId\" : 0,  \"startAvailDate\" : \"2000-01-23\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Room>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Room>>(HttpStatus.NOT_IMPLEMENTED);
    }



    /** 
     * business logic queries the local datastore
     *  - removed logic about requiring accept to contain application/json
     */
    public ResponseEntity<Hotel> getHotelById(@ApiParam(value = "ID of hotel to return",required=true) @PathVariable("hotelId") Long hotelId) {
        final String METHOD = "getHotelById():";
        log.info(METHOD + "begin");

        try {
            Hotel hotelObj = hotelService.getHotelById(hotelId);
            
            ResponseEntity<Hotel> hotel =  new ResponseEntity<Hotel>(hotelObj, HttpStatus.OK);
            return hotel;
        } catch (Exception e) {
            log.error(METHOD + "Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Hotel>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates the hotel
     */
    public ResponseEntity<Void> updateHotel(@ApiParam(value = "Hotel object that needs to be updated" ,required=true )  @Valid @RequestBody Hotel body) {
        final String METHOD = "updateHotel():";
        String accept = request.getHeader("Accept");

        try {
            hotelService.updateHotel(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(METHOD, e);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
