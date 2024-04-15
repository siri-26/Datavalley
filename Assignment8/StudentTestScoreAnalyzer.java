import java.util.*;

public class StudentTestScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> scores = new ArrayList<>();

        // Input number of student test scores
        System.out.print("Enter the number of student test scores: ");
        int numOfScores = scanner.nextInt();

        // Input student test scores
        for (int i = 1; i <= numOfScores; i++) {
            System.out.print("Enter test score for student " + i + ": ");
            int score = scanner.nextInt();
            scores.add(score);
        }

        // Analyze student test scores
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / numOfScores;

        // Sort the scores
        Collections.sort(scores);

        // Calculate median
        double median;
        if (numOfScores % 2 == 0) {
            median = (scores.get(numOfScores / 2 - 1) + scores.get(numOfScores / 2)) / 2.0;
        } else {
            median = scores.get(numOfScores / 2);
        }

        // Count number of students above, at, and below the average
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            } else if (score == average) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Display results
        System.out.println("\nStudent Test Score Analysis:");
        System.out.println("Number of students who scored above the average: " + aboveAverageCount + ", Median: " + median);
        System.out.println("Number of students who scored at the average: " + atAverageCount + ", Median: " + median);
        System.out.println("Number of students who scored below the average: " + belowAverageCount + ", Median: " + median);

        scanner.close();
    }
}
