package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import java.util.List;

public interface TrackService {
    Track saveTrack(Track track) throws TrackAlreadyExistsException;
    void deleteTrack(int id) throws TrackNotFoundException;
    List<Track> getAllTracks();
    Track getTrackById(int id) throws TrackNotFoundException;
    Track updateTrack(Track track) throws TrackNotFoundException;
    List<Track> getTrackByName(String name) throws TrackNotFoundException;
}
