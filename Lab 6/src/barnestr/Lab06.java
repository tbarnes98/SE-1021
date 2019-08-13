/*
 * SE1021
 * Spring 2018
 * Lab 6 - Exceptions
 * Name: Trevor Barnes
 * Created: 4/18/18
 */
package barnestr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class for Lab06. Launches JavaFX Application
 * @author Trevor Barnes
 * @version 2.0
 */
public class Lab06 extends Application {

    /**
     * Starts and launches the JavaFX application with lab06.fxml file.
     * @param primaryStage stage containing program window
     * @throws IOException throws IOException when program starts
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        final int dimensions = 600;
        Parent root = FXMLLoader.load(getClass().getResource("lab06.fxml"));
        primaryStage.setTitle("Website Tester");
        primaryStage.setScene(new Scene(root, dimensions, dimensions));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
