package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        return triangle.get(0).get(0) + minimumTotalForHeight(triangle, triangle.size() - 1);
    }


    private static Integer minimumTotalForHeight(List<List<Integer>> triangle, int height) {
        List<Integer> row = triangle.get(triangle.size() - height);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < row.size(); i++) {
            min = Math.min(min, Math.min(row.get(i) + minimumTotalHelperForIndex(triangle, height - 1, i, min), row.get(i) + minimumTotalHelperForIndex(triangle, height - 1, i + 1, min)));
        }

        return min;
    }

    private static Integer minimumTotalHelperForIndex(List<List<Integer>> triangle, int height, int index, int min) {
        if (height == 1) {
            return triangle.get(triangle.size() - 1).get(index);
        }

        return min;
    }
}
