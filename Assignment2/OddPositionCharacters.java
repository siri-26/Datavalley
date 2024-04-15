public class OddPositionCharacters {
    public static void main(String[] args) {
        String text = "type here to search";
        printOddPositionCharacters(text);
    }

    public static void printOddPositionCharacters(String text) {
        for (int i = 0; i < text.length(); i++) {
            // Skip white spaces
            if (text.charAt(i) == ' ') {
                continue;
            }
            // Print characters at odd positions
            if (i % 2 != 0) {
                System.out.print(text.charAt(i));
            }
        }
    }
}
