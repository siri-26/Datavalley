import java.util.Scanner;

// Custom exception class
class CustomValidationException extends Exception {
    public CustomValidationException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input number
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            
            // Call the method that may throw the custom exception
            validateNumber(number);
            
            System.out.println("Number entered: " + number);
        } catch (CustomValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    // Method that throws CustomValidationException if the input number is negative
    public static void validateNumber(int number) throws CustomValidationException {
        if (number < 0) {
            throw new CustomValidationException("Number cannot be negative.");
        }
    }
}
