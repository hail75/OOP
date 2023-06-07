package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added " + media.getTitle() + " to the store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the store.");
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }

    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}