package Arrays;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ListTry {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        Function<Integer, Integer> function = (a) -> (int) Math.pow(a, 2);

        System.out.println(biFunction.apply(1, 2));
        System.out.println(biFunction.andThen(function).apply(1, 2));

        System.out.println(IntStream.rangeClosed(1, 10)
                .boxed()
                .reduce(0, (x, y) -> x + y));
    }
}
