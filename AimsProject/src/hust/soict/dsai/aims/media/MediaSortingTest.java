package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaSortingTest {
    public static void main(String[] args) {
        List<Media> collection = new ArrayList<>();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "DVD Title 1", "DVD Category", 9.99f, 120, "DVD Director 1");
        collection.add(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "DVD Title 2", "DVD Category", 8.99f, 90, "DVD Director 2");
        collection.add(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "DVD Title 3", "DVD Category", 7.99f, 100, "DVD Director 3");
        collection.add(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "DVD Title 4", "DVD Category", 6.99f, 80, "DVD Director 4");
        collection.add(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "DVD Title 5", "DVD Category", 5.99f, 110, "DVD Director 5");
        collection.add(dvd5);

        Collections.sort(collection, new MediaComparatorByCostTitle());
        
        for (Media media : collection) {
            System.out.println(media.toString());
        }
    }
}