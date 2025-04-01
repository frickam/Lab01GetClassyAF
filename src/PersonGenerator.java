import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        do {
            String ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            String title = SafeInput.getNonZeroLenString(in, "Enter your title");
            int YOB = SafeInput.getRangedInt(in, "Enter your year of birth", 1000, 9999);

            Person person = new Person(ID, firstName, lastName, title, YOB);
            persons.add(person);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!done);

        for (Person p : persons)
            System.out.println(p);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            // Finally can write the file LOL!
            for (Person p : persons) {
                writer.write(p.toCSV());
                writer.newLine();  // adds the new line
            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}