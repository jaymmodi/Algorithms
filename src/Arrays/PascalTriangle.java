package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        printPascal(7);
    }

    public static void printPascal(int level) {
        List<List<Integer>> lists = printHelper(level);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> printHelper(int level) {
        List<List<Integer>> result = new ArrayList<>();
        if (level >= 1) {
            result.add(Arrays.asList(1));

        }

        if (level >= 2) {
            result.add(Arrays.asList(1, 1));
        }

        if (level >= 3) {
            for (int i = 3; i <= level; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);

                List<Integer> prev = result.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    int currentNumber = prev.get(j) + prev.get(j - 1);
                    temp.add(currentNumber);
                }

                temp.add(1);
                result.add(temp);
            }
        }

        return result;
    }
}
