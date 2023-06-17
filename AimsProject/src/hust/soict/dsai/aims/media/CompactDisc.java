package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist,
            List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }
    public List<Track> getTracks() {
        return tracks;
    }

    public void addtrack(Track track) throws IllegalArgumentException {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        } else {
            throw new IllegalArgumentException(track.getTitle() + " is already in the list of tracks.");
        }
    }

    public void removetrack(Track track) throws NoSuchElementException {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            throw new NoSuchElementException(track.getTitle() + " is not in the list of tracks.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw new PlayerException("Error playing track: " + nextTrack.getTitle(), e);
                }
            }
        } else {
            throw new PlayerException("CD length is non-positive");
        }
    }

    @Override
    public String toString() {
        String tracksInfo = "";
        for (Track track : getTracks()) {
            tracksInfo += track.toString() + "\n";
        }

        return "CD - " +
                getTitle() + " - " +
                getCategory() + " - " +
                getDirector() + " - " +
                getLength() + " minutes - " +
                getCost() + " $" +
                "\nTracks:\n" +
                tracksInfo;
    }
}