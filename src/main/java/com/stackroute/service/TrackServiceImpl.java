package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track savedTrack = trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException{
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
            throw new TrackNotFoundException("Track Does Not Exist");
        }
        Track track = trackRepository.findById(id).get();
        return track;
    }

    @Override
    public Track deleteTrack(Track track) throws TrackNotFoundException {
       return trackRepository.delete(getTrackById(track.getId()));  
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getId())) {
           Track updateTrack = trackRepository.save(track);
            return updateTrack;
        } else {

            throw new TrackNotFoundException("ID doesnt exist");
        }
    }
}
