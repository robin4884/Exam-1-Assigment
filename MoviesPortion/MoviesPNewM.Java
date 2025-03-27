
public class MoviesPNewM {
    public static void main(String[] args) {
        MoviesPMath manager = new MoviesPMath();

        manager.addMovie("Inception");
        manager.addMovie("The Matrix");
        manager.addRating("Inception", 5);
        manager.addRating("Inception", 4);
        manager.addRating("The Matrix", 3);
        manager.generateRandomRating("The Matrix");
        manager.displayMovieRatings();
    }
} 