/*
 * SE1021
 * Spring 2018
 * Lab 8 - Final Project
 * Name: Trevor Barnes
 * Created: 5/2/18
 */
package barnestr;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The controller that handles all of the UI components of the Main window
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class Controller implements Initializable {

    private KernelController kernelController;
    private Stage kernelStage;
    private Image initialImage;
    private Transformable grayscaleTransformation = (x, y, color) -> setGray(color);
    private Transformable negativeTransformation = (x, y, color) ->
            Color.color(1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue());
    private Transformable redTransformation = (x, y, color) -> setRed(color);
    private Transformable redGrayTransformation = (x, y, color) -> setRedGray(color, y);
    private Logger logger = Logger.getLogger("Lab8");

    /*public void blur() {
        int width = (int)imgView.getImage().getWidth();
        int height = (int)imgView.getImage().getHeight();
        float[] kernel = { 0F,  1/9F,   0F,
                1/9F,  5/9F, 1/9F,
                0F,  1/9F,   0F};
        BufferedImage original = SwingFXUtils.fromFXImage(imgView.getImage(),null);
        BufferedImageOp op = new ConvolveOp(new Kernel(width,height,kernel));
        BufferedImage result = op.filter(original,null);
        imgView.setImage(SwingFXUtils.toFXImage(result,null));
    }*/

    /**
     * Sets the kernel stage to be able to be opened
     *
     * @param kernelStage the stage for the kernel window
     */
    public void setKernelStage(Stage kernelStage) {
        this.kernelStage = kernelStage;
    }

    /**
     * Sets the controller for the kernel window to be able to be accessed
     *
     * @param kernelController the controller for the kernel window
     */
    public void setKernelController(KernelController kernelController) {
        this.kernelController = kernelController;
    }

    private static Image transformImage(Image image, Transformable transform) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        WritableImage writableImage = new WritableImage(width, height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        PixelReader pixelReader = image.getPixelReader();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color initialColor = pixelReader.getColor(i, j);
                Color newColor = transform.transform(i, j, initialColor);
                pixelWriter.setColor(i, j, newColor);
            }
        }
        return writableImage;
    }

    private Color setGray(Color color) {
        final double GRAY_MULTIPLIER_RED = .2126;
        final double GRAY_MULTIPLIER_GREEN = .7152;
        final double GRAY_MULTIPLIER_BLUE = .0722;

        double gray = GRAY_MULTIPLIER_RED * color.getRed() +
                GRAY_MULTIPLIER_GREEN * color.getGreen() +
                GRAY_MULTIPLIER_BLUE * color.getBlue();
        return Color.color(gray, gray, gray);
    }

    private Color setRed(Color color) {
        return Color.color(color.getRed(), 0, 0);
    }

    private Color setRedGray(Color color, int y) {
        if ((y % 2) == 1) {
            return setRed(color);
        } else {
            return setGray(color);
        }
    }

    /**
     * Shows an ERROR type alert with passed in header and content strings
     *
     * @param header  the header string for the Alert
     * @param content the content string for the Alert
     */
    public static void errorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private ImageView imgView;

    @FXML
    private Button btnFilter;

    @FXML
    void grayscale(ActionEvent event) {
        try {
            Image newImage = transformImage(imgView.getImage(), grayscaleTransformation);
            imgView.setImage(newImage);
        } catch (NullPointerException e) {
            errorAlert("NullPointerException Thrown",
                    "No image to apply grayscale transformation to");
            logger.log(Level.WARNING, "No image to apply grayscale transformation to");
        }
    }

    @FXML
    void filter(ActionEvent event) {
        if (!kernelStage.isShowing()) {
            kernelStage.show();
            btnFilter.setText("Hide Filter");
        } else {
            kernelStage.close();
            btnFilter.setText("Show Filter");
        }
    }

    @FXML
    void negative(ActionEvent event) {
        try {
            Image newImage = transformImage(imgView.getImage(), negativeTransformation);
            imgView.setImage(newImage);
        } catch (NullPointerException e) {
            errorAlert("NullPointerException Thrown",
                    "No image to apply negative transformation to");
            logger.log(Level.WARNING, "\"No image to apply negative transformation to");
        }
    }

    @FXML
    void red(ActionEvent event) {
        try {
            Image newImage = transformImage(imgView.getImage(), redTransformation);
            imgView.setImage(newImage);
        } catch (NullPointerException e) {
            errorAlert("NullePointerException Thrown",
                    "No image to apply red transformation to");
            logger.log(Level.WARNING, "No image to apply red transformation to");
        }
    }

    @FXML
    void redGray(ActionEvent event) {
        try {
            Image newImage = transformImage(imgView.getImage(), redGrayTransformation);
            imgView.setImage(newImage);
        } catch (NullPointerException e) {
            errorAlert("NullPointerException Thrown",
                    "No image to apply red gray transformation");
            logger.log(Level.WARNING, "No image to apply red gray transformation");
        }
    }

    @FXML
    void open(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.gif", "*.jpg", "*.png", "*.msoe")
        );
        try {
            imgView.setImage(new ImageIO().read(fileChooser.showOpenDialog(null)));
            initialImage = imgView.getImage();
        } catch (NullPointerException e) {
            errorAlert("NullPointerException Thrown",
                    "No file was selected to be opened");
            logger.log(Level.WARNING, "No file was selected to be opened");

        }
    }

    @FXML
    void reload(ActionEvent event) {
        imgView.setImage(initialImage);
    }

    @FXML
    void save(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.gif", "*.jpg", "*.png", "*.msoe")
        );
        try {
            new ImageIO().write(imgView.getImage(), fileChooser.showSaveDialog(null));
        } catch (NullPointerException e) {
            errorAlert("NullPointerException Thrown", "No file destination was chosen");
            logger.log(Level.WARNING, "No file destination was chosen");
        } catch (IOException e) {
            errorAlert("IOException Thrown", "Problem saving file");
            logger.log(Level.WARNING, "Problem saving file");
        }
    }

    /**
     * Initializes the logger file
     *
     * @param location  location URL
     * @param resources resources ResourceBundle
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FileHandler handler = new FileHandler(System.getProperty("user.dir") + File.separator + "Lab8Log.log");
            logger.addHandler(handler);
        } catch (IOException e) {
            logger.severe("Could not create log file");
        }
        logger.setUseParentHandlers(false);
    }

    @FXML
    private Label coordsLabel;

    @FXML
    void coordResfresh(MouseEvent event) {
        coordsLabel.setText("X: " + event.getX() + "Y: " + event.getY());
    }
}
