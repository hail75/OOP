package hust.soict.dsai.aims.score;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int count;

    public Store(int maxSize) {
        itemsInStore = new DigitalVideoDisc[maxSize];
        count = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (count < itemsInStore.length) {
            itemsInStore[count] = dvd;
            count++;
            System.out.println("Added " + dvd.getTitle() + " to the store.");
        } else {
            System.out.println("The store is full!");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < count; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < count - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[count - 1] = null;
                count--;
                System.out.println("Removed " + dvd.getTitle() + " from the store.");
                return;
            }
        }
        System.out.println(dvd.getTitle() + " is not in the store.");
    }

    public void print() {
        System.out.println("Items in the Store:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
    }
}
