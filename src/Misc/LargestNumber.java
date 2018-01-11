package Misc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {
    public static void main(String[] args) {

        int[] integers = {30, 3};

        String collect = Arrays.stream(integers)
                .boxed()
                .map(String::valueOf)
                .sorted((s1, s2) -> {
                    String str1 = s1 + s2;
                    String str2 = s2 + s1;

                    System.out.println(str2.compareTo(str1));
                    return str2.compareTo(str1);
                })
                .collect(Collectors.joining());

        if (collect.startsWith("0")) {
            System.out.println("0");
        } else {
            System.out.println(collect);
        }

    }
}
