package koviiv.monads.basics.chapter3;

import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task7 {

    private static final AtomicInteger COMPLEXITY_CYCLES_CACHED_DATA = new AtomicInteger(0);
    private static final AtomicInteger COMPLEXITY_CYCLES_FOR_EMPTY_DATA = new AtomicInteger(0);
    private static final AtomicInteger COMPLEXITY_CYCLES_INNER_STREAM = new AtomicInteger(0);

    public static void main(String[] args) {
        logTask(7);
        List<String> strings = List.of("a1", "asd3", "as2", "qwer4", "qweas6", "asdf4", "zx2");

        System.out.println("\n----------");
        System.out.println(String.format("findLongestStringU_CachedData(%s) = %s", strings, findLongestString_CachedData(strings, COMPLEXITY_CYCLES_CACHED_DATA)));
        System.out.println("Comparator was called() " + COMPLEXITY_CYCLES_CACHED_DATA);

        System.out.println("\n----------");
        System.out.println(String.format("findLongestStringU_CachedData([empty]) = %s", findLongestString_CachedData(List.of(), COMPLEXITY_CYCLES_FOR_EMPTY_DATA)));
        System.out.println("Complexity " + COMPLEXITY_CYCLES_FOR_EMPTY_DATA);

        System.out.println("\n----------");
        System.out.println(String.format("findLongestString_WithInnerStream([%s]) = %s", strings, findLongestString_WithInnerStream(strings, COMPLEXITY_CYCLES_INNER_STREAM)));
        System.out.println("Complexity " + COMPLEXITY_CYCLES_INNER_STREAM);
    }


    public static String findLongestString_CachedData(List<String> strings, AtomicInteger complexity) {
        return strings.stream()
                .collect(Collectors.toMap(Function.identity(), Task7::countLowercaseLetters))
                .entrySet().stream()
                .max(compareNumberOfLetters(complexity))
                .map(Entry::getKey).orElse("Nothing have been found");
    }

    public static Comparator<Map.Entry<String, Long>> compareNumberOfLetters(AtomicInteger complexity) {
        return (max, next) -> {
            // countLowercaseLetters() is called only once time for each element. On the other side we need additional data structures for optimizing
            // because mapping is done outside of Comparator
            complexity.incrementAndGet();
            return max.getValue().compareTo(next.getValue());
        };
    }

    public static long countLowercaseLetters(String string) {
        return string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    public static String findLongestString_WithInnerStream(List<String> strings, AtomicInteger complexity) {
        return strings.stream().max(Comparator.comparing(s -> {
                    complexity.incrementAndGet();
                    // countLowercaseLetters is called twice, because it is used inside of Comparator.
                    return countLowercaseLetters(s);
                })).orElse("Nothing have been found");
    }

}
