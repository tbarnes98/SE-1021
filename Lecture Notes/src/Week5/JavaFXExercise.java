package Week5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class JavaFXExercise extends Application {
    // create a simple GUI interface that has two TextFields and one Button
    // Make a new Stage and Scene of size 400x400

    // The first textfield should have a label "Username"
    // The second textfield should have a label "Passcode"

    // The Button should be labeled "Submit"

    // When the Button is pressed, if a username has been entered in the first textfield,
    // a random six digit passcode should be generated in the second textfield.
    // The second textfield should not be able to be edited by the user.
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        TextField username = new TextField("Username");
        TextField passcode = new TextField("Passcode");
        Button submit = new Button("Submit");
        HBox hBox = new HBox();

        hBox.getChildren().addAll(username, passcode);
        vBox.getChildren().addAll(hBox, submit);

        passcode.setEditable(false);
        submit.setOnAction(event -> {
            int code = (int)(Math.random()*1000000);
            passcode.setText(Integer.toString(code));
        });

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

