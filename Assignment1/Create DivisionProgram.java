import java.util.Scanner;

public class DivisionProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input numerator
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            // Input denominator
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Call the method to perform division
            divideNumbers(numerator, denominator);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        }

        scanner.close();
    }

    // Method to perform division and handle ArithmeticException
    public static void divideNumbers(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } else {
            int result = numerator / denominator;
            System.out.println("Result of division: " + result);
        }
    }
}
