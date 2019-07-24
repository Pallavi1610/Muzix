package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public void deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track getTrackById(int id);


    public Track UpdateTrack(Track track);
    public List<Track> getTrackByName(String name);
}
