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
 * This class represents a LabeledRectangle extension of the Rectangle Class
 *
 * @author barnestr
 * @version 2.0
 */
public class LabeledRectangle extends Rectangle {

    String name;

    /**
     * Constructor - creates the LabeledRectangle with the passed in parameters
     *
     * @param x      x-coordinate location of the LabeledRectangle
     * @param y      y-coordinate location of the  LabeledRectangle
     * @param width  the width of the LabeledRectangle
     * @param height the height of the LabeledRectangle
     * @param color  the JavaFX color of the LabeledRectangle's outline
     * @param name   the label placed on the LabeledRectangle as text
     */
    public LabeledRectangle(double x, double y, double width, double height, Color color,
                            String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    /**
     * Draws the LabeledRectangle in the current WinPlotterFX window
     *
     * @param plotter the current WinPlotterFX being used
     */
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(x + width / 2, y + height / 2, name);
    }
}
