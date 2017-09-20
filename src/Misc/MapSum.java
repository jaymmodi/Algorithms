package Misc;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        this.map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key : this.map.keySet()) {
            if (key.startsWith(prefix)) {
                sum += this.map.get(key);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();

        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));


    }

}
