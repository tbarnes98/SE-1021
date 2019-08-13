/*
 * SE1021
 * Spring 2018
 * Lab 3 - Interfaces
 * Name: Trevor Barnes
 * Created: 3/20/18
 */
package barnestr;

/**
 * The interface for any class that implements the methods getCost, getName, getWeight,
 * and printBillOfMaterials
 */
public interface Part {
    double getCost();

    String getName();

    double getWeight();

    void printBillOfMaterials();


}
