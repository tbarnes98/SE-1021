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
 * This class represents a Rectangle extension of the Shape Class
 *
 * @author barnestr
 * @version 2.0
 */
public class Rectangle extends Shape {

    protected double height;
    protected double width;

    /**
     * Constructor - creates the Rectangle with the passed in parameters
     *
     * @param x      x-coordinate location of the Rectangle
     * @param y      y-coordinate location of the  Rectangle
     * @param width  the width of the Rectangle
     * @param height the height of the Rectangle
     * @param color  the JavaFX color of the Rectangle's outline
     */
    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    /**
     * Draws the Rectangle in the current WinPlotterFX window
     *
     * @param plotter the current WinPlotterFX being used
     */
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + height);
        plotter.drawTo(x, y + height);
        plotter.drawTo(x, y);
    }
}
