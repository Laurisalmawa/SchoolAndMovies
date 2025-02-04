package movies;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SuggestMoviesTest {

    SuggestMovies friendsMovies = new SuggestMoviesImpl();

    @Test
    void whenNoSameMoviesThenSuggestAll() {

        Set<String> danielMovies = new LinkedHashSet<>();
        danielMovies.add("Deadpool");
        danielMovies.add("Matrix");

        Set<String> cristianMovies = new LinkedHashSet<>();
        danielMovies.add("MadMax");
        danielMovies.add("Endgame");

        Set<String> davidMovies = new LinkedHashSet<>();
        danielMovies.add("Wolverine");
        danielMovies.add("Back to the future");


        Map<String, Set<String>> friendsAndMovies = new LinkedHashMap<>();
        friendsAndMovies.put("Daniel", danielMovies);
        friendsAndMovies.put("Cristian", cristianMovies);
        friendsAndMovies.put("David", davidMovies);

        List<String> expected = new ArrayList<>();
        expected.add("Deadpool");
        expected.add("Matrix");
        expected.add("MadMax");
        expected.add("Endgame");
        expected.add("Wolverine");
        expected.add("Back to the future");

        List<String> result = friendsMovies.suggestMoviesByStream(friendsAndMovies);
        assertEquals(expected, result);
    }

    @Test
    void whenSameMoviesThenSuggestByFrequency() {

        Map<String, Set<String>> moviesByFriendMap = new HashMap<>();
        moviesByFriendMap.put("Daniel", Set.of("DeadPool", "Matrix"));
        moviesByFriendMap.put("Cristian", Set.of("Endgame", "Matrix"));
        moviesByFriendMap.put("David", Set.of("DeadPool", "Matrix"));

        List<String> expected = new ArrayList<>();
        expected.add("Matrix");
        expected.add("DeadPool");

        List<String> result = friendsMovies.suggestMoviesByStream(moviesByFriendMap);

        assertEquals(expected, result);
    }

    @Test
    void whenSameMoviesThenSuggestByFrequencyByCycles() {

        Map<String, Set<String>> moviesByFriendMap = new HashMap<>();
        moviesByFriendMap.put("Daniel", Set.of("DeadPool", "Matrix", "MadMax"));
        moviesByFriendMap.put("Cristian", Set.of("Endgame", "Matrix"));
        moviesByFriendMap.put("David", Set.of("DeadPool", "Matrix", "Big Hero 6"));

        List<String> expected = new ArrayList<>();
        expected.add("Matrix");
        expected.add("DeadPool");
        expected.add("Big Hero 6");
        expected.add("Endgame");
        expected.add("MadMax");

        List<String> result = friendsMovies.suggestMoviesByCycles(moviesByFriendMap);
        assertEquals(expected, result);
    }
}