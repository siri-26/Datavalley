import java.util.Scanner;

public class ReplaceCharacterAtIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Index of the character to be replaced
        System.out.print("Enter the index of the character to be replaced: ");
        int index = scanner.nextInt();

        // Input character for replacement
        System.out.print("Enter the character for replacement: ");
        char replacementChar = scanner.next().charAt(0);

        // Check if the index is within the bounds of the string
        if (index < 0 || index >= inputString.length()) {
            System.out.println("Index out of bounds.");
            return;
        }

        // Perform replacement
        String replacedString = replaceCharacterAtIndex(inputString, index, replacementChar);
        System.out.println("String after replacement: " + replacedString);

        scanner.close();
    }

    public static String replaceCharacterAtIndex(String str, int index, char replacementChar) {
        char[] chars = str.toCharArray();
        chars[index] = replacementChar;
        return new String(chars);
    }
}
