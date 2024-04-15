import java.util.*;

class Restaurant {
    private double rating;

    public Restaurant(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Restaurant> restaurants = new ArrayList<>();

        // Input number of restaurants
        System.out.print("Enter the number of restaurants: ");
        int numOfRestaurants = scanner.nextInt();

        // Input restaurant details
        for (int i = 1; i <= numOfRestaurants; i++) {
            System.out.println("Enter details for restaurant " + i + ":");
            System.out.print("Rating (1-10): ");
            double rating = scanner.nextDouble();
            restaurants.add(new Restaurant(rating));
        }

        // Analyze restaurant ratings
        int[] ratingRangeCounts = new int[11]; // Index 1-10 for ratings 1-10
        double[] ratingRangeSums = new double[11];

        for (Restaurant restaurant : restaurants) {
            double rating = restaurant.getRating();
            if (rating >= 1 && rating <= 10) {
                int index = (int) rating;
                ratingRangeCounts[index]++;
                ratingRangeSums[index] += rating;
            }
        }

        // Calculate average rating for each range
        double[] averageRatingRange = new double[11];
        for (int i = 1; i <= 10; i++) {
            if (ratingRangeCounts[i] > 0) {
                averageRatingRange[i] = ratingRangeSums[i] / ratingRangeCounts[i];
            }
        }

        // Display results
        System.out.println("\nRestaurant Rating Analysis:");
        for (int i = 1; i <= 10; i++) {
            int lowerBound = i;
            int upperBound = i;
            if (i < 10) {
                upperBound = i + 1;
            }
            System.out.println("Rating range: " + lowerBound + " - " + upperBound);
            System.out.println("Number of restaurants rated: " + ratingRangeCounts[i]);
            System.out.println("Average rating: " + averageRatingRange[i]);
            System.out.println();
        }

        scanner.close();
    }
}
