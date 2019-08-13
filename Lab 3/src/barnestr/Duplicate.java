/*
 * SE1021
 * Spring 2018
 * Lab 3 - Interfaces
 * Name: Trevor Barnes
 * Created: 3/20/18
 */
package barnestr;

import java.text.DecimalFormat;

/**
 * Duplicate implementation of the Part Interface. Represents multiple identical parts
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Duplicate implements Part {

    /**
     * The discount reduction when there are 5-9 duplicates
     */
    public static final double REDUCTION_FACTOR1 = 0.95;
    /**
     * The discount reduction when there are 10 or more duplicates
     */
    public static final double REDUCTION_FACTOR2 = 0.90;
    /**
     * The amount of duplicates required to give a 5% discount
     */
    public static final int USD_THRESHOLD1 = 5;
    /**
     * The amount of duplicates required to give a 10% discount
     */
    public static final int USD_THRESHOLD2 = 10;
    private final DecimalFormat costFormat = new DecimalFormat("$#0.00");
    private final DecimalFormat weightFormat = new DecimalFormat("#.### lbs");
    private Part identicalPart;
    private int numDuplicates;

    /**
     * Initializes the variables of a Duplicate with a type and amount and  passed in
     *
     * @param identicalPart the type of part that has duplicates
     * @param numDuplicates the amount of duplicate parts
     */
    public Duplicate(Part identicalPart, int numDuplicates) {
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

    /**
     * Calculates the cost of the combined duplicates based on the amount of duplicates
     *
     * @return calculated cost as double
     */
    @Override
    public double getCost() {
        if (numDuplicates < USD_THRESHOLD1) {
            return identicalPart.getCost() * numDuplicates;
        } else if (numDuplicates < USD_THRESHOLD2) {
            return identicalPart.getCost() * numDuplicates * REDUCTION_FACTOR1;
        } else {
            return identicalPart.getCost() * numDuplicates * REDUCTION_FACTOR2;
        }
    }

    /**
     * Returns the formal amount prefixed name for the identical parts
     *
     * @return name as a String
     */
    @Override
    public String getName() {
        return numDuplicates + " " + identicalPart.getName() + "s";
    }

    /**
     * Calculates the weight of the combined duplicates
     *
     * @return calculated weight as a double
     */
    @Override
    public double getWeight() {
        return identicalPart.getWeight() * numDuplicates;
    }

    /**
     * Gathers all the information for the Duplicate and prints it in a formal bill format as well
     * as the individual part bill of materials
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================\n" +
                numDuplicates + " " + identicalPart.getName() + "s\n" +
                "==========================\n" +
                "Duplicate part: " + identicalPart.getName() + "\n" +
                "Copies: " + numDuplicates + "\n" +
                "Individual cost: " + costFormat.format(identicalPart.getCost()) + "\n" +
                "Individual weight: " + weightFormat.format(identicalPart.getWeight()) + "\n" +
                "\n" +
                "Total cost: " + costFormat.format(getCost()) + "\n" +
                "Total weight: " + weightFormat.format(getWeight()) + "\n");
        identicalPart.printBillOfMaterials();


    }
}
