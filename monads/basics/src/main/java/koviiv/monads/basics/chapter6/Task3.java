package koviiv.monads.basics.chapter6;

import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        logTask(1);
        List<Integer> numbers = List.of(1, 2, 3);
        System.out.println(String.format("multiplyThrough(%s) = %s", numbers, multiplyFast(numbers)));
    }

    public static int multiplyFast(List<Integer> numbers) {
        return numbers.parallelStream().mapToInt(value -> value * value).sum();
    }
}