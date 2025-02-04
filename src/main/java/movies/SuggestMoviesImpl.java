package movies;
import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

public class SuggestMoviesImpl implements SuggestMovies {

    public Set<String> getMovies() {
        Set<String> bestMovies = new LinkedHashSet<>();
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Write the name of a movie o type q to quit");
            String movie = scanner.nextLine();
            if (movie.equals("q")) {
                quit = true;
            } else {
                bestMovies.add(movie);
            }
        } while (!quit);

        return bestMovies;
    }

    public Map<String, Set<String>> getFriendsName() {
        Map<String, Set<String>> friendsMovies = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        do {
            System.out.println("Write your friend's name or q to quit");
            String name = scanner.nextLine();
            if (name.equals("q")) {
                quit = true;
            } else {
                friendsMovies.put(name,getMovies());
            }
        } while (!quit);

        return friendsMovies;
    }

    public List<String> suggestMoviesByStream(Map<String, Set<String>> moviesByFriendMap) {
        Map<String, Integer> movieWithFrequencyMap = new HashMap<>();

        for (Set<String> moviesList : moviesByFriendMap.values()) {
            for (String movie : moviesList) {
                movieWithFrequencyMap.put(movie, movieWithFrequencyMap.getOrDefault(movie, 0) + 1);
            }
        }

        // List<Map.Entry<String, Integer>> orderedMovies = new ArrayList<>(movieWithFrequencyMap.entrySet());
        // List<String> recommendedMovies = new ArrayList<>();

        Map<String, Integer> orderedMap = movieWithFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(bestMovies -> bestMovies.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (newValue, oldValue) -> oldValue, LinkedHashMap::new
                )).reversed();

        return orderedMap.keySet().stream().toList();

/*
        for (Map.Entry<String, Integer> movie: orderedMovies) {
            if (movie.getValue() > 1) {
                recommendedMovies.add(movie.getKey());
            }
        }
        if (recommendedMovies.isEmpty()) {
            for (Map.Entry<String, Integer> movie: orderedMovies) {
                    recommendedMovies.add(movie.getKey());
            }
        }

        return recommendedMovies;
 */
    }

    public List<String> suggestMoviesByCycles(Map<String, Set<String>> moviesByFriendMap) {
        Map<String, Integer> movieWithFrequencyMap = new HashMap<>();

        for (Set<String> moviesList : moviesByFriendMap.values()) {
            for (String movie : moviesList) {
                movieWithFrequencyMap.put(movie, movieWithFrequencyMap.getOrDefault(movie, 0) + 1);
            }
        }

        List<Map.Entry<String,Integer>> entryMoviesList = new ArrayList<>(movieWithFrequencyMap.entrySet());

        Map.Entry<String,Integer> entryMovie1 = null;
        Map.Entry<String,Integer> entryMovie2 = null;
        Map.Entry<String, Integer> auxEntry = null;

        for (int i = 0; i < entryMoviesList.size()-1; i++) {
            for (int j = 0; j < entryMoviesList.size()-1-i ; j++) {
                entryMovie1 = entryMoviesList.get(j);
                entryMovie2 = entryMoviesList.get(j+1);
                if (entryMovie1.getValue() < entryMovie2.getValue()) {
                    auxEntry = entryMovie1;
                    entryMoviesList.set(j, entryMovie2);
                    entryMoviesList.set(j+1, auxEntry);
                } else if (entryMovie1.getValue().equals(entryMovie2.getValue())) {
                    char[] movie1Array = entryMovie1.toString().toCharArray();
                    char[] movie2Array = entryMovie2.toString().toCharArray();
                    for (int k = 0; k < movie1Array.length; k++) {
                        if (movie2Array[k] < movie1Array[k]) {
                            auxEntry = entryMovie1;
                            entryMoviesList.set(j, entryMovie2);
                            entryMoviesList.set(j+1, auxEntry);
                            break;
                        } else if (movie2Array[k] > movie1Array[k]) {
                            break;
                        }
                    }
                }
            }
        }

        List<String> suggestedMoviesList = new ArrayList<>();

        for (Map.Entry<String, Integer> movies: entryMoviesList) {
            suggestedMoviesList.add(movies.getKey());
        }

        return suggestedMoviesList;
    }

    public void printSuggestedMovies(List<String> bestMovies) {
        System.out.println("You should watch: ");
        int num = 1;
        for (String movie: bestMovies) {
            System.out.println(num + movie);
            num++;
        }
    }
}
