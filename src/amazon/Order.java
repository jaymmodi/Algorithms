package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Order {
    public static void main(String[] args) {
        reorder(5, Arrays.asList("t2 13 121 98", "r1 box ape bit", "r2 box ape bit", "b4 xi me nu", "br8 eat nim did", "w1 has uni gry", "f3 52 54 31")).forEach(System.out::println);
    }

    public static List<String> reorder(int logFileSize, List<String> logLines) {
        List<String> result = new ArrayList<>();

        List<String> allNumbersLines = logLines.stream()
                .filter(Order::allNumbers)
                .collect(Collectors.toList());

        List<String> allWordsLines = logLines.stream()
                .filter(Order::allWords)
                .collect(Collectors.toList());


        List<String> collect = customComparator(allWordsLines);

        result.addAll(collect);
        result.addAll(allNumbersLines);

        return result;
    }

    private static List<String> customComparator(List<String> allWordsLines) {
        return allWordsLines.stream().sorted((s1, s2) -> {
            String[] s1Array = s1.split(" ");
            String[] s2Array = s2.split(" ");
            StringBuilder formattedStr1 = new StringBuilder();
            StringBuilder formattedStr2 = new StringBuilder();

            for (int i = 1; i < s1Array.length; i++) {
                formattedStr1.append(s1Array[i]).append(" ");
            }

            for (int i = 1; i < s2Array.length; i++) {
                formattedStr2.append(s2Array[i]).append(" ");
            }

            if (formattedStr1.toString().equals(formattedStr2.toString())) {
                formattedStr1.append(s1Array[0]);
                formattedStr2.append(s2Array[0]);
            }

            return formattedStr1.toString().trim().compareTo(formattedStr2.toString().trim());

        }).collect(Collectors.toList());
    }


    private static boolean allWords(String line) {
        String[] split = line.split(" ");

        return IntStream.range(1, split.length)
                .allMatch(i -> split[i].matches("[A-Za-z]*"));
    }

    private static boolean allNumbers(String line) {
        String[] split = line.split(" ");

        return IntStream.range(1, split.length)
                .allMatch(i -> split[i].matches("[0-9]*"));
    }
}