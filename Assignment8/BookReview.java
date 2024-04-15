import java.util.*;

class BookReview {
    private double rating;

    public BookReview(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BookReview> reviews = new ArrayList<>();

        // Input number of book reviews
        System.out.print("Enter the number of book reviews: ");
        int numOfReviews = scanner.nextInt();

        // Input book review details
        for (int i = 1; i <= numOfReviews; i++) {
            System.out.println("Enter details for book review " + i + ":");
            System.out.print("Rating (1-10): ");
            double rating = scanner.nextDouble();
            reviews.add(new BookReview(rating));
        }

        // Analyze book reviews
        int[] ratingRangeCounts = new int[11]; // Index 1-10 for ratings 1-10
        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        for (BookReview review : reviews) {
            double rating = review.getRating();
            if (rating >= 1 && rating <= 10) {
                ratingRangeCounts[(int) rating]++;
                if (rating >= 7) {
                    positiveCount++;
                } else if (rating >= 4) {
                    neutralCount++;
                } else {
                    negativeCount++;
                }
            }
        }

        // Display results
        System.out.println("\nBook Review Analysis:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number of books with " + i + " star(s): " + ratingRangeCounts[i]);
        }
        System.out.println("Number of books with positive reviews: " + positiveCount);
        System.out.println("Number of books with neutral reviews: " + neutralCount);
        System.out.println("Number of books with negative reviews: " + negativeCount);

        scanner.close();
    }
}
