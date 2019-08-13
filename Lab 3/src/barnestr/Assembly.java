/*
 * SE1021
 * Spring 2018
 * Lab 3 - Interfaces
 * Name: Trevor Barnes
 * Created: 3/20/18
 */
package barnestr;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Assembly implementation of the Part Interface. Represents a collection of parts and duplicates
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Assembly implements Part {

    private final String name;
    private ArrayList<Part> subParts = new ArrayList<>();
    /**
     * The additional fee charged with sub parts
     */
    public static final double USD_PER_SUB_PART = 0.25;
    private final DecimalFormat costFormat = new DecimalFormat("$#0.00");
    private final DecimalFormat weightFormat = new DecimalFormat("#.### lbs");

    /**
     * Initializes the variables of an Assembly with a name passed in
     *
     * @param name name of the assembly
     */
    public Assembly(String name) {
        this.name = name;
    }

    /**
     * Adds a part to the subParts ArrayList
     *
     * @param part Part to be added
     */
    public void addPart(Part part) {
        subParts.add(part);
    }

    /**
     * Calculates the cost of all the parts combined in the subParts ArrayList
     *
     * @return cost as a double
     */
    @Override
    public double getCost() {
        double cost = 0.0;
        for (int i = 0; i < subParts.size(); i++) {
            cost += subParts.get(i).getCost() + USD_PER_SUB_PART;
        }
        return cost;
    }

    /**
     * Returns the name of the Assembly
     *
     * @return name as a String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Calculates the cost of all the parts combined in the subParts ArrayList
     *
     * @return weight as a double
     */
    @Override
    public double getWeight() {
        double weight = 0.0;
        for (int i = 0; i < subParts.size(); i++) {
            weight += subParts.get(i).getWeight();
        }
        return weight;
    }

    /**
     * Gathers all the information for the Assembly and prints it in a formal bill format as well
     * as the total cost/weight and the bill of materials for each part.
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================\n" +
                getName() + "\n" +
                "==========================\n");
        for (int i = 0; i < subParts.size(); i++) {
            System.out.println("Part: " + subParts.get(i).getName() + "\n" +
                    "Cost: " + costFormat.format(subParts.get(i).getCost()) + "\n" +
                    "Weight: " + weightFormat.format(subParts.get(i).getWeight()) + "\n"
            );
        }
        System.out.println("Total cost: " + costFormat.format(getCost()) + "\n" +
                "Total weight: " + weightFormat.format(getWeight()) + "\n"
        );
        for (int i = 0; i < subParts.size(); i++) {
            if (subParts.get(i) instanceof Duplicate) {
                subParts.get(i).printBillOfMaterials();
            } else {
                subParts.get(i).printBillOfMaterials();
            }
        }
    }
}
