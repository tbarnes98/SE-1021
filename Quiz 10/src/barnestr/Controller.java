package barnestr;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private String username;
    private String password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = "barnestr908";
        password = "msoe4me";
    }

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button okButton;


    @FXML
    void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }

    @FXML
    void cancelButtonAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void okButtonAction(ActionEvent event) {
        if (usernameField.getText().equals(username)&&passwordField.getText().equals(password)) {
            Platform.exit();
        } else {
            clearFields();
        }
    }

}
