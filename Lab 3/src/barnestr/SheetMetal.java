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
 * Sheet Metal implementation of the Part Interface
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class SheetMetal implements Part {

    /**
     * The weight multiplier for sheet metal
     */
    public static final double LBS_MULTIPLIER = 0.1;
    /**
     * The US dollar cost multiplier for sheet metal
     */
    public static final double USD_MULTIPLIER = 0.50;
    private double lengthInches;
    private double thicknessInches;
    private double widthInches;

    /**
     * Initializes the variables of a piece of sheet metal with three double values passed in
     *
     * @param lengthInches    length in inches of a piece of sheet metal
     * @param widthInches     width in inches of a piece of sheet metal
     * @param thicknessInches thickness in inches of a piece of sheet metal
     */
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }

    /**
     * Calculates the cost of the sheet metal based on its size and US dollar multiplier
     *
     * @return calculated cost as a double
     */
    @Override
    public double getCost() {
        return USD_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    /**
     * Returns the formal size prefixed name for a piece of sheet metal
     *
     * @return name as a String
     */
    @Override
    public String getName() {
        return lengthInches + "x" + widthInches + "x" + thicknessInches + " sheet";
    }

    /**
     * Calculates the weight of the sheet metal based on its size and LBS multiplier
     *
     * @return calculated weight as a double
     */
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    /**
     * Gathers all the information for the sheet metal and prints it in a formal bill format
     */
    @Override
    public void printBillOfMaterials() {
        final DecimalFormat costFormat = new DecimalFormat("$#0.00");
        final DecimalFormat weightFormat = new DecimalFormat("#.### lbs");
        System.out.println("==========================\n" +
                getName() + "\n" +
                "==========================\n" +
                "Length: " + lengthInches + " inches\n" +
                "Width: " + widthInches + " inches\n" +
                "Thickness: " + thicknessInches + " inches\n" +
                "Cost: " + costFormat.format(getCost()) + "\n" +
                "Weight: " + weightFormat.format(getWeight()) + "\n");
    }
}
