# Student Management System

A console-based Java application that manages student records using **Traditional Java File I/O**. The project allows users to add, view, search, update, and delete student records while storing data permanently in a text file.

---

## 📌 Project Overview

The Student Management System is designed to demonstrate file handling concepts in Java without using databases. Student information is stored in a file, ensuring that records remain available even after the application is closed.

---

## ✨ Features

* Add new student records
* View all student records
* Search a student by ID
* Update student details
* Delete student records
* Store data using Traditional Java File I/O
* Console-based menu-driven interface
* Persistent storage using text files

---

## 🛠 Technologies Used

* Java
* Traditional Java File I/O (`File`, `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)
* Object-Oriented Programming (OOP)
* IntelliJ IDEA

---

## 📂 Project Structure

```text
Student-Management-System/
│
├── src/
│   ├── Main.java
│   ├── Student.java
│   ├── StudentService.java
│   ├── FileManager.java
│   └── ...
│
├── data/
│   └── students.txt
│
└── README.md
```

---

## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/kavizzk/Student-Management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Build the project.

4. Run the `Main.java` file.

5. Use the console menu to manage student records.

---

## 📋 Sample Menu

```text
===== Student Management System =====

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice:
```

---

## 💾 Data Storage

Student records are stored in a text file (`students.txt`) using Traditional Java File I/O. The data remains available even after the application is closed.

Example:

```text
101,John,20,Computer Science
102,Emma,21,Information Technology
103,David,19,Electronics
```

---

## 🎯 Learning Objectives

This project demonstrates:

* Java File Handling
* FileReader and FileWriter
* BufferedReader and BufferedWriter
* Exception Handling
* Object-Oriented Programming
* CRUD Operations
* Menu-Driven Applications

---

## 📖 Future Enhancements

* GUI using Java Swing or JavaFX
* Database integration (MySQL)
* Student attendance management
* Marks and grade management
* User authentication
* Report generation
* Search using multiple criteria

---

## 👩‍💻 Author

**Kavitha Selvam**

GitHub: https://github.com/kavizzk

---

## 📄 License

This project is created for learning and educational purposes.
