/*
 * SE1021
 * Spring 2018
 * Lab 8 - Final Project
 * Name: Trevor Barnes
 * Created: 5/2/18
 */
package barnestr;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Provides all of the methods necessary for reading and writing Image files of the given types
 *
 * @author Trevor Barnes
 * @version 1.0
 */
public class ImageIO {


    /**
     * Reads a file depending on its file type and returns that data in the form of an image
     *
     * @param file the file to be read
     * @return Image from file data
     */
    public Image read(File file) {
        String filename = file.getName();
        try (DataInputStream din = new DataInputStream(new FileInputStream(file))) {
            if (filename.endsWith(".msoe")) {
                return readMSOE(file);
            } else if (filename.endsWith(".bmsoe")) {
                return readBMSOE(file);
            } else {
                return new Image(din);
            }
        } catch (IOException e) {
            Controller.errorAlert("IOException Thrown", "Problem reading file");
            return null;
        }
    }

    /**
     * Writes an image file based on the file type being saved
     *
     * @param image the image that will be written
     * @param file  the file that the image will be written to
     * @throws IOException if the writing to the file causes a problem
     */
    public void write(Image image, File file) throws IOException {
        String filename = file.getName();
        if (filename.endsWith(".msoe")) {
            writeMSOE(image, file);
        } else if (filename.endsWith(".bmsoe")) {
            writeBMSOE(image, file);
        } else {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            SwingFXUtils.fromFXImage(image, bufferedImage);
            try {
                javax.imageio.ImageIO.write(bufferedImage,
                        filename.substring(filename.length() - 3), file);
            } catch (IOException e) {
                Controller.errorAlert("IOException Thrown", "Error while writing file");
            }
        }
    }

    /**
     * Reads a MSOE file and returns that data in the form of an image
     *
     * @param file the file to be read
     * @return Image from file data
     * @throws FileNotFoundException file was not found in given file location
     */
    private Image readMSOE(File file) throws FileNotFoundException {

        try (Scanner in = new Scanner(file)) {
            if (in.nextLine().equals("MSOE")) {
                int width = in.nextInt();
                int height = in.nextInt();
                WritableImage image = new WritableImage(width, height);
                in.nextLine();
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        String hex = in.next();
                        //Substring indexes 1 through 7 take the two numbers of each RGB code portion
                        //Radix 16 is hexadecimal
                        //Value is divided by 255.0 to return a R, G, or B value between 1 and 0
                        Color color = new Color(Integer.parseInt(hex.substring(1, 3), 16) / 255.0,
                                Integer.parseInt(hex.substring(3, 5), 16) / 255.0,
                                Integer.parseInt(hex.substring(5, 7), 16) / 255.0,
                                Integer.parseInt(hex.substring(7), 16) / 255.0);
                        image.getPixelWriter().setColor(j, i, color);
                    }
                }
                return image;
            }
        }
        return null;
    }

    /**
     * Writes an MSOE file with the given Image data and file location
     *
     * @param image the image file to write from
     * @param file  the file to be written to
     * @throws FileNotFoundException file location could not be found
     */
    private void writeMSOE(Image image, File file) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.append("MSOE\r\n")
                    .append(String.valueOf((int) image.getWidth()))
                    .append(" ")
                    .append(String.valueOf((int) image.getHeight()))
                    .append("\r\n");
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    String hex = String.format("%08x", image.getPixelReader().getArgb(j, i));
                    hex = hex.substring(2) + hex.substring(0, 2);
                    pw.append("#")
                            .append(hex)
                            .append(" ");
                }
                pw.append("\n");
            }
        }
    }

    /**
     * Reads a BMSOE file and returns that data in the form of an image
     *
     * @param file the file to be read
     * @return Image from file data
     * @throws IOException problem with DataInputStream or finding the location
     */
    private Image readBMSOE(File file) throws IOException {
        try (DataInputStream din = new DataInputStream(new FileInputStream(file))) {
            StringBuilder bmsoe = new StringBuilder();
            //Loop 5 times
            for (int i = 0; i < 5; i++) {
                bmsoe.append("").append((char) din.read());
            }
            if (bmsoe.toString().contains("BMSOE")) {
                WritableImage writableImage = new WritableImage(din.readInt(), din.readInt());
                for (int i = 0; i < writableImage.getHeight(); i++) {
                    for (int j = 0; j < writableImage.getWidth(); j++) {
                        //Value is divided by 255.0 to return a R, G, or B value between 1 and 0
                        Color color = Color.color((din.readUnsignedByte() / 255.0),
                                (din.readUnsignedByte() / 255.0),
                                (din.readUnsignedByte() / 255.0),
                                (din.readUnsignedByte() / 255.0));
                        writableImage.getPixelWriter().setColor(j, i, color);
                    }
                }
                //Loop 16 times
                for (int k = 0; k < 16 % (writableImage.getWidth() * 4); k++) {
                    din.read();
                }
                return writableImage;
            }
        }
        return null;
    }

    /**
     * Writes an BMSOE file with the given Image data and file location
     *
     * @param image the image file to write from
     * @param file  the file to be written to
     * @throws IOException problem with DataOutputStream or finding the location
     */
    private void writeBMSOE(Image image, File file) throws IOException {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(file))) {
            int width = (int) image.getWidth();
            int height = (int) image.getHeight();
            dout.writeBytes("BMSOE");
            dout.writeInt(width);
            dout.writeInt(height);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    String format = String.format("%08x", image.getPixelReader().getArgb(j, i));
                    //0 through 6 are the indexes
                    //Radix 16 is hexadecimal
                    //Appends the bits with the alpha value FF (Fully opaque)
                    dout.writeByte(Integer.parseInt(format.substring(2, 4), 16) & 0xFF);
                    dout.writeByte(Integer.parseInt(format.substring(4, 6), 16) & 0xFF);
                    dout.writeByte(Integer.parseInt(format.substring(6), 16) & 0xFF);
                    dout.writeByte(Integer.parseInt(format.substring(0, 2), 16) & 0xFF);
                }
            }
        }
    }
}
