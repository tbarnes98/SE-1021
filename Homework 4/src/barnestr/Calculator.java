package barnestr;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Calculator extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        VBox vBox = new VBox();
        HBox hBox = new HBox();


        TextField field1 = new TextField();
        TextField field2 = new TextField();
        Button operator = new Button();
        Button equals = new Button();
        Label answer = new Label("Label");
        hBox.getChildren().addAll(field1,operator,field2,equals);
        vBox.getChildren().addAll(hBox,answer);
        pane.getChildren().add(vBox);

        primaryStage.setTitle("I am a calculator");
        primaryStage.setScene(new Scene(pane,400,100));
        primaryStage.show();
    }
}
