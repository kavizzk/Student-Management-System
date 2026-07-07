import model.Student;
import service.StudentService;
import exception.StudentNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        int choice;

        while (true) {

            System.out.println("\n======================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");
            System.out.println("======================================");

            try {

                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        try {

                            System.out.println("\n---------- Add Student ----------");

                            System.out.print("Enter Student ID : ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Name : ");
                            String name = sc.nextLine();

                            System.out.print("Enter Age : ");
                            int age = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Gender : ");
                            String gender = sc.nextLine();

                            System.out.print("Enter Email : ");
                            String email = sc.nextLine();

                            System.out.print("Enter Phone : ");
                            String phone = sc.nextLine();

                            System.out.print("Enter Course : ");
                            String course = sc.nextLine();

                            System.out.print("Enter Address : ");
                            String address = sc.nextLine();

                            System.out.print("Enter Percentage : ");
                            double percentage = sc.nextDouble();
                            sc.nextLine();

                            // Validations

                            if (id <= 0) {
                                System.out.println("Invalid Student ID.");
                                break;
                            }

                            if (age < 18 || age > 60) {
                                System.out.println("Age must be between 18 and 60.");
                                break;
                            }

                            if (!email.contains("@")) {
                                System.out.println("Invalid Email.");
                                break;
                            }

                            if (phone.length() != 10) {
                                System.out.println("Phone number must contain 10 digits.");
                                break;
                            }

                            if (percentage < 0 || percentage > 100) {
                                System.out.println("Percentage must be between 0 and 100.");
                                break;
                            }

                            Student student = new Student(
                                    id,
                                    name,
                                    age,
                                    gender,
                                    email,
                                    phone,
                                    course,
                                    address,
                                    percentage);

                            service.addStudent(student);

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid Input.");

                            sc.nextLine();

                        }

                        break;

                    case 2:

                        System.out.println("\n---------- Student List ----------");

                        service.viewStudents();

                        break;
                    case 3:

                        System.out.println("\n---------- Search Student ----------");
                        System.out.println("1. Search by ID");
                        System.out.println("2. Search by Name");
                        System.out.println("3. Search by Course");

                        System.out.print("Enter Choice : ");
                        int searchChoice = sc.nextInt();
                        sc.nextLine();

                        switch (searchChoice) {

                            case 1:

                                try {

                                    System.out.print("Enter Student ID : ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    Student student = service.searchById(id);

                                    System.out.println(student);

                                } catch (StudentNotFoundException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 2:

                                System.out.print("Enter Student Name : ");
                                String name = sc.nextLine();

                                service.searchByName(name);

                                break;

                            case 3:

                                System.out.print("Enter Course : ");
                                String course = sc.nextLine();

                                service.searchByCourse(course);

                                break;

                            default:

                                System.out.println("Invalid Choice.");
                        }

                        break;

                    case 4:

                        try {

                            System.out.println("\n---------- Update Student ----------");

                            System.out.print("Enter Student ID : ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Phone : ");
                            String phone = sc.nextLine();

                            System.out.print("Enter New Address : ");
                            String address = sc.nextLine();

                            System.out.print("Enter New Course : ");
                            String course = sc.nextLine();

                            System.out.print("Enter New Percentage : ");
                            double percentage = sc.nextDouble();
                            sc.nextLine();

                            service.updateStudent(
                                    id,
                                    phone,
                                    address,
                                    course,
                                    percentage);

                        } catch (StudentNotFoundException e) {

                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid Input.");

                            sc.nextLine();

                        }

                        break;

                    case 5:

                        try {

                            System.out.println("\n---------- Delete Student ----------");

                            System.out.print("Enter Student ID : ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            service.deleteStudent(id);

                        } catch (StudentNotFoundException e) {

                            System.out.println(e.getMessage());

                        }

                        break;

                    case 6:

                        System.out.println("\n========== Sort Students ==========");
                        System.out.println("1. Sort by Student ID");
                        System.out.println("2. Sort by Name");
                        System.out.println("3. Sort by Age");
                        System.out.println("4. Sort by Percentage");
                        System.out.print("Enter your choice : ");

                        int sortChoice = sc.nextInt();
                        sc.nextLine();

                        switch (sortChoice) {

                            case 1:
                                service.sortById();
                                break;

                            case 2:
                                service.sortByName();
                                break;

                            case 3:
                                service.sortByAge();
                                break;

                            case 4:
                                service.sortByPercentage();
                                break;

                            default:
                                System.out.println("Invalid Choice.");
                        }

                        break;

                    case 7:

                        service.saveStudents();

                        break;

                    case 8:

                        service.saveStudents();

                        System.out.println("\n==================================");
                        System.out.println("Thank You for Using");
                        System.out.println("Student Management System");
                        System.out.println("==================================");

                        sc.close();

                        System.exit(0);

                        break;

                    default:

                        System.out.println("Invalid Choice.");


                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid number.");

                sc.nextLine();

            }

        }

    }

}
