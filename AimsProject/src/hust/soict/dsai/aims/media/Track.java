package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;
    
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + getTitle());
        System.out.println("Track length: " + getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Track otherTrack = (Track) obj;
        return this.title.equals(otherTrack.title) && this.length == otherTrack.length;
    }
}