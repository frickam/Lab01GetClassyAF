import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        ArrayList<Person> persons = new ArrayList<>();
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // Set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String[] data = line.split(", ");
                    if (data.length == 5) {
                        Person person = new Person(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                        persons.add(person);
                    }
                }
                inFile.close();

                // Print all Person objects to verify
                for (Person person : persons) {
                    System.out.println(person);
                }
            } else {
                // User did not pick a file, closed the chooser
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}