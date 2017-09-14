package Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}
        };

        List<String> words = asList("eaabcdgfa");
        WordSearch wordSearch = new WordSearch();
        List<String> words1 = wordSearch.findWords(board, words);

        for (String s : words1) {
            System.out.println(s);
        }
    }

    private List<String> findWords(char[][] board, List<String> words) {
        int rowSize = board.length;
        int columnSize = board[0].length;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String found = findWord(board, rowSize, columnSize, word);
            if (null != found && !result.contains(found)) {
                result.add(found);
            }
        }

        return result;
    }

    private String findWord(char[][] board, int rowSize, int columnSize, String word) {
        LinkedList<CurrentString> queue = new LinkedList<>();

        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                boolean[][] visited = new boolean[rowSize][columnSize];

                String boardCharString = String.valueOf(board[rowIndex][columnIndex]);

                if (word.startsWith(boardCharString)) {
                    visited[rowIndex][columnIndex] = true;
                    queue.add(new CurrentString(boardCharString, rowIndex, columnIndex, visited));
                    if (bfs(queue, board, word, rowSize, columnSize)) {
                        return word;
                    }
                }

            }
        }
        return null;
    }

    private boolean bfs(LinkedList<CurrentString> queue, char[][] board, String word, int rowSize, int columnSize) {

        boolean isMatch = false;
        while (!queue.isEmpty()) {
            CurrentString currentString = queue.poll();
            if (currentString.str.equals(word)) {
                isMatch = true;
                break;
            }

            if (currentString.lastColumnIndex < columnSize - 1 && !currentString.visited[currentString.lastRowIndex][currentString.lastColumnIndex + 1]) { // right neighbor
                String rightNeighbor = String.valueOf(getNextHorizontalRight(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + rightNeighbor;

                if (word.startsWith(updatedString)) {
                    boolean[][] updatedVisited = copyArray(currentString.visited);
                    updatedVisited[currentString.lastRowIndex][currentString.lastColumnIndex + 1] = true;
                    queue.add(new CurrentString(updatedString, currentString.lastRowIndex, currentString.lastColumnIndex + 1, updatedVisited));
                }
            }

            if (currentString.lastColumnIndex > 0 && !currentString.visited[currentString.lastRowIndex][currentString.lastColumnIndex - 1]) { // left neighbor
                String leftNeighbor = String.valueOf(getNextHorizontalLeft(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + leftNeighbor;

                if (word.startsWith(updatedString)) {
                    boolean[][] updatedVisited = copyArray(currentString.visited);
                    updatedVisited[currentString.lastRowIndex][currentString.lastColumnIndex - 1] = true;
                    queue.add(new CurrentString(updatedString, currentString.lastRowIndex, currentString.lastColumnIndex - 1, updatedVisited));
                }
            }

            if (currentString.lastRowIndex < rowSize - 1 && !currentString.visited[currentString.lastRowIndex + 1][currentString.lastColumnIndex]) { // down neighbor
                String downNeighbor = String.valueOf(getNextVerticalDown(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + downNeighbor;

                if (word.startsWith(updatedString)) {
                    boolean[][] updatedVisited = copyArray(currentString.visited);
                    updatedVisited[currentString.lastRowIndex + 1][currentString.lastColumnIndex] = true;
                    queue.add(new CurrentString(updatedString, currentString.lastRowIndex + 1, currentString.lastColumnIndex, updatedVisited));
                }
            }

            if (currentString.lastRowIndex > 0 && !currentString.visited[currentString.lastRowIndex - 1][currentString.lastColumnIndex]) { // up neighbor
                String upNeighbor = String.valueOf(getNextVerticalUp(board, currentString.lastRowIndex, currentString.lastColumnIndex));
                String updatedString = currentString.str + upNeighbor;

                if (word.startsWith(updatedString)) {
                    boolean[][] updatedVisited = copyArray(currentString.visited);
                    updatedVisited[currentString.lastRowIndex - 1][currentString.lastColumnIndex] = true;
                    queue.add(new CurrentString(updatedString, currentString.lastRowIndex - 1, currentString.lastColumnIndex, updatedVisited));
                }
            }
        }

        return isMatch;
    }

    private char getNextHorizontalRight(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex + 1];
    }

    private char getNextHorizontalLeft(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex - 1];
    }

    private char getNextVerticalUp(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex - 1][columnIndex];
    }

    private char getNextVerticalDown(char[][] board, int rowIndex, int columnIndex) {
        return board[rowIndex + 1][columnIndex];
    }

    private boolean[][] copyArray(boolean[][] input) {
        boolean[][] newArray = new boolean[input.length][];

        for (int i = 0; i < input.length; i++) {
            newArray[i] = input[i].clone();
        }

        return newArray;
    }

}
