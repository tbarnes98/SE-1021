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
 * This class represents a Triangle extension of the Shape Class
 *
 * @author barnestr
 * @version 2.0
 */
public class Triangle extends Shape {

    protected double base;
    protected double height;

    /**
     * Constructor - creates the Triangle with the passed in parameters
     *
     * @param x      x-coordinate location of the Triangle
     * @param y      y-coordinate location of the  Triangle
     * @param base   the bottom side length of the Triangle
     * @param height the height of the Triangle
     * @param color  the JavaFX color of the Triangle's outline
     */
    public Triangle(double x, double y, double base, double height, Color color) {
        super(x, y, color);
        this.base = base;
        this.height = height;
    }

    /**
     * Draws the Triangle in the current WinPlotterFX window
     *
     * @param plotter the current WinPlotterFX being used
     */
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x + base / 2, y + height);
        plotter.drawTo(x, y);
    }
}
