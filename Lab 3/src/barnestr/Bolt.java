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
 * Bolt implementation of the Part Interface
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Bolt implements Part {

    /**
     * The weight multiplier for bolt
     */
    public static final double LBS_MULTIPLIER = 0.05;
    /**
     * The US dollar cost multiplier for bolt
     */
    public static final double USD_MULTIPLIER = 1.00;
    private double diameterInches;
    private double lengthInches;

    /**
     * Initializes the variable of a bolt with two double values passed in
     *
     * @param diameterInches diameter in inches of a bolt
     * @param lengthInches   length in inches of a bolt
     */
    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    /**
     * Calculates the cost of the bolt based on its size and US dollar multiplier
     *
     * @return calculated cost as a double
     */
    @Override
    public double getCost() {
        return USD_MULTIPLIER * diameterInches * lengthInches;
    }

    /**
     * Returns the formal size prefixed name for a bolt
     *
     * @return name as a String
     */
    @Override
    public String getName() {
        return diameterInches + "x" + lengthInches + " bolt";
    }

    /**
     * Calculates the weight of the bolt based on its size and LBS multiplier
     *
     * @return calculated weight as a double
     */
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * (diameterInches * diameterInches) * lengthInches;
    }

    /**
     * Gathers all the information for the bolt and prints it in a formal bill format
     */
    @Override
    public void printBillOfMaterials() {
        final DecimalFormat costFormat = new DecimalFormat("$#0.00");
        final DecimalFormat weightFormat = new DecimalFormat("#.### lbs");
        System.out.println("==========================\n" +
                getName() + "\n" +
                "==========================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Length: " + lengthInches + " inches\n" +
                "Cost: " + costFormat.format(getCost()) + "\n" +
                "Weight: " + weightFormat.format(getWeight()) + "\n");
    }
}
