package model;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String course;
    private String address;
    private double percentage;
    // Default Constructor
    public Student() {
    }
    public Student(int id, String name, int age, String gender,
                   String email, String phone,
                   String course, String address,
                   double percentage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.address = address;
        this.percentage = percentage;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getCourse() {
        return course;
    }
    public String getAddress() {
        return address;
    }
    public double getPercentage() {
        return percentage;
    }
    // Setter Methods
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    @Override
    public String toString() {
        return "-------------------------------------------\n"
                + "Student ID   : " + id + "\n"
                + "Name         : " + name + "\n"
                + "Age          : " + age + "\n"
                + "Gender       : " + gender + "\n"
                + "Email        : " + email + "\n"
                + "Phone        : " + phone + "\n"
                + "Course       : " + course + "\n"
                + "Address      : " + address + "\n"
                + "Percentage   : " + percentage + "\n"
                + "-------------------------------------------";
    }
}
