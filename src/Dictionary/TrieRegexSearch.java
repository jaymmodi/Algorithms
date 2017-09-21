package Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieRegexSearch {

    public TrieNodeRegex root;

    public TrieRegexSearch() {
        this.root = new TrieNodeRegex();
    }

    public void addWord(String word) {
        TrieNodeRegex node = root;

        for (char c : word.toCharArray()) {
            TrieNodeRegex childTrieNode;
            if (!node.children.containsKey(c)) {
                childTrieNode = new TrieNodeRegex();

                node.children.put(c, Arrays.asList(childTrieNode));
                updateRegexCharacter(node, childTrieNode);
            } else {
                childTrieNode = node.children.get(c).get(0);
            }

            node = childTrieNode;
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        return word.length() != 0 && search(root, word, 0);
    }

    private boolean search(TrieNodeRegex root, String word, int position) {
        if (position == word.length()) {
            return root.endOfWord;
        }

        char dot = '.';
        char currentChar = word.charAt(position);

        if (currentChar == dot) {
            List<TrieNodeRegex> childNodes = root.children.get(currentChar);

            if (childNodes == null) {
                return false;
            }

            boolean found = false;
            ++position;
            for (TrieNodeRegex childNode : childNodes) {
                found = found || search(childNode, word, position);
            }
            return found;
        } else {
            if (root.children.containsKey(currentChar)) {
                return search(root.children.get(currentChar).get(0), word, ++position);
            } else {
                return false;
            }
        }
    }

    private void updateRegexCharacter(TrieNodeRegex parentTrieNode, TrieNodeRegex childTrieNode) {
        char dot = '.';

        if (!parentTrieNode.children.containsKey(dot)) {
            List<TrieNodeRegex> list = new ArrayList<>();
            list.add(childTrieNode);

            parentTrieNode.children.put(dot, list);
        } else {
            parentTrieNode.children.get(dot).add(childTrieNode);
        }
    }

    public static void main(String[] args) {
        TrieRegexSearch trieRegexSearch = new TrieRegexSearch();

        trieRegexSearch.addWord("at");
        trieRegexSearch.addWord("and");
        trieRegexSearch.addWord("an");
        trieRegexSearch.addWord("add");
        trieRegexSearch.addWord("bat");
        trieRegexSearch.addWord("a");

        System.out.println(trieRegexSearch.search("."));

    }
}
