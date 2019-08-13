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
 * This class represents a circle extension of the Shape Class
 *
 * @author barnestr
 * @version 2.0
 */
public class Circle extends Shape {

    protected double radius;

    /**
     * Constructor - creates the circle with the passed in parameters
     *
     * @param x      x-coordinate location of the circle
     * @param y      y-coordinate location of the circle
     * @param radius radius of the circle
     * @param color  the JavaFX color of the outline of the circle
     */
    public Circle(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    /**
     * Draws the circle in the WinPlotterFX window
     *
     * @param plotter the current WinPlotterFX being used
     */
    public void draw(WinPlotterFX plotter) {
        final int CIRCLE_DEGREES = 360;
        setPenColor(plotter);
        for (int i = 0; i < CIRCLE_DEGREES; i++) {
            plotter.moveTo(x + radius * Math.cos(Math.toRadians(i)),
                    y + radius * Math.sin(Math.toRadians(i)));
            plotter.drawTo(x + radius * Math.cos(Math.toRadians(i + 1)),
                    y + radius * Math.sin(Math.toRadians(i + 1)));
        }
    }
}
