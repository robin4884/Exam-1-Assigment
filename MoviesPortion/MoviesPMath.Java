/* Here will be all the math for the rating and random rating for MovieP*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MoviesPMath {
    private ArrayList<String> movies;
    private HashMap<String, ArrayList<Integer>> ratings;
    private Random random;

    public MoviesPMath() {
        movies = new ArrayList<>();
        ratings = new HashMap<>();
        random = new Random();
    }

    public void addMovie(String movieName) {
        if (!movies.contains(movieName)) {
            movies.add(movieName);
            ratings.put(movieName, new ArrayList<>());
            System.out.println("Movie added: " + movieName);
        } else {
            System.out.println("Movie already exists: " + movieName);
        }
    }

    public void addRating(String movieName, int rating) {
        if (!ratings.containsKey(movieName)) {
            System.out.println("Error: Movie not found - " + movieName);
            return;
        }
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
            return;
        }
        ratings.get(movieName).add(rating);
        System.out.println("Rating added: " + rating + " to " + movieName);
    }

    public void generateRandomRating(String movieName) {
        if (!ratings.containsKey(movieName)) {
            System.out.println("Error: Movie not found - " + movieName);
            return;
        }
        int randomRating = random.nextInt(5) + 1; // 1 to 5
        ratings.get(movieName).add(randomRating);
        System.out.println("Random rating added: " + randomRating + " to " + movieName);
    }

    public void displayMovieRatings() {
        for (String movie : movies) {
            ArrayList<Integer> movieRatings = ratings.get(movie);
            if (movieRatings.isEmpty()) {
                System.out.println(movie + " has no ratings.");
                continue;
            }
            double sum = 0;
            for (int rating : movieRatings) {
                sum += rating;
            }
            double avg = sum / movieRatings.size();
            double roundedAvg = Math.round(avg * 10.0) / 10.0; // round to 1 decimal
            System.out.println(movie + " - Average Rating: " + roundedAvg);
        }
    }

    public boolean movieExists(String movieName) {
        return ratings.containsKey(movieName);
    }
} 


