package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist,
            ArrayList<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void addtrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        } else {
            System.out.println(track + " is already in the list of tracks.");
        }
    }

    public void removetrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            System.out.println(track + " is not in the list of tracks.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
}
