
package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack (Track track;

    public Track getTrackById (int id);

    public Track deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track updateTrack(int id,String comment);
    List<Track> getByTrackName(String name);
    List<Track> getTrackByNameSortByName(String name);


}
