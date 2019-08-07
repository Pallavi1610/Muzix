package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public void deleteTrack(int id) {
        trackRepository.deleteById(id);

    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) {
        Track track=trackRepository.findById(id).get();
        return track;
    }

    @Override
    public Track updateTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }
}
