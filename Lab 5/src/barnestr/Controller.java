/*
 * SE1021
 * Spring 2018
 * Lab 5 - Game of Life
 * Name: Trevor Barnes
 * Created: 4/11/18
 */

package barnestr;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller for gameOfLife.fxml
 *
 * @author Trevor Barnes
 * @version 2.0
 */
public class Controller implements Initializable {


    @FXML
    private Pane gamePane = new Pane();

    private LifeGrid game = new LifeGrid(gamePane);

    @FXML
    private HBox buttons;

    @FXML
    private Button nextButton;

    @FXML
    private Label aliveDeadCount;

    @FXML
    private Button randomizeButton;

    @FXML
    void mouseClick(MouseEvent location) {
        game.setState(location);
        labelUpdater();
    }

    @FXML
    void iterate() {
        game.iterate();
        labelUpdater();
    }

    @FXML
    void randomize() {
        game.randomize();
        labelUpdater();
    }

    private void labelUpdater() {

        aliveDeadCount.setText("Alive: " + game.aliveCells + " Dead: " + game.deadCells);
    }

    /**
     * The initialize method for the controller
     *
     * @param location  URL
     * @param resources ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'game.fxml'.";
        game = new LifeGrid(gamePane);
    }
}

