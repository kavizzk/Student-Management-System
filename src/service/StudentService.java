package service;
import exception.StudentNotFoundException;
import model.Student;
import util.FileUtility;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class StudentService {

    // List to store students
    private ArrayList<Student> students;

    // Constructor
    public StudentService() {

        // Load students from file when application starts
        students = FileUtility.readObject();
    }

    /**
     * Add Student
     */
    public void addStudent(Student student) {
        // Check duplicate ID
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("--------------------------------");
                System.out.println("Student ID already exists.");
                System.out.println("--------------------------------");
                return;
            }
        }
        students.add(student);
        FileUtility.writeObject(students);
        System.out.println("--------------------------------");
        System.out.println("Student Added Successfully.");
        System.out.println("--------------------------------");
    }
    /**
     * View All Students
     */
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("--------------------------------");
            System.out.println("No Student Records Found.");
            System.out.println("--------------------------------");
            return;
        }

        System.out.println("\n================ STUDENT LIST ================\n");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    /**
     * Search Student by ID
     */
    public Student searchById(int id) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new StudentNotFoundException(
                "Student with ID " + id + " not found.");
    }
    /**
     * Search Student by Name
     */
    public void searchByName(String name) {
        boolean found = false;

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println(student);
                found = true;
            }
        }

        if (!found) {

            System.out.println("--------------------------------");
            System.out.println("No student found with name: " + name);
            System.out.println("--------------------------------");
        }
    }

    /**
     * Search Student by Course
     */
    public void searchByCourse(String course) {

        boolean found = false;

        for (Student student : students) {

            if (student.getCourse().equalsIgnoreCase(course)) {

                System.out.println(student);
                found = true;
            }
        }

        if (!found) {

            System.out.println("--------------------------------");
            System.out.println("No students found in course: " + course);
            System.out.println("--------------------------------");
        }
    }
    /**
     * Update Student
     */
    public void updateStudent(int id,
                              String phone,
                              String address,
                              String course,
                              double percentage)
            throws StudentNotFoundException {

        Student student = searchById(id);

        student.setPhone(phone);
        student.setAddress(address);
        student.setCourse(course);
        student.setPercentage(percentage);

        FileUtility.writeObject(students);

        System.out.println("--------------------------------");
        System.out.println("Student Updated Successfully.");
        System.out.println("--------------------------------");
    }

    /**
     * Delete Student
     */
    public void deleteStudent(int id)
            throws StudentNotFoundException {

        Student student = searchById(id);

        students.remove(student);

        FileUtility.writeObject(students);

        System.out.println("--------------------------------");
        System.out.println("Student Deleted Successfully.");
        System.out.println("--------------------------------");
    }
    /**
     * Sort Students by ID
     */
    public void sortById() {

        Collections.sort(students,
                Comparator.comparingInt(Student::getId));

        System.out.println("--------------------------------");
        System.out.println("Students Sorted By ID");
        System.out.println("--------------------------------");

        viewStudents();
    }

    /**
     * Sort Students by Name
     */
    public void sortByName() {

        Collections.sort(students,
                Comparator.comparing(Student::getName));

        System.out.println("--------------------------------");
        System.out.println("Students Sorted By Name");
        System.out.println("--------------------------------");

        viewStudents();
    }

    /**
     * Sort Students by Age
     */
    public void sortByAge() {

        Collections.sort(students,
                Comparator.comparingInt(Student::getAge));

        System.out.println("--------------------------------");
        System.out.println("Students Sorted By Age");
        System.out.println("--------------------------------");

        viewStudents();
    }

    /**
     * Sort Students by Percentage
     */
    public void sortByPercentage() {

        Collections.sort(students,
                Comparator.comparingDouble(Student::getPercentage)
                        .reversed());

        System.out.println("--------------------------------");
        System.out.println("Students Sorted By Percentage");
        System.out.println("--------------------------------");

        viewStudents();
    }

    /**
     * Save Students to File
     */
    public void saveStudents() {

        FileUtility.writeObject(students);

        System.out.println("--------------------------------");
        System.out.println("Student Data Saved Successfully.");
        System.out.println("--------------------------------");
    }

    /**
     * Load Students from File
     */
    public void loadStudents() {

        students = FileUtility.readObject();

        System.out.println("--------------------------------");
        System.out.println("Student Data Loaded Successfully.");
        System.out.println("--------------------------------");
    }

}

