/*
 * SE1021
 * Spring 2018
 * Lab 7 - Shapes Revisited
 * Name: Trevor Barnes
 * Created: 4/25/18
 */
package barnestr;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class loads a WinPlotter window and draws shapes that are read from a text file into said
 * winPlotterFX window
 *
 * @author Trevor Barnes
 * @version 2.0
 */
public class ShapeLoaderApp extends Application {

    private Scanner in;
    private WinPlotterFX winPlotterFX;
    private List<Shape> shapes;

    /**
     * This constructor initializes the shapes ArrayList and winPlotterFX WinPlotterFX.
     */
    public ShapeLoaderApp() {
        shapes = new ArrayList();
        winPlotterFX = new WinPlotterFX();
    }

    /**
     * Reads the shapes described in the given text file.
     */
    private void readShapes() {
        try {
            in.nextLine();
            while (in.hasNextLine()) {
                shapes.add(parseShape(in.nextLine()));
            }
        } catch (InputMismatchException e) {
            System.out.println("line is null");
        }
    }

    /**
     * Draws, in the winPlotterFX, the shapes read from the text file.
     */
    private void drawShapes() {
        for (Shape shape : shapes) {
            shape.draw(winPlotterFX);
        }
    }

    /**
     * Creates a shape from the line String that was passed in.
     *
     * @param line of the described shape
     * @return a type of Shape with the given attributes
     */
    private Shape parseShape(String line) {
        Scanner lineScanner = new Scanner(line);
        String type = lineScanner.next();
        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();
        String colorString = lineScanner.next();
        int radius;
        int width;
        int height;
        StringBuilder label = new StringBuilder();

        switch (type) {
            case "P:": {
                return new Point(x, y, stringToColor(colorString));
            }
            case "C:": {
                radius = lineScanner.nextInt();
                return new Circle(x, y, radius, stringToColor(colorString));
            }
            case "T:": {
                width = lineScanner.nextInt();
                height = lineScanner.nextInt();
                return new Triangle(x, y, width, height, stringToColor(colorString));
            }
            case "R:": {
                width = lineScanner.nextInt();
                height = lineScanner.nextInt();
                return new Rectangle(x, y, width, height, stringToColor(colorString));
            }
            case "LT:": {
                width = lineScanner.nextInt();
                height = lineScanner.nextInt();
                do {
                    label.append(lineScanner.next());
                    if (lineScanner.hasNext()) {
                        label.append(" ");
                    }
                } while (lineScanner.hasNext());
                return new LabeledTriangle(x, y, width, height, stringToColor(colorString), label.toString());
            }
            default: {
                width = lineScanner.nextInt();
                height = lineScanner.nextInt();
                do {
                    label.append(lineScanner.next());
                    if (lineScanner.hasNext()) {
                        label.append(" ");
                    }
                } while (lineScanner.hasNext());
                return new LabeledRectangle(x, y, width, height, stringToColor(colorString), label.toString());
            }
        }
    }

    private Color stringToColor(String hex) throws InputMismatchException {
        return Color.web(hex);
    }

    /**
     * Starts the primary stage and winPlotterFX after defining the winPlotterFX window.
     *
     * @param primaryStage the base stage
     * @throws IOException due to IO behavior
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        in = new Scanner(new File("sampleInput.txt"));
        //try {
        winPlotterFX.setWindowTitle(in.nextLine());
        winPlotterFX.setWindowSize(Double.parseDouble(in.next()), Double.parseDouble(in.next()));
        in.nextLine();
        Color background = stringToColor(in.next());
        winPlotterFX.setBackgroundColor(background.getRed(), background.getGreen(), background.getBlue());
        readShapes();
        drawShapes();
        winPlotterFX.showPlotter();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
