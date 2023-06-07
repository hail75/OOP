package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist,
            ArrayList<Track> tracks) {
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

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + getArtist());
        System.out.println("Number of tracks: " + getTracks().size());
        
        for (Track track : getTracks()) {
            track.play();
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