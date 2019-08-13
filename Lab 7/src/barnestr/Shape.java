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
 * This class represents a generic graphical shape
 *
 * @author barnestr
 * @version 2.0
 */
public abstract class Shape {

    private Color color;
    protected double x;
    protected double y;

    /**
     * Constructor - initializes Shape attributes
     *
     * @param x     x-coordinate of the shape
     * @param y     y-coordinate of the shape
     * @param color the outlined JavaFX color of the shape
     */
    public Shape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Sets the pen color on the WinPlotter object to match the current outline color of the shape
     *
     * @param plotter the current WinPlotterFX being used
     */
    public void setPenColor(WinPlotterFX plotter) {
        plotter.setPenColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public abstract void draw(WinPlotterFX plotter);

    /**
     * Sets the JavaFX color of the shape
     *
     * @param color the JavaFX color of the shape outline
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
