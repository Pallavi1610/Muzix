package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TracKController {
    private TrackService trackService;

    public TracKController(TrackService trackService)
    {
        this.trackService = trackService;
    }
    //Add Track
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity=null;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        } catch (TrackAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
    //Retrieve all the tracks
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    //Retrieve Track based on specific ID
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable(value = "id") Integer id) throws TrackNotFoundException
    {
        ResponseEntity responseEntity=null;
        Track getTrack=trackService.getTrackbyId(id);
        responseEntity=  new ResponseEntity<Track>(getTrack,HttpStatus.OK);
        return responseEntity  
    }
    
    //Delete Track based on specific ID
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable(value="id") Integer id) throws TrackNotFoundException 
    {
        ResponseEntity responseEntity=null;
        trackService.deleteTrack(id);
        responseEntity=new ResponseEntity<String>("Deleted",HttpStatus.OK);
        return responseEntity;
    }
    //Update Track 
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
		ResponseEntity responseEntity=null;
		trackService.updateTrack(track);
		responseEntity = new ResponseEntity<Track>(track, HttpStatus.OK);
		return responseEntity;
       
   //Retrieve Track Based on Track name
   @GetMapping("tracks/{name}")
   @Query("from Track where name=?1")
    public ResponseEntity<?> getAllTracksByName(@PathVariable(value="name") String name)
    {
        ResponseEntity responseEntity=null;
        try {
            responseEntity=new ResponseEntity<List<Track>>(trackService.getTrackByName(name),HttpStatus.OK);
        }
        catch (TrackNotFoundException e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
       return responseEntity;
    }
}
