package Trees;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public char[][] createBoard(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }

        }

        return board;
    }

    public List<String> getBoardAsList(char[][] board) {
        List<String> result = new ArrayList<>();

        for (char[] row : board) {
            result.add(new String(row));
        }

        return result;
    }

    public void placeQueen(int rowIndex, int columnIndex, char[][] board) {
        board[rowIndex][columnIndex] = 'Q';
    }

    public void removeQueen(int rowIndex, int columnIndex, char[][] board) {
        board[rowIndex][columnIndex] = '.';
    }

    public boolean isSafe(int rowIndex, int columnIndex, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][columnIndex] == 'Q' || board[rowIndex][i] == 'Q') {
                return false;
            }
        }

        // going diagonally left up
        int i = rowIndex;
        int j = columnIndex;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }

        // going diagonally right down
        i = rowIndex;
        j = columnIndex;
        while (i <= board.length - 1 && j <= board[0].length - 1) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i++;
            j++;
        }

        // going diagonally right up
        i = rowIndex;
        j = columnIndex;
        while (i >= 0 && j <= board[0].length - 1) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j++;
        }

        // going diagonally left down
        i = rowIndex;
        j = columnIndex;
        while (i <= board.length - 1 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i++;
            j--;
        }


        return true;
    }

}
