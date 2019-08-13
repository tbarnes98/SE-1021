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
 * The parent class that is inherited by either a book or article
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Reference {
    private static int instanceCount = 0;
    private String author;
    private String myUniqueID;
    private int publicationYear;
    String title;

    /**
     * This constructor sets up a reference with an author, title, and publication year passed in.
     *
     * @param author          author of reference
     * @param title           title of reference
     * @param publicationYear reference's year of publication
     */
    public Reference(String author, String title, int publicationYear) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.myUniqueID = "REF" + instanceCount;
        instanceCount++;
    }

    /**
     * Asks for updated values for the author, title, and copyright year.
     *
     * @param in scanner input
     */
    public void promptForUpdate(Scanner in) {

        System.out.println("Enter the updated author of the reference");
        this.setAuthor(in.nextLine());

        System.out.println("Enter the updated title of the reference");
        this.setTitle(in.nextLine());

        System.out.println("Enter the updated copyright year for the reference.");
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Enter the updated copyright year for the reference.");
        }
        this.setPublicationYear(in.nextInt());
        in.nextLine();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getAuthor() {
        return author;
    }

    public String getMyUniqueID() {
        return myUniqueID;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
