package Week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.in;

public class FileIOExample {

    public static void main(String[] args) {
        String home = System.getProperty("user.dir");
        Path path = Paths.get(home,"Week6","FileIO");
        System.out.println(path);
        File file = new File("File.txt");
        Scanner in = new Scanner("historyChannel");
        try (PrintWriter pw = new PrintWriter("File.txt")){
            file.createNewFile();
            while(in.hasNext()) {
                String temp = in.next();
                System.out.println(temp);
                pw.print(temp);
            }
        } catch(FileNotFoundException fileException) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Could not create file");
        } finally {
            in.close();
        }
        System.out.println(file.exists());

        }

    }



