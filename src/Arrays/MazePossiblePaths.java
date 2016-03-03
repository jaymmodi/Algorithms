package Arrays;


public class MazePossiblePaths {

    public static void main(String[] args) {
        System.out.println(findPaths(0, 0, 2, 2));
    }

    private static int findPaths(int row, int col, int m, int n) {
        if (row == m && col == n) {
            return 1;
        }
        if (row > m || col > n) {
            return 0;
        } else {
            return findPaths(row + 1, col, m, n) + findPaths(row + 1, col + 1, m, n) + findPaths(row, col + 1, m, n);
        }

    }

}
