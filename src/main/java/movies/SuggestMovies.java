package movies;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SuggestMovies {

    Set<String> getMovies();
    Map<String, Set<String>> getFriendsName();
    List<String> suggestMoviesByStream(Map<String, Set<String>> movies);
    void printSuggestedMovies(List<String> bestMovies);
    List<String> suggestMoviesByCycles(Map<String, Set<String>> moviesByFriendMap);
}
