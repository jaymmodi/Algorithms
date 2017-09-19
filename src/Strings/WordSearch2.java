package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class WordSearch2 {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearch2 wordSearch2 = new WordSearch2();
        List<String> words1 = wordSearch2.findWords(board, words);

        words1.forEach(System.out::println);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> uniqueWords = new HashSet<>(asList(words));
        Set<String> result = new HashSet<>();

        Trie trie = new Trie();
        uniqueWords.forEach(trie::insert);

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, trie, "", i, j, result);
            }
        }

        return new ArrayList<>(result);
    }

    public void dfs(char[][] board, boolean[][] visited, Trie trie, String str, int rowIndex, int columnIndex, Set<String> result) {
        int rowSize = board.length;
        int columnSize = board[0].length;

        if (rowIndex < 0 || columnIndex < 0 || rowIndex > rowSize - 1 || columnIndex > columnSize - 1) {
            return;
        }

        if (visited[rowIndex][columnIndex]) {
            return;
        }

        str = str + board[rowIndex][columnIndex];

        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        visited[rowIndex][columnIndex] = true;

        // go horizontal right
        dfs(board, visited, trie, str, rowIndex, columnIndex + 1, result);
        // go horizontal left
        dfs(board, visited, trie, str, rowIndex, columnIndex - 1, result);
        // go vertical up
        dfs(board, visited, trie, str, rowIndex - 1, columnIndex, result);
        // go vertical down
        dfs(board, visited, trie, str, rowIndex + 1, columnIndex, result);

        visited[rowIndex][columnIndex] = false;
    }
}
