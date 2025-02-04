package movies;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Netflix {

    public static void main(String[] args) {

        SuggestMovies suggestMovies = new SuggestMoviesImpl();
        Map<String, Set<String>> friendsMovies = suggestMovies.getFriendsName();
        List<String> bestMovies = suggestMovies.suggestMoviesByStream(friendsMovies);
        suggestMovies.printSuggestedMovies(bestMovies);
    }
}
