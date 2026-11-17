package ie.atu;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get workshop details
        System.out.print("Enter workshop name: ");
        String workshopName = scanner.nextLine();

        System.out.print("Enter workshop capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        // Create Workshop object
        Workshop workshop = new Workshop(workshopName, capacity);

        // Get number of registration attempts
        System.out.print("How many registration attempts? ");
        int attempts = Integer.parseInt(scanner.nextLine());

        // Process registrations
        for (int i = 1; i <= attempts; i++) {

            System.out.print("Enter student ID for attempt " + i + ": ");
            String studentID = scanner.nextLine();

            String result = workshop.registerStudent(studentID);

            System.out.println(result);
            System.out.println();
        }

        // Display final report
        System.out.println("===== WORKSHOP REGISTRATION REPORT =====");

        System.out.println("Workshop: " + workshop.getWorkshopName());

        System.out.println("Registered students:");
        workshop.displayRegisteredStudents();

        System.out.println("Total accepted registrations: "
                + workshop.getAcceptedRegistrations());

        System.out.println("Total rejected attempts: "
                + workshop.getRejectedAttempts());

        System.out.println("Remaining places: "
                + workshop.getRemainingPlaces());

        scanner.close();
    }
}
