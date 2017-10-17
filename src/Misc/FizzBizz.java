package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBizz {

    public static void main(String[] args) {
//        fizzBuzz(15).forEach(System.out::println);
        withStream(15).forEach(System.out::println);
    }

    public static List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }

        return result;
    }

    public static List<String> withStream(int n) {

        return IntStream.rangeClosed(1, n)
                .parallel()
                .mapToObj((int i) -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        return "FizzBuzz";
                    } else if (i % 3 == 0) {
                        return "Fizz";
                    } else if (i % 5 == 0) {
                        return "Buzz";
                    } else {
                        return "" + i;
                    }
                })
                .collect(Collectors.toList());
    }
}
