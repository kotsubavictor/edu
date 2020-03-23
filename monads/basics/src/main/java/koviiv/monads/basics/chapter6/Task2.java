package koviiv.monads.basics.chapter6;

import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.List;
import java.util.stream.IntStream;

public class Task2 {

    public static void main(String[] args) {
        logTask(2);
        List<Integer> numbers = List.of(1, 2, 3);
        System.out.println(String.format("multiplyThrough(%s) = %s", numbers, multiplyThrough(numbers)));
        System.out.println(String.format("multiplyThroughParallel(%s) = %s", numbers, multiplyThroughParallel(numbers)));
    }

    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }

    public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().parallel()
                .reduce(1, (acc, x) -> x * acc) * 5;
    }
}