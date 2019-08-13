/*
 * SE1021
 * Spring 2018
 * Lab 8 - Final Project
 * Name: Trevor Barnes
 * Created: 5/2/18
 */
package barnestr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * The controller that handles all of the UI components of the Kernel window
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class KernelController {

    private Stage mainStage;

    private Controller mainController;

    /**
     * Sets the stage for the main window to be able to be accessed
     *
     * @param mainStage the stage for the main window
     */
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    /**
     * Sets the controller for the main window to be able to be accessed
     *
     * @param mainController the controller for the main window
     */
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    @FXML
    private TextField textB1;

    @FXML
    private TextField textB2;

    @FXML
    private TextField textB3;

    @FXML
    private TextField textS1;

    @FXML
    private TextField textS2;

    @FXML
    private TextField textS3;

    @FXML
    private TextField textE1;

    @FXML
    private TextField textE2;

    @FXML
    private TextField textE3;

    @FXML
    private TextField textDivisor;

    @FXML
    void apply(ActionEvent event) {
        /*int sum = Integer.getInteger(textB1.getText()) + Integer.getInteger(textB2.getText())
                + Integer.getInteger(textB3.getText()) + Integer.getInteger(textS1.getText())
                + Integer.getInteger(textS2.getText()) + Integer.getInteger(textS3.getText())
                + Integer.getInteger(textE1.getText()) + Integer.getInteger(textE2.getText())
                + Integer.getInteger(textE3.getText());
        if (sum > 0) {
            mainController.blur();
        }*/
    }

    @FXML
    void blur(ActionEvent event) {
        textB1.setText("0");
        textB2.setText("1");
        textB3.setText("0");
        textS1.setText("1");
        textS2.setText("5");
        textS3.setText("1");
        textE1.setText("0");
        textE2.setText("1");
        textE3.setText("0");
    }

    @FXML
    void sharpen(ActionEvent event) {
        textB1.setText("0");
        textB2.setText("-1");
        textB3.setText("0");
        textS1.setText("-1");
        textS2.setText("5");
        textS3.setText("-1");
        textE1.setText("0");
        textE2.setText("-1");
        textE3.setText("0");
    }

    @FXML
    void edge(ActionEvent event) {
        textB1.setText("0");
        textB2.setText("-1");
        textB3.setText("0");
        textS1.setText("-1");
        textS2.setText("4");
        textS3.setText("-1");
        textE1.setText("0");
        textE2.setText("-1");
        textE3.setText("0");
    }


}
