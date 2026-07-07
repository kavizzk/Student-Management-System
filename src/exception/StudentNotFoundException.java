package exception;
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("Student not found.");
    }
    public StudentNotFoundException(String message) {
        super(message);
    }
}
