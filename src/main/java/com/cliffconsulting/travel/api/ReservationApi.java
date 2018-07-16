/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.0-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cliffconsulting.travel.api;

import com.cliffconsulting.travel.model.Reservation;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

@Api(value = "reservation", description = "the reservation API")
public interface ReservationApi {

    @ApiOperation(value = "creates a reservation for the requested room", nickname = "bookRoom", notes = "Returns a list of rooms available", response = Reservation.class, tags={ "reservation", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Reservation.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Hotel not found") })
    @RequestMapping(value = "/reservation/bookRoom",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Reservation> bookRoom(@ApiParam(value = "ID of hotel to return",required=true) @PathVariable("hotelId") Long hotelId,@ApiParam(value = "object that needs to be added" ,required=true )  @Valid @RequestBody Reservation body);


    @ApiOperation(value = "Deletes a reservation", nickname = "deleteReservation", notes = "", tags={ "reservation", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successfully removed"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "reservation not found") })
    @RequestMapping(value = "/reservation/{reservationId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteReservation(@ApiParam(value = "reservation id to delete",required=true) @PathVariable("reservationId") Long reservationId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey);


    @ApiOperation(value = "Find reservation by ID", nickname = "getReservationById", notes = "Returns a single reservation", response = Reservation.class, tags={ "reservation", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Reservation.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "reservation not found") })
    @RequestMapping(value = "/reservation/{reservationId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Reservation> getReservationById(@ApiParam(value = "ID of reservation to return",required=true) @PathVariable("reservationId") Long reservationId);

}