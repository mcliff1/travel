package com.cliffconsulting.travel.api;

import com.cliffconsulting.travel.model.Reservation;
import com.cliffconsulting.travel.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@Controller
public class ReservationApiController implements ReservationApi {

    @Autowired
    ReservationService reservationService;

    private static final Logger log = LoggerFactory.getLogger(ReservationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Reservation> bookRoom(@ApiParam(value = "ID of hotel to return",required=true) @PathVariable("hotelId") Long hotelId,@ApiParam(value = "object that needs to be added" ,required=true )  @Valid @RequestBody Reservation body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Reservation>(objectMapper.readValue("{  \"reservationId\" : 0,  \"endDate\" : \"2000-01-23\",  \"guests\" : [ {    \"name\" : \"name\",    \"age\" : 6  }, {    \"name\" : \"name\",    \"age\" : 6  } ],  \"roomId\" : \"roomId\",  \"startDate\" : \"2000-01-23\"}", Reservation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Reservation>(HttpStatus.NOT_IMPLEMENTED);
    }



    public ResponseEntity<Void> deleteReservation(@ApiParam(value = "reservation id to delete",required=true) @PathVariable("reservationId") Long reservationId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        if (!reservationService.exists(reservationId)) {
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Reservation> getReservationById(@ApiParam(value = "ID of reservation to return",required=true) @PathVariable("reservationId") Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation == null) { return  new ResponseEntity<Reservation>(HttpStatus.NOT_IMPLEMENTED); }
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

}
