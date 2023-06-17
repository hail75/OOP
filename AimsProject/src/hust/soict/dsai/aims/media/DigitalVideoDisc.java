package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        } else {
            throw new PlayerException("DVD length is non-positive");
        }
    }

    @Override
    public String toString() {
        return "DVD - " +
                getTitle() + " - " +
                getCategory() + " - " +
                getDirector() + " - " +
                getLength() + ": " +
                getCost() + " $";
    }
}