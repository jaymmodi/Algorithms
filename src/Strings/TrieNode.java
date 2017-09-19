package Strings;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}
