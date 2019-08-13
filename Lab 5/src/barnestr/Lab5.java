/*
 * SE1021
 * Spring 2018
 * Lab 5 - Game of Life
 * Name: Trevor Barnes
 * Created: 4/11/18
 */

package barnestr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class implements the lab5.FXML into the root scene and launches the application window.
 * @author barnestr
 * @version 2.0
 */
public class Lab5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the primary stage.
     * @param primaryStage the base stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("gameOfLife.fxml"));
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}