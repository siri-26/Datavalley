import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of days late
        System.out.print("Enter the number of days late: ");
        int daysLate = scanner.nextInt();

        // Calculate fine
        int fine = calculateFine(daysLate);

        // Display fine or membership cancellation message
        if (fine == -1) {
            System.out.println("Your membership has been canceled for returning the book after 21 days.");
        } else if (fine == 0) {
            System.out.println("No fine for returning the book on time.");
        } else {
            System.out.println("Fine for returning the book " + daysLate + " days late: Rs. " + fine);
        }

        scanner.close();
    }

    // Method to calculate fine based on the number of days late
    public static int calculateFine(int daysLate) {
        if (daysLate <= 7) {
            return 50 * daysLate; // 50 paise fine for the first 7 days
        } else if (daysLate <= 14) {
            return (daysLate - 7) * 100; // 1 rupee fine for days 8-14
        } else if (daysLate <= 21) {
            return 500; // 5 rupees fine for days 15-21
        } else {
            return -1; // Membership cancellation if returned after 21 days
        }
    }
}
