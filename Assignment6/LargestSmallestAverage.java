import java.util.Scanner;

public class LargestSmallestAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables to store largest, smallest, and sum of numbers
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int sum = 0;

        // Counter to keep track of the number of input numbers
        int count = 0;

        // Flag to check if the user wants to continue entering numbers
        boolean continueInput = true;

        // Loop to enter numbers
        while (continueInput) {
            System.out.print("Enter a number (or 'stop' to end): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("stop")) {
                continueInput = false;
            } else {
                int number = Integer.parseInt(input);

                // Update largest and smallest
                largest = Math.max(largest, number);
                smallest = Math.min(smallest, number);

                // Add to sum
                sum += number;

                count++;
            }
        }

        // Calculate average
        double average = (double) sum / count;

        // Display results
        if (count > 0) {
            System.out.println("Largest number entered: " + largest);
            System.out.println("Smallest number entered: " + smallest);
            System.out.println("Average of all numbers entered: " + average);
        } else {
            System.out.println("No numbers entered.");
        }

        scanner.close();
    }
}
