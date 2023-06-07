package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs;
    private int id;
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(length, title, category, cost, length, director);
        this.id = ++nbDigitalVideoDiscs;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "DVD - " +
                getTitle() + " - " +
                getCategory() + " - " +
                getDirector() + " - " +
                getLength() + ": " +
                getCost() + " $";
    }

    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
}
