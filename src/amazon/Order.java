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


        List<String> lowercaseAfterSort = customComparator(allWordsLines);

        result.addAll(lowercaseAfterSort);
        result.addAll(allNumbersLines);

        return result;
    }

    private static List<String> customComparator(List<String> allWordsLines) {
        return allWordsLines.stream().sorted((s1, s2) -> {
            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int i = 1; i < split1.length; i++) {
                sb1.append(split1[i]).append(" ");
            }

            for (int i = 1; i < split2.length; i++) {
                sb2.append(split2[i]).append(" ");
            }

            if (sb1.toString().equals(sb2.toString())) {
                sb1.append(split1[0]);
                sb2.append(split2[0]);
            }

            return sb1.toString().trim().compareTo(sb2.toString().trim());

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