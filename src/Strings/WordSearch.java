package Strings;

import java.util.*;

import static java.util.Arrays.asList;

public class WordSearch {

    public static void main(String[] args) {
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };

        char[][] board = {
                {'a', 'b'},
                {'a', 'a'}
        };

        List<String> words = asList("aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba");
        List<String> words1 = findWords(board, words);

        for (String s : words1) {
            System.out.println(s);
        }
    }

    private static List<String> findWords(char[][] board, List<String> words) {
        int rowSize = board.length;
        int columnSize = board[0].length;

        Set<String> uniqueWords = new HashSet<>(words);

        List<String> result = new ArrayList<>();

        for (String word : uniqueWords) {

            LinkedList<CurrentString> startStrings = new LinkedList<>();
            boolean innerBreak = false;
            for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
                for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                    boolean[][] visited = new boolean[rowSize][columnSize];

                    String boardCharString = String.valueOf(board[rowIndex][columnIndex]);
                    visited[rowIndex][columnIndex] = true;
                    if (word.contains(boardCharString)) {
                        startStrings.add(new CurrentString(boardCharString, rowIndex, columnIndex));
                        if (goFindString(startStrings, board, word, rowSize, columnSize, visited)) {
                            result.add(word);
                            innerBreak = true;
                            break;
                        }
                    }

                }
                if (innerBreak) {
                    break;
                }
            }

        }

        return result;
    }

    private static boolean goFindString(LinkedList<CurrentString> startStrings, char[][] board, String word, int rowSize, int columnSize, boolean[][] visited) {

        boolean isMatch = false;
        while (!startStrings.isEmpty()) {
            CurrentString currentString = startStrings.poll();
            if (currentString.str.equals(word)) {
                isMatch = true;
                break;
            }

            if (currentString.lastColumnIndex < columnSize - 1 && !visited[currentString.lastRowIndex][currentString.lastColumnIndex + 1]) { // right neighbor
                String rightNeighbor = String.valueOf(getNextHorizontalRight(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + rightNeighbor;

                if (word.contains(updatedString)) {
                    visited[currentString.lastRowIndex][currentString.lastColumnIndex + 1] = true;
                    startStrings.add(new CurrentString(updatedString, currentString.lastRowIndex, currentString.lastColumnIndex + 1));
                }
            }

            if (currentString.lastColumnIndex > 0 && !visited[currentString.lastRowIndex][currentString.lastColumnIndex - 1]) { // left neighbor
                String leftNeighbor = String.valueOf(getNextHorizontalLeft(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + leftNeighbor;

                if (word.contains(updatedString)) {
                    visited[currentString.lastRowIndex][currentString.lastColumnIndex - 1] = true;
                    startStrings.add(new CurrentString(updatedString, currentString.lastRowIndex, currentString.lastColumnIndex - 1));
                }
            }

            if (currentString.lastRowIndex < rowSize - 1 && !visited[currentString.lastRowIndex + 1][currentString.lastColumnIndex]) { // down neighbor
                String downNeighbor = String.valueOf(getNextVerticalDown(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + downNeighbor;

                if (word.contains(updatedString)) {
                    visited[currentString.lastRowIndex + 1][currentString.lastColumnIndex] = true;
                    startStrings.add(new CurrentString(updatedString, currentString.lastRowIndex + 1, currentString.lastColumnIndex));
                }
            }

            if (currentString.lastRowIndex > 0 && !visited[currentString.lastRowIndex - 1][currentString.lastColumnIndex]) { // up neighbor
                String upNeighbor = String.valueOf(getNextVerticalUp(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + upNeighbor;

                if (word.contains(updatedString)) {
                    visited[currentString.lastRowIndex - 1][currentString.lastColumnIndex] = true;
                    startStrings.add(new CurrentString(updatedString, currentString.lastRowIndex - 1, currentString.lastColumnIndex));
                }
            }
        }

        return isMatch;
    }

    private static char getNextHorizontalRight(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex + 1];
    }

    private static char getNextHorizontalLeft(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex - 1];
    }

    private static char getNextVerticalUp(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex - 1][columnIndex];
    }

    private static char getNextVerticalDown(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex + 1][columnIndex];
    }

}
