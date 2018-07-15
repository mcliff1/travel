package com.cliffconsulting.travel.api;

import com.cliffconsulting.travel.model.Hotel;
import com.cliffconsulting.travel.model.Reservation;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T20:07:07.747Z")

@Controller
public class ReservationApiController implements ReservationApi {

    private static final Logger log = LoggerFactory.getLogger(ReservationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Hotel> bookRoom(@ApiParam(value = "ID of hotel to return",required=true) @PathVariable("hotelId") Long hotelId,@ApiParam(value = "object that needs to be added" ,required=true )  @Valid @RequestBody Reservation body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Hotel>(objectMapper.readValue("{  \"address\" : \"123 South Main Street\",  \"city\" : \"Denver\",  \"phone\" : \"(303) 555-STAY\",  \"name\" : \"The Landmark\",  \"hotelId\" : 0,  \"stars\" : 6}", Hotel.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Hotel>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Hotel>(HttpStatus.NOT_IMPLEMENTED);
    }

}
