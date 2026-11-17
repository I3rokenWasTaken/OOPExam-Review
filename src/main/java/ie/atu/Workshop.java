package ie.atu;
import java.util.HashSet;

public class Workshop {

    // Private fields
    private String workshopName;
    private int capacity;
    private HashSet<String> registeredStudents;

    // Counters
    private int acceptedRegistrations;
    private int rejectedAttempts;

    // Constructor
    public Workshop(String workshopName, int capacity) {
        this.workshopName = workshopName;
        this.capacity = capacity;
        this.registeredStudents = new HashSet<>();
        this.acceptedRegistrations = 0;
        this.rejectedAttempts = 0;
    }

    // Register a student
    public String registerStudent(String studentID) {

        // Check for blank student ID
        if (studentID == null || studentID.isBlank()) {
            rejectedAttempts++;
            return "Rejected: student ID cannot be blank.";
        }

        // Check for duplicate student ID
        if (registeredStudents.contains(studentID)) {
            rejectedAttempts++;
            return "Duplicate: this student is already registered.";
        }

        // Check whether the workshop is full
        if (registeredStudents.size() >= capacity) {
            rejectedAttempts++;
            return "Rejected: the workshop is full.";
        }

        // Add the student
        registeredStudents.add(studentID);
        acceptedRegistrations++;

        return "Accepted: student registered successfully.";
    }

    // Display registered student IDs
    public void displayRegisteredStudents() {
        System.out.println("Registered students: " + registeredStudents);
    }

    // Get the number of accepted registrations
    public int getAcceptedRegistrations() {
        return acceptedRegistrations;
    }

    // Get the number of rejected attempts
    public int getRejectedAttempts() {
        return rejectedAttempts;
    }

    // Get the number of places remaining
    public int getRemainingPlaces() {
        return capacity - registeredStudents.size();
    }

    // Get the workshop name
    public String getWorkshopName() {
        return workshopName;
    }

    // Get the workshop capacity
    public int getCapacity() {
        return capacity;
    }
}

