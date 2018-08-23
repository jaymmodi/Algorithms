package Recursion.Backtracking;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<Character> uniqueCharacters = new HashSet<>();

        for (String word : wordList) {
            for (Character character : word.toCharArray()) {
                uniqueCharacters.add(character);
            }
        }

        int minLength = Integer.MAX_VALUE;
        Set<String> currentSet = new HashSet<>();
        currentSet.add(beginWord);

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        minLength = dfs(beginWord, endWord, wordSet, uniqueCharacters, minLength, currentSet);

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private static int dfs(String beginWord, String endWord, Set<String> wordSet, Set<Character> uniqueCharacters, int minLength, Set<String> currentSet) {
        if (beginWord.equals(endWord)) {
            minLength = Math.min(minLength, currentSet.size());

            return minLength;
        } else {
            if (wordSet.size() > 0) {
                char[] beginChars = beginWord.toCharArray();

                for (int i = 0; i < beginChars.length; i++) {
                    for (Character character : uniqueCharacters) {
                        if (beginChars[i] != character) {
                            String start = beginWord.substring(0, i);
                            String end = beginWord.substring(i + 1);

                            String newStr = start + character + end;

                            if (wordSet.contains(newStr)) {
                                wordSet.remove(newStr);
                                currentSet.add(newStr);

                                minLength = dfs(newStr, endWord, wordSet, uniqueCharacters, minLength, currentSet);

                                wordSet.add(newStr);
                                currentSet.remove(newStr);
                            }
                        }
                    }
                }
            }

            return minLength;
        }
    }
}
