package koviiv.monads.basics.chapter5;

import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    public static final Map<Long, Long> CACHE = new HashMap<>();
    static {
        CACHE.put(1L, 1L);
        CACHE.put(2L, 1L);
    }

    public static void main(String[] args) {
        logTask(3, "Fibonacci number via computeIfAbsent");
        System.out.println("Trying to take from cache");
        fibonacci(5L);
        System.out.println("Trying to take from cache");
        fibonacci(3L);
        System.out.println("Trying to take from cache");
        fibonacci(1L);
        System.out.println("Trying to take from cache");
        fibonacci(4L);
        System.out.println("Trying to take from cache");
        fibonacci(8L);
        System.out.println("Trying to take from cache");
        fibonacci(6L);
    }

    public static Long fibonacci(long index) {
        Long value = CACHE.computeIfAbsent(index, i -> fibonacci(i-1) + fibonacci(i - 2));
        System.out.println(String.format("Calculating fibonacci(%s) = %s", index, value));
        return value;
    }
}