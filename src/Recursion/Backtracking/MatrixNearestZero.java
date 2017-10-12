package Recursion.Backtracking;

import java.util.Arrays;

public class MatrixNearestZero {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1},
                {1, 1, 1},
                {1, 0, 1}};

        int result[][] = updateMatrix(matrix);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (matrix == null || (rows == 0 && cols == 0)) {
            return new int[0][0];
        }

        int result[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE - 100000);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    if (i > 0) {
                        result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    }

                    if (j > 0) {
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }

                if (j < cols - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        return result;
    }
}

