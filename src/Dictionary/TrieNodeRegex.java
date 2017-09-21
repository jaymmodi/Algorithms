package Dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNodeRegex {

    Map<Character, List<TrieNodeRegex>> children;
    boolean endOfWord;

    public TrieNodeRegex(){
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}
