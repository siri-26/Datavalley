import java.util.Scanner;

public class CheckVowelInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Check if vowel is present and count vowels
        boolean isVowelPresent = checkVowelPresence(inputString);
        int vowelCount = countVowels(inputString);

        // Display results
        if (isVowelPresent) {
            System.out.println("Vowels are present in the string.");
            System.out.println("Total number of vowels present: " + vowelCount);
        } else {
            System.out.println("No vowels are present in the string.");
        }

        scanner.close();
    }

    // Method to check if vowel is present in the string
    public static boolean checkVowelPresence(String str) {
        return str.matches(".*[aeiouAEIOU].*");
    }

    // Method to count vowels in the string
    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
