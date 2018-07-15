package com.cliffconsulting.travel.api;

import com.cliffconsulting.travel.model.ModelApiResponse;
import org.springframework.core.io.Resource;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.model.RoomQuery;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

@Controller
public class RoomApiController implements RoomApi {

    private static final Logger log = LoggerFactory.getLogger(RoomApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RoomApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Room> addRoom(@ApiParam(value = "Room object that needs to be added" ,required=true )  @Valid @RequestBody Room body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Room>(objectMapper.readValue("{  \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ],  \"endAvailDate\" : \"2000-01-23\",  \"maxGuests\" : 1,  \"description\" : \"1 bed suite with King\",  \"hotelId\" : 6,  \"roomId\" : 0,  \"startAvailDate\" : \"2000-01-23\"}", Room.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Room>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Room>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteRoom(@ApiParam(value = "Room id to delete",required=true) @PathVariable("roomId") Long roomId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Room>> findRoom(@ApiParam(value = "Room object that needs to be added" ,required=true )  @Valid @RequestBody RoomQuery body) {
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

    public ResponseEntity<Room> getRoomById(@ApiParam(value = "ID of room to return",required=true) @PathVariable("roomId") Long roomId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Room>(objectMapper.readValue("{  \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ],  \"endAvailDate\" : \"2000-01-23\",  \"maxGuests\" : 1,  \"description\" : \"1 bed suite with King\",  \"hotelId\" : 6,  \"roomId\" : 0,  \"startAvailDate\" : \"2000-01-23\"}", Room.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Room>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Room>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateRoom(@ApiParam(value = "Room object that needs to be updated" ,required=true )  @Valid @RequestBody Room body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ModelApiResponse> uploadFile(@ApiParam(value = "ID of room to update",required=true) @PathVariable("roomId") Long roomId,@ApiParam(value = "Additional data to pass to server") @RequestParam(value="additionalMetadata", required=false)  String additionalMetadata,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile file) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{  \"code\" : 0,  \"type\" : \"type\",  \"message\" : \"message\"}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
