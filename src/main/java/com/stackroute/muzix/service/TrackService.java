package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import java.util.List;

public interface TrackService {
    Track saveTrack(Track track);
    void deleteTrack(int id);
    List<Track> getAllTracks();
    Track getTrackById(int id);
    Track UpdateTrack(Track track);
}
