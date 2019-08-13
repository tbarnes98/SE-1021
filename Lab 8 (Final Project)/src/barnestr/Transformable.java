/*
 * SE1021
 * Spring 2018
 * Lab 8 - Final Project
 * Name: Trevor Barnes
 * Created: 5/2/18
 */
package barnestr;


import javafx.scene.paint.Color;

/**
 * An interface to transform a pixel at the given coordinates with the given color
 * @author Trevor Barnes
 * @version 1.0
 */
public interface Transformable {

    Color transform(int x,int y, Color color);


}
