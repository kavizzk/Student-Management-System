package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileUtility {

    private static final String FILE_NAME = "data/students.dat";
    public static void writeObject(ArrayList<Student> students) {

        try {

            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME));

            oos.writeObject(students);

            oos.close();

            System.out.println("Student data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving file.");
            e.printStackTrace();
        }
    }
    /**
     * Load student list from file
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> readObject() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No previous student data found.");
            return students;
        }
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME));
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
            System.out.println("Student data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException e) {
            System.out.println("Error while reading file.");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Student class not found.");
        }
        return students;
    }
}
