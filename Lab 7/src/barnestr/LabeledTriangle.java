/*
 * SE1021
 * Spring 2018
 * Lab 4 - Inheritance
 * Name: Trevor Barnes
 * Created: 3/28/18
 */

package barnestr;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * This class represents a LabeledTriangle extension of the Triangle Class
 *
 * @author barnestr
 * @version 2.0
 */
public class LabeledTriangle extends Triangle {

    String name;

    /**
     * Constructor - creates the LabeledTriangle with the passed in parameters
     *
     * @param x      x-coordinate location of the LabeledTriangle
     * @param y      y-coordinate location of the  LabeledTriangle
     * @param base   the bottom side length of the LabeledTriangle
     * @param height the height of the LabeledTriangle
     * @param color  the JavaFX color of the LabeledTriangle's outline
     * @param name   the label placed on the LabeledTriangle as text
     */
    public LabeledTriangle(double x, double y, double base, double height, Color color,
                           String name) {
        super(x, y, base, height, color);
        this.name = name;
    }

    /**
     * Draws the LabeledTriangle in the current WinPlotterFX window
     *
     * @param plotter the current WinPlotterFX being used
     */
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(x + base / 3, y + height / 4, name);
    }
}
