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

    @Autowired
    public ReservationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Reservation> bookRoom(@ApiParam(value = "ID of hotel to return",required=true) @PathVariable("hotelId") Long hotelId,@ApiParam(value = "object that needs to be added" ,required=true )  @Valid @RequestBody Reservation body) {
    	final String METHOD = "bookRoom():";
    	log.debug(METHOD + "begin");
        Reservation bookedReservation = reservationService.addReservation(body);
        
        
        return new ResponseEntity<Reservation>(bookedReservation, HttpStatus.OK);
        
    }



    public ResponseEntity<Void> deleteReservation(@ApiParam(value = "reservation id to delete",required=true) @PathVariable("reservationId") Long reservationId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        if (!reservationService.exists(reservationId)) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
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
