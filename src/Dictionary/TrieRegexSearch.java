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
        return search(root, word);
    }

    private boolean search(TrieNodeRegex root, String word) {
        char dot = '.';
        char[] chars = word.toCharArray();

        if (word.length() == 0) {
            return false;
        }

        if (chars.length == 1 && chars[0] == dot) {
            return true;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == dot) {
                List<TrieNodeRegex> childNodes = root.children.get(chars[i]);

                boolean found = false;
                for (TrieNodeRegex childNode : childNodes) {
                    found = found || search(childNode, word.substring(i + 1));
                }
                return found;
            } else {
                if (root.children.containsKey(chars[i])) {
                    TrieNodeRegex childNode = root.children.get(chars[i]).get(0);
                    if (word.substring(i + 1).equals("")) {
                        return childNode.endOfWord;
                    }

                    return search(childNode, word.substring(i + 1));
                } else {
                    return false;
                }
            }
        }
        return false;
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

        trieRegexSearch.addWord("jay");
        trieRegexSearch.addWord("modi");

        System.out.println(trieRegexSearch.search(".od."));
        System.out.println(trieRegexSearch.search(".a."));
        System.out.println(trieRegexSearch.search("....."));

    }
}
