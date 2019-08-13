/*
 * SE1021
 * Spring 2018
 * Lab 2
 * Name: Trevor Barnes
 * Created: 3/19/2018
 */
package barnestr;

import java.util.Scanner;

/**
 * A type of Reference
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Book extends Reference {
    private String publisher;

    /**
     * This constructor sets up an Book with an author, title, publication year, and publisher.
     *
     * @param author          author of book
     * @param title           title of book
     * @param publicationYear book's year of publication
     * @param publisher       publisher of book
     */
    public Book(String author, String title, int publicationYear, String publisher) {
        super(author, title, publicationYear);
        this.publisher = publisher;
    }

    /**
     * Provides all of the listed properties of the book
     *
     * @return String with info
     */
    @Override
    public String toString() {
        return "@BOOK { \"" + getMyUniqueID() + "\",\n" +
                "author = \"" + getAuthor() + "\",\n" +
                "title = \"" + getTitle() + "\",\n" +
                "publisher = \"" + getPublisher() + "\",\n" +
                "year = \"" + getPublicationYear() + "\"\n" +
                "}\n";
    }

    /**
     * Calls the parent class' promptForUpdate method and asks for updated publisher value
     *
     * @param in Scanner input
     */
    @Override
    public void promptForUpdate(Scanner in) {
        super.promptForUpdate(in);
        System.out.println("Enter the updated publisher for the book");
        this.setPublisher(in.nextLine());
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
