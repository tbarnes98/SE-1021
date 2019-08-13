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
public class Article extends Reference {
    private int endingPage;
    private int startingPage;
    private String journal;

    /**
     * This constructor sets up an Article with an author, title, publication year, journal,
     * starting page, and ending page.
     *
     * @param author          author of article
     * @param title           title of article
     * @param publicationYear article's year of publication
     * @param journal         the journal the article is from
     * @param startingPage    the page the article begins
     * @param endingPage      the page the article ends
     */
    public Article(String author, String title, int publicationYear, String journal,
                   int startingPage, int endingPage) {
        super(author, title, publicationYear);
        this.journal = journal;
        if (startingPage < 1) {
            this.startingPage = 1;
        } else {
            this.startingPage = startingPage;
        }
        if (endingPage < startingPage) {
            this.endingPage = startingPage;
        } else {
            this.endingPage = endingPage;
        }

    }

    /**
     * Provides all of the listed properties of the book
     *
     * @return String with info
     */
    @Override
    public String toString() {
        return "@ARTICLE { " + getMyUniqueID() + ",\n" +
                "author = " + getAuthor() + ",\n" +
                "title = " + getTitle() + ",\n" +
                "journal = " + getJournal() + ",\n" +
                "pages = " + getStartingPage() + "-" + getEndingPage() + ",\n" +
                "year = " + getPublicationYear() + "\n" +
                "}\n";
    }

    /**
     * Calls the parent class' promptForUpdate method and asks for updated journal, starting page,
     * and ending page values
     *
     * @param in Scanner input
     */
    @Override
    public void promptForUpdate(Scanner in) {
        super.promptForUpdate(in);
        //journal
        System.out.println("Enter updated journal");
        this.setJournal(in.nextLine());
        //startingPage
        System.out.println("Enter the first page of the article.");
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Enter the first page of the article.");
        }
        this.setStartingPage(in.nextInt());
        in.nextLine();
        //endingPage
        System.out.println("Enter the last page of the article.");
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Enter the last page of the article.");
        }
        this.setEndingPage(in.nextInt());
        in.nextLine();
    }

    public int getEndingPage() {
        return endingPage;
    }

    public void setEndingPage(int endingPage) {
        this.endingPage = endingPage;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public void setStartingPage(int startingPage) {
        this.startingPage = startingPage;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
}
