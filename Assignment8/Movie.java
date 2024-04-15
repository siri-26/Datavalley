import java.util.*;

class Movie {
    private String category;
    private double rating;

    public Movie(String category, double rating) {
        this.category = category;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class MovieRatingAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Movie> movies = new ArrayList<>();

        // Input number of movies
        System.out.print("Enter the number of movies: ");
        int numOfMovies = scanner.nextInt();

        // Input movie details
        for (int i = 1; i <= numOfMovies; i++) {
            System.out.println("Enter details for movie " + i + ":");
            System.out.print("Category: ");
            String category = scanner.next();
            System.out.print("Rating: ");
            double rating = scanner.nextDouble();
            movies.add(new Movie(category, rating));
        }

        // Analyze movie ratings
        Map<String, List<Double>> ratingMap = new HashMap<>();
        for (Movie movie : movies) {
            String category = movie.getCategory();
            double rating = movie.getRating();
            ratingMap.putIfAbsent(category, new ArrayList<>());
            ratingMap.get(category).add(rating);
        }

        // Calculate average rating for each category
        Map<String, Double> averageRatingMap = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : ratingMap.entrySet()) {
            String category = entry.getKey();
            List<Double> ratings = entry.getValue();
            double sum = 0;
            for (double rating : ratings) {
                sum += rating;
            }
            double averageRating = sum / ratings.size();
            averageRatingMap.put(category, averageRating);
        }

        // Display results
        System.out.println("\nMovie Rating Analysis:");
        for (Map.Entry<String, List<Double>> entry : ratingMap.entrySet()) {
            String category = entry.getKey();
            int numberOfMovies = entry.getValue().size();
            double averageRating = averageRatingMap.get(category);
            System.out.println("Category: " + category);
            System.out.println("Number of movies rated: " + numberOfMovies);
            System.out.println("Average rating: " + averageRating);
            System.out.println();
        }

        scanner.close();
    }
}
