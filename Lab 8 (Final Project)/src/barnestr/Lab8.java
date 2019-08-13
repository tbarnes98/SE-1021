/*
 * SE1021
 * Spring 2018
 * Lab 8 - Final Project
 * Name: Trevor Barnes
 * Created: 5/2/18
 */
package barnestr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class for Lab 8. Launches JavaFX Application
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Lab8 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Loads in both Lab8.fxml and KernelController.fxml with each's respective controller. Loader also
     * opens up streams between the two UI windows. Launches the JavaFX application
     *
     * @param primaryStage the stage for the main window
     * @throws IOException if there is a problem with launching the program
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader();
        Parent mainRoot = mainLoader.load(getClass().getResource("Lab8.fxml").openStream());
        Controller mainController = mainLoader.getController();
        primaryStage.setTitle("Image Manipulator");
        primaryStage.setScene(new Scene(mainRoot));
        primaryStage.show();

        Stage kernelStage = new Stage();
        FXMLLoader kernelLoader = new FXMLLoader();
        Parent kernelRoot = kernelLoader.load(getClass()
                .getResource("KernelController.fxml").openStream());
        KernelController kernelController = kernelLoader.getController();
        kernelStage.setTitle("Filter Kernel");
        kernelStage.setScene(new Scene(kernelRoot));

        mainController.setKernelStage(kernelStage);
        mainController.setKernelController(kernelController);

        kernelController.setMainStage(primaryStage);
        kernelController.setMainController(mainController);
    }
}
