package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();
    
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added " + media.getTitle() + " to the cart.");
        } else {
            System.out.println("The cart is full!");
        }
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
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

    public List<Media> getItemsOrdered() {
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