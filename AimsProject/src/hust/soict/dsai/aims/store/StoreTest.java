package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(5);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD 1", "Category 1", "Director 1", 90, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD 2", "Category 2", "Director 2", 120, 29.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD 3", "Category 3", "Director 3", 105, 24.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.print();

        store.removeDVD(dvd2);

        store.print();
    }
}
