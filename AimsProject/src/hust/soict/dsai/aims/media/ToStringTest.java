package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class ToStringTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>(); 
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "DVD Title 1", "DVD Category", 9.99f, 120, "DVD Director 1");
        mediae.add(dvd);

        for (Media m: mediae) {
            System.out.println(m.toString());
        }
    }
}