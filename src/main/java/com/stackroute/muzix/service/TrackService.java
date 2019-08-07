package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import java.util.List;

public interface TrackService {
    
    Track saveTrack(Track track) throws TrackAlreadyExistsException,Exception;
    void deleteTrack(int id) throws TrackNotFoundException,exception;
    List<Track> getAllTracks() throws Exception;
    Track getTrackById(int id) throws TrackNotFoundException,Exception;
    Track updateTrack(Track track) throws TrackNotFoundException,Exception;
    List<Track> getTrackByName(String name) throws TrackNotFoundException,Exception;
}
