package koviiv.monads.basics.chapter6;

import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Task1 {

    public static void main(String[] args) {
        logTask(1);
        System.out.println("sequentialSumOfSquares(IntStream.range(1, 3) = " + sequentialSumOfSquares(IntStream.range(1, 3)));
    }

    public static int sequentialSumOfSquares(IntStream range) {
        return range.parallel().map(value -> value * value).sum();
    }
}