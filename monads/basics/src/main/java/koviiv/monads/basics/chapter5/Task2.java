package koviiv.monads.basics.chapter5;

import static koviiv.monads.basics.model.SampleData.logTask;
import static koviiv.monads.basics.model.SampleData.membersOfTheBeatles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import koviiv.monads.basics.model.Artist;

public class Task2 {

    public static void main(String[] args) {
        logTask(2, "A");
        System.out.println(String.format("The longest name from %s is : %s", membersOfTheBeatles, findLongestNameOfArtist(membersOfTheBeatles)));
        System.out.println(String.format("Artist with longest name from %s is : %s", membersOfTheBeatles, findArtistWithLongestName(membersOfTheBeatles)));

        logTask(2, "B");
        List<String> names = List.of("John", "Paul", "George", "John", "Paul", "John");
        System.out.println(String.format("Count occurrences of words in %s : %s", names, countWordOccurrence(names)));

        logTask(2, "C - Custom collector for GroupingBy");
        System.out.println(String.format("Count occurrences of words in %s : %s", names, countWordOccurrenceViaCustomCollector(names)));
    }

    public static Artist findArtistWithLongestName(List<Artist> artists) {
        return artists.stream().collect(Collectors.maxBy(Comparator.comparing(artist -> artist.getName().length()))).orElseThrow();
    }

    public static String findLongestNameOfArtist(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .max(Comparator.comparing(String::length))
                .orElse("Unknown");
    }

    public static Map<String, Long> countWordOccurrence(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, List<String>> countWordOccurrenceViaCustomCollector(List<String> words) {
        return words.stream().parallel().collect(new GroupingBy<>(Function.identity()));
    }

}

class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private Function<T, K> keyExtractor;

    public GroupingBy(Function<T, K> keyExtractor) {
        this.keyExtractor = keyExtractor;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (acc, value) -> {
            List<T> data = acc.computeIfAbsent(keyExtractor.apply(value), k -> new ArrayList<>());
            data.add(value);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (leftMap, rightMap) -> {

            rightMap.entrySet().forEach(entry -> {
                leftMap.merge(entry.getKey(), entry.getValue(), (leftStrings, rightStrings) -> {
                    leftStrings.addAll(rightStrings);
                    return leftStrings;
                });
            });

            return leftMap;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}