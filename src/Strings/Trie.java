package Strings;

public class Trie {

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            TrieNode childTrieNode;

            if (!node.children.containsKey(c)) {
                childTrieNode = new TrieNode();
                node.children.put(c, childTrieNode);
            } else {
                childTrieNode = node.children.get(c);
            }

            node = childTrieNode;
        }

        node.endOfWord = true;

    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            TrieNode childTrieNode;

            if (node.children.containsKey(c)) {
                childTrieNode = node.children.get(c);
            } else {
                return false;
            }

            node = childTrieNode;
        }

        return node.endOfWord;
    }

    public boolean startsWith(String str) {
        TrieNode node = root;

        for (char c : str.toCharArray()) {
            TrieNode childTrieNode;

            if (node.children.containsKey(c)) {
                childTrieNode = node.children.get(c);
            } else {
                return false;
            }
            node = childTrieNode;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("jay");
        trie.insert("modi");
        trie.insert("mukesh");

        System.out.println(trie.startsWith("jo"));
    }
}
