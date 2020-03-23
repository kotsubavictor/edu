package koviiv.monads.basics.chapter3;

import static koviiv.monads.basics.model.SampleData.*;

import koviiv.monads.basics.model.SampleData;

public class Task6 {

    public static void main(String[] args) {

        logTask(6);
        final String data = "The Beatles";
        System.out.println(String.format("Number of characters in lower case for '%s': %s", data, countLowercaseLetters(data)));
    }

    public static long countLowercaseLetters(String string) {
        return string.chars()
                .filter(Character::isLowerCase)
                .count();
    }
}
