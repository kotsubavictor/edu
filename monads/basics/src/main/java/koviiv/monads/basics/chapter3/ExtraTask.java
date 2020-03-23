package koviiv.monads.basics.chapter3;

import static koviiv.monads.basics.model.SampleData.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExtraTask {

    public static void main(String[] args) {

        logTask(8, "map() via reducer");
        List<String> strings = List.of("a1", "asd3", "as2", "qwer4", "qweas6", "asdf4", "zx2", "a1");
        System.out.println("Original collection: " + strings);
        System.out.println("Mapped collection: " + map(strings, s -> Math.random()));
        System.out.println("Mapped collection: " + map(strings, s -> s + "K1"));

        logTask(8, "filter() via reducer");
        System.out.println("Filtered collection: " + filter(strings, s -> s.length() > 4));
    }

    public static <T, R> List<R> map(List<T> strings, Function<T, R> mapper) {
        return strings.stream().parallel().reduce(new ArrayList<R>(), (acc, el) -> {
            // used for accumulating results in a single value.
            // accumulator should not mutate it state
            ArrayList<R> newStrings = new ArrayList<>(acc);
            newStrings.add(mapper.apply(el));
            System.out.println(String.format("1: %s : %s : %s", Thread.currentThread().getId(), acc, el));
            return newStrings;
        }, (left, right) -> {
            // used for combining results in parallel streams
            ArrayList<R> newStrings = new ArrayList<>(left);
            newStrings.addAll(right);
            System.out.println(String.format("2: %s : %s : %s", Thread.currentThread().getId(), left, right));
            return newStrings;
        });
    }

    public static <T> List<T> filter(List<T> strings, Predicate<T> filter) {
        return strings.stream().parallel().reduce(new ArrayList<T>(), (acc, el) -> {
            // used for accumulating results in a single value.
            // accumulator should not mutate it state
            ArrayList<T> newStrings = new ArrayList<>(acc);
            if (filter.test(el)) {
                newStrings.add(el);
            }
            System.out.println(String.format("1: %s : %s : %s", Thread.currentThread().getId(), acc, el));
            return newStrings;
        }, (left, right) -> {
            // used for combining results in parallel streams
            ArrayList<T> newStrings = new ArrayList<>(left);
            newStrings.addAll(right);
            System.out.println(String.format("2: %s : %s : %s", Thread.currentThread().getId(), left, right));
            return newStrings;
        });
    }

}
