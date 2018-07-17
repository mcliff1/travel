package com.cliffconsulting.travel.api;

import com.cliffconsulting.travel.model.ModelApiResponse;
import com.cliffconsulting.travel.model.Room;
import com.cliffconsulting.travel.model.RoomQuery;
import com.cliffconsulting.travel.service.RoomService;
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

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

@CrossOrigin
@Controller
public class RoomApiController implements RoomApi {

    @Autowired
    RoomService roomService;

    private static final Logger log = LoggerFactory.getLogger(RoomApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public RoomApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Room> addRoom(@ApiParam(value = "Room object that needs to be added" ,required=true )  @Valid @RequestBody Room body) {
        Room room = roomService.addRoom(body);
        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteRoom(@ApiParam(value = "Room id to delete",required=true) @PathVariable("roomId") Long roomId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        if (!roomService.existsById(roomId)) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        roomService.deleteRoom(roomId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Room>> findRoom(@ApiParam(value = "Room object that needs to be added" ,required=true )  @Valid @RequestBody RoomQuery body) {
        List<Room> roomList = roomService.findRoom(body);

        return new ResponseEntity<List<Room>>(roomList, HttpStatus.OK);
    }

    public ResponseEntity<Room> getRoomById(@ApiParam(value = "ID of room to return",required=true) @PathVariable("roomId") Long roomId) {
        Room room = roomService.getRoomById(roomId);
        if (room == null) { return new ResponseEntity<Room>(HttpStatus.NOT_FOUND); }
        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateRoom(@ApiParam(value = "Room object that needs to be updated" ,required=true )  @Valid @RequestBody Room body) {
        final String METHOD = "updateRoom():";
        log.debug(METHOD + "begin");
        //if (!roomService.existsById(roomId)) {
        //    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        //}

        try {
            roomService.updateRoom(body);
            return new ResponseEntity<Void>(HttpStatus.OK);

            
        } catch (ApiException e) {
        	return new ResponseEntity<Void>(HttpStatus.valueOf(e.getCode()));
        } catch (Exception e) {
        	log.error(METHOD, e);
        	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    
    
    
    
    public ResponseEntity<ModelApiResponse> uploadFile(@ApiParam(value = "ID of room to update",required=true) @PathVariable("roomId") Long roomId,@ApiParam(value = "Additional data to pass to server") @RequestParam(value="additionalMetadata", required=false)  String additionalMetadata,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile file) {
    	final String METHOD = "uploadFile():";
    	log.error(METHOD + "begin - not implemented");
    	
    	// ToDO
    	//   multipart.getContentType;  getInputStream, getOriginalFilename
    	//  can I save this to H2 ?
    	// save as blob with content-Type?? and size
    	
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
