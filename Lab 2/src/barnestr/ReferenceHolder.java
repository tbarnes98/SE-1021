/*
 * SE1021
 * Spring 2018
 * Lab 2
 * Name: Trevor Barnes
 * Created: 3/19/2018
 */
package barnestr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates an ArrayList that holds references of different types
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class ReferenceHolder {
    private ArrayList<Reference> references = new ArrayList();

    public ReferenceHolder() {

    }

    public void addReference(Book book) {
        references.add(book);
    }

    public void addReference(Article article) {
        references.add(article);
    }

    /**
     * Calls the prompt for update methods for a specific type of reference, given the uniqueID.
     *
     * @param uniqueID Individual ID for each reference
     * @param in       Scanner input
     */
    public void updateReference(String uniqueID, Scanner in) {
        for (Reference ref : references) {
            if (ref.getMyUniqueID().equals(uniqueID)) {
                if (ref instanceof Book) {
                    ref = (Book) ref;
                    ref.promptForUpdate(in);
                } else {
                    ref = (Article) ref;
                    ref.promptForUpdate(in);
                }
            }
        }
    }

    /**
     * Creates a string of references in the references arrayList
     *
     * @return a string of references
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Reference ref : references) {
            stringBuilder.append(ref.toString());
        }
        return stringBuilder.toString();
    }

}
