package Recursion.Backtracking;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);

                    ++count;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int rowIndex, int colIndex, boolean[][] visited) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= grid.length || colIndex >= grid[0].length || visited[rowIndex][colIndex]) {
            return;
        }

        if (grid[rowIndex][colIndex] == '1') {
            visited[rowIndex][colIndex] = true;

            dfs(grid, rowIndex, colIndex + 1, visited); // go right
            dfs(grid, rowIndex, colIndex - 1, visited); // go left
            dfs(grid, rowIndex + 1, colIndex, visited); // go down
            dfs(grid, rowIndex - 1, colIndex, visited); // go up
        }
    }
}
