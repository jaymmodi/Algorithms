package Recursion.Backtracking;

public class MaxIslandArea {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        if (grid == null || rows == 0 || cols == 0) {
            return 0;
        }

        int max = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, rows, cols, 0, visited);

                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] grid, int rowIndex, int colIndex, int rows, int cols, int area, boolean[][] visited) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= rows || colIndex >= cols || grid[rowIndex][colIndex] == 0 || visited[rowIndex][colIndex]) {
            return area;
        }

        visited[rowIndex][colIndex] = true;
        area++;

        area = dfs(grid, rowIndex, colIndex + 1, rows, cols, area, visited); // go right
        area = dfs(grid, rowIndex, colIndex - 1, rows, cols, area, visited); // go left
        area = dfs(grid, rowIndex + 1, colIndex, rows, cols, area, visited); // go down
        area = dfs(grid, rowIndex - 1, colIndex, rows, cols, area, visited); // go up

        return area;
    }
}
