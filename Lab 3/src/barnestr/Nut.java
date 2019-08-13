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
 * Nut implementation of the Part Interface
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Nut implements Part {

    /**
     * The weight multiplier for a nut
     */
    public static final double LBS_MULTIPLIER = 0.01;
    /**
     * The US dollar cost multiplier for a nut
     */
    public static final double USD_MULTIPLIER = 0.50;
    private double diameterInches;

    /**
     * Initializes the variable of a nut with a double value passed in
     *
     * @param diameterInches diameter in inches of a nut
     */
    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
    }

    /**
     * Calculates the cost of the nut based on its size and US dollar multiplier
     *
     * @return calculated cost as a double
     */
    @Override
    public double getCost() {
        return USD_MULTIPLIER * diameterInches;
    }

    /**
     * Returns the formal size prefixed name for a nut
     *
     * @return name as a String
     */
    @Override
    public String getName() {
        return diameterInches + " inch nut";
    }

    /**
     * Calculates the weight of the nut based on its size and LBS multiplier
     *
     * @return calculated weight as a double
     */
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * (diameterInches * diameterInches);
    }

    /**
     * Gathers all the information for the nut and prints it in a formal bill format
     */
    @Override
    public void printBillOfMaterials() {
        final DecimalFormat costFormat = new DecimalFormat("$#0.00");
        final DecimalFormat weightFormat = new DecimalFormat("#.### lbs");
        System.out.println("==========================\n" +
                getName() + "\n" +
                "==========================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Cost: " + costFormat.format(getCost()) + "\n" +
                "Weight: " + weightFormat.format(getWeight()) + "\n");
    }
}