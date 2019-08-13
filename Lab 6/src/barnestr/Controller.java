/*
 * SE1021
 * Spring 2018
 * Lab 6 - Exceptions
 * Name: Trevor Barnes
 * Created: 4/18/18
 */
package barnestr;

import edu.msoe.se1021.Lab6.WebsiteTester;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ButtonBar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * The controller class for lab06.fxml that handles each button and text components.
 * @author Trevor Barnes
 * @version 2.0
 */
public class Controller {

    @FXML
    private TextField urlField;

    @FXML
    private TextField sizeField;

    @FXML
    private TextField downloadTimeField;

    @FXML
    private TextField portField;

    @FXML
    private TextField hostField;

    @FXML
    private TextField timeoutField;

    @FXML
    private TextArea outputArea;


    WebsiteTester tester = new WebsiteTester();

    /**
     * Calls all of the methods required to analyze a website and catches any exceptions that
     * come upt from calling these methods.
     */
    public void analyze() {
        try {
            tester.openURL(urlField.getText());
            tester.openConnection();
            tester.downloadText();
            outputArea.setText(tester.getContent());
            sizeField.setText(Integer.toString(tester.getSize()));
            downloadTimeField.setText(Long.toString(tester.getDownloadTime()));
            hostField.setText(tester.getHostname());
            portField.setText(Integer.toString(tester.getPort()));

        } catch (MalformedURLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("URL Error");
            alert.setContentText("The URL entered in the box is invalid");
            alert.showAndWait();
        } catch (UnknownHostException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Host Error");
            alert.setContentText("Error: Unable to reach the host " + urlField.getText());
            alert.showAndWait();
        } catch (SocketTimeoutException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Timeout Dialog");
            alert.setHeaderText("Wait longer?");
            alert.setContentText("There has been a timeout reaching the site. " +
                    "Click OK to extend the timeout period?");

            ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            ButtonType buttonTypeCancel = new ButtonType("Cancel",
                    ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get() == ButtonType.OK) {
                TextInputDialog dialog = new TextInputDialog("10");
                dialog.setTitle("Set timeout");
                dialog.setHeaderText("Set extended timeout");
                dialog.setContentText("Desired timeout:");
                dialog.showAndWait();
                timeoutField.setText(dialog.getResult());
                setTimeout();

            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("File Error");
            alert.setContentText("Error: File not found on the server, " + urlField.getText());
            alert.showAndWait();
        }

    }


    /**
     * Takes the integer value in the timeout field and sets timeout with that value.
     */
    public void setTimeout() {

        try {
            tester.setTimeout(timeoutField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Invalid Timeout Error");
            alert.setContentText("Timeout must be greater than or equal to 0.");
            alert.showAndWait();
            timeoutField.setText(tester.getTimeout());
        }
    }
}

