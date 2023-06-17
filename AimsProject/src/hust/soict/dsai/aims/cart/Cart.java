package hust.soict.dsai.aims.cart;

import java.util.NoSuchElementException;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added " + media.getTitle() + " to the cart.");
        } else {
            throw new LimitExceededException("The cart is full!");
        }
    }
    
    public void removeMedia(Media media) throws NoSuchElementException {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the cart.");
        } else {
            throw new NoSuchElementException(media.getTitle() + " is not in the cart.");
        }
    }
    
    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public int getNumberOfItems() {
        return itemsOrdered.size();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Media search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public Media search(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart cleared.");
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
    
        for (Media media: itemsOrdered) {
            System.out.println(media.toString());
        }
    
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }
}