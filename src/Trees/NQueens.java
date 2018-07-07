package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        if (n == 0 || n == 2) {
            return result;
        }

        if (n == 1) {
            result.add(Collections.singletonList("Q"));

            return result;
        }

        Board board = new Board();
        char[][] positions = new Board().createBoard(n);

        solveNQueensHelper(positions, n, 0, result, board);

        return result;
    }

    private static void solveNQueensHelper(char[][] positions, int n, int column, List<List<String>> result, Board board) {
        if (column >= n) {
            result.add(board.getBoardAsList(positions));
        } else {

            for (int row = 0; row < n; row++) {
                if (board.isSafe(row, column, positions)) {
                    board.placeQueen(row, column, positions);
                    solveNQueensHelper(positions, n, column + 1, result, board);
                    board.removeQueen(row, column, positions);
                }
            }
        }
    }
}
