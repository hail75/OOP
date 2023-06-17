package hust.soict.dsai.aims;

import java.util.Collections;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        try {
            showMenu();
        } catch (PlayerException e) {
            JOptionPane.showMessageDialog(null, "PlayerException: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (LimitExceededException e) {
            JOptionPane.showMessageDialog(null, "LimitExceededException: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void showMenu() throws LimitExceededException,PlayerException {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0 - 1 - 2 - 3");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewStore(scanner);
                break;
            case 2:
                viewStore(scanner);
                break;
            case 3:
                seeCurrentCart(scanner);
                break;
            case 0:
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                showMenu();
                break;
        }
    }

    public static void viewStore(Scanner scanner) throws LimitExceededException, PlayerException {
        store.getItemsInStore();
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0 - 1 - 2 - 3 - 4");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                seeMediaDetails(scanner);
                break;
            case 2:
                addMediaToCart(scanner);
                break;
            case 3:
                playMedia(scanner);
                break;
            case 4:
                seeCurrentCart(scanner);
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                viewStore(scanner);
                break;
        }
    }

    public static void seeMediaDetails(Scanner scanner) throws LimitExceededException,PlayerException {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media == null) {
            System.out.println("Media not found!");
        } else {
            System.out.println(media.toString());
            mediaDetailsMenu(scanner, media);
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media) throws LimitExceededException, PlayerException {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0 - 1 - 2");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println("Media added to cart successfully!");
                break;
            case 2:
                if (media instanceof CompactDisc) {
                    ((CompactDisc) media).play();
                } else if (media instanceof DigitalVideoDisc) {
                    ((DigitalVideoDisc) media).play();
                }
                break;
            case 0:
                viewStore(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                mediaDetailsMenu(scanner, media);
                break;
        }
    }

    public static void addMediaToCart(Scanner scanner) throws LimitExceededException, PlayerException {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media == null) {
            System.out.println("Media not found!");
        } else {
            cart.addMedia(media);
            System.out.println("Media added to cart successfully!");
        }
    }

    public static void playMedia(Scanner scanner) throws PlayerException {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media == null) {
            System.out.println("Media not found!");
        } else {
            if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            }
        }
    }

    public static void seeCurrentCart(Scanner scanner) throws LimitExceededException, PlayerException {
        cart.printCart();
        cartMenu(scanner);
    }

    public static void cartMenu(Scanner scanner) throws LimitExceededException, PlayerException {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0 - 1 - 2 - 3 - 4 - 5");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                filterMediasInCart(scanner);
                break;
            case 2:
                sortMediasInCart(scanner);
                break;
            case 3:
                removeMediaFromCart(scanner);
                break;
            case 4:
                playMediaFromCart(scanner);
                break;
            case 5:
                placeOrder(scanner);
                break;
            case 0:
                viewStore(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                cartMenu(scanner);
                break;
        }
    }

    public static void filterMediasInCart(Scanner scanner) throws LimitExceededException, PlayerException {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0 - 1 - 2");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter the ID to filter:");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.search(id);
                break;
            case 2:
                System.out.println("Enter the title to filter:");
                String title = scanner.nextLine();
                cart.search(title);
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                filterMediasInCart(scanner);
                break;
        }
    }

    public static void sortMediasInCart(Scanner scanner) throws LimitExceededException, PlayerException {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0 - 1 - 2");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                Collections.sort(cart.getItemsOrdered(), new MediaComparatorByTitleCost());
                break;
            case 2:
                Collections.sort(cart.getItemsOrdered(), new MediaComparatorByCostTitle());
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                sortMediasInCart(scanner);
                break;
        }
    }

    public static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
    
        Media mediaToRemove = null;
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equals(title)) {
                mediaToRemove = media;
                break;
            }
        }
    
        if (mediaToRemove != null) {
            cart.removeMedia(mediaToRemove);
            System.out.println("Removed " + mediaToRemove.getTitle() + " from the cart.");
        } else {
            System.out.println(title + " is not in the cart.");
        }
    }
    

    public static void playMediaFromCart(Scanner scanner) throws LimitExceededException, PlayerException {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();

        Media media = cart.search(title);
        if (media == null) {
            System.out.println("Media not found in the cart!");
        } else {
            if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            }
        }
        cartMenu(scanner);
    }

    public static void placeOrder(Scanner scanner) throws LimitExceededException, PlayerException {
        if (cart.getNumberOfItems() == 0) {
            System.out.println("Cart is empty. Cannot place an order!");
        } else {
            System.out.println("Order placed successfully!");
            cart.clearCart();
        }
        cartMenu(scanner);
    }
}
