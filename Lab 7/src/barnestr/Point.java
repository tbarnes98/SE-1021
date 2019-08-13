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
 * This class represents a Point extension of the Shape Class
 *
 * @author barnestr
 * @version 2.0
 */
public class Point extends Shape {

    /**
     * Constructor - creates the Point with passed in parameters
     *
     * @param x     x-coordinate of the Point
     * @param y     y-coordinate of the Point
     * @param color the JavaFX color of the point
     */
    public Point(double x, double y, Color color) {
        super(x, y, color);

    }

    /**
     * Draws the Point in the current WinPlotterFX window
     *
     * @param plotter the current WinPlotterFX window being used
     */
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.drawPoint(x, y);
    }
}
