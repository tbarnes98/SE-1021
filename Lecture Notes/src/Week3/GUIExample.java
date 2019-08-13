package Week3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.beans.EventHandler;

public class GUIExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("My Great JavaFX Program!");
        Button button = new Button("Start");
        Button stopButton = new Button("Stop");
       //stopButton.setOnAction(new StopButtonHandler() {
       //     @Override
       //     public void handle(ActionEvent event) {
       //     }
       // });
        pane.getChildren().addAll(button,stopButton);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
