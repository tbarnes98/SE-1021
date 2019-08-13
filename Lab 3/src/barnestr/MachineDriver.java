/*
 * SE1021
 * Spring 2018
 * Lab 3 - Interfaces
 * Name: Trevor Barnes
 * Created: 3/20/18
 */
package barnestr;

import java.util.Scanner;

public class MachineDriver {
    /**
     * A simple example driver class for the Bill of Materials generator lab.
     *
     * This example describes the materials needed to build a cube by bolting
     * together six pieces of sheet metal.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command = solicitCommand(in);
        while(!command.equals("quit")) {
            if(command.equals("fan")) {
                buildFan();
            } else if(command.equals("cube")) {
                buildCube();
            } else if(command.equals("shovel")) {
                buildShovel();
            } else {
                System.out.println("Unrecognized command: "+command);
            }
            command = solicitCommand(in);
        }
    }

    /**
     * Prints out the main menu and allows the user to choose an
     * option from that menu
     * @param in A scanner which should point to System.in
     * @return The keyword the user typed
     */
    private static String solicitCommand(Scanner in) {
        System.out.println("Please enter an option:");
        System.out.println(" fan - Build a five-bladed fan");
        System.out.println(" cube - Build a cube");
        System.out.println(" shovel - Build a shovel");
        System.out.println(" quit - exit the program");
        return in.next();
    }

    /**
     * Builds a fan consisting of five blades.
     * See example output near the start of the lab.
     */
    private static void buildFan() {
        System.out.println("Building a fan");
        SheetMetal blade = new SheetMetal(8,6,0.0625);
        Duplicate fan = new Duplicate(blade,5);
        fan.printBillOfMaterials();
    }

    /**
     * Builds a shovel consisting of a handle
     * and a blade, both made out of sheet metal.
     * (The handle is rolled into a tube, though
     *  extrusion would probably work better.)
     */
    private static void buildShovel() {
        System.out.println("Building a shovel");
        System.out.println("TODO: Uncomment to enable example");
        SheetMetal handle = new SheetMetal(30,3,0.125);
        SheetMetal blade = new SheetMetal(10,8,0.25);
        Bolt bolt = new Bolt(0.125, 0.5);
        Assembly shovel = new Assembly("Shovel");
        shovel.addPart(handle);
        shovel.addPart(blade);
        shovel.addPart(bolt);

        shovel.printBillOfMaterials();
    }

    /**
     * Builds a cube. The cube consists of six sides,
     * bolted together.
     *
     * See the diagram in the lab handout which shows
     * how the different parts belong to one another
     */
    private static void buildCube() {
        System.out.println("Building a cube");
        //System.out.println("TODO: Uncomment to enable example");
        Bolt bolt = new Bolt(0.25,2);
        Nut nut = new Nut(0.25);
        SheetMetal sheet = new SheetMetal(12,12,0.25);

        Duplicate sides  = new Duplicate(sheet,6);

        Assembly nutBoltCombo = new Assembly("Nut-Bolt Pair");
        nutBoltCombo.addPart(bolt);
        nutBoltCombo.addPart(nut);

        Duplicate nutsAndBolts = new Duplicate(nutBoltCombo,36);

        Assembly cube = new Assembly("Cube");
        cube.addPart(nutsAndBolts);
        cube.addPart(sides);

        cube.printBillOfMaterials();
    }

}