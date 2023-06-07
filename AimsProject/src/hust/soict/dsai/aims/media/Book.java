package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;  
    
    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
            System.out.println("Added author: " + author);
        } else {
            System.out.println(author + " is already in the list of authors.");
        }
    }

    public void removeAuthor(String author) {
        if (authors.contains(author)) {
            authors.remove(author);
            System.out.println("Removed author: " + author);
        } else {
            System.out.println(author + " is not in the list of authors.");
        }
    }    
}
