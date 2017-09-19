package Strings;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {"ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray()};

        String word = "ABCESEEEFS";
        WordSearch wordSearch = new WordSearch();
        wordSearch.findWord(board, word);

        System.out.println(wordSearch.findWord(board, word));
    }

    public boolean findWord(char[][] board, String word) {
        boolean found = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, visited, word, "", i, j)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        return found;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, String str, int rowIndex, int columnIndex) {
        int rowSize = board.length;
        int columnSize = board[0].length;

        if (rowIndex < 0 || columnIndex < 0 || rowIndex > rowSize - 1 || columnIndex > columnSize - 1) {
            return false;
        }

        if (visited[rowIndex][columnIndex]) {
            return false;
        }

        str = str + board[rowIndex][columnIndex];

        if (!word.startsWith(str)) {
            return false;
        }

        if (word.equals(str)) {
            return true;
        }

        visited[rowIndex][columnIndex] = true;

        boolean found = dfs(board, visited, word, str, rowIndex, columnIndex + 1) || dfs(board, visited, word, str, rowIndex, columnIndex - 1) || dfs(board, visited, word, str, rowIndex - 1, columnIndex) || dfs(board, visited, word, str, rowIndex + 1, columnIndex);

        visited[rowIndex][columnIndex] = false;

        return found;
    }

}
