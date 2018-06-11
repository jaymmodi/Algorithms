package Misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class DLLNode {
        int key;
        int value;
        DLLNode next;
        DLLNode prev;

        private DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private DLLNode head;
    private DLLNode tail;
    private int capacity;
    private Map<Integer, DLLNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }


    public int get(int key) {
        if (this.map.containsKey(key)) {
            DLLNode nodePresent = this.map.get(key);
            remove(nodePresent); // remove it so that we can add it again for refreshing
            add(nodePresent); // add it back from tail side
            return this.map.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) { // remove from DLL if key already present in map
            DLLNode node = this.map.get(key);
            remove(node);
        }

        DLLNode newNode = new DLLNode(key, value);
        add(newNode);
        this.map.put(key, newNode);
        if (this.map.size() > this.capacity) {
            DLLNode nodeToRemove = this.head.next;
            remove(nodeToRemove);
            this.map.remove(nodeToRemove.key);
        }
    }


    /*
        Always add at tail
     */
    private void add(DLLNode node) {
        DLLNode prev = this.tail.prev;
        node.next = this.tail;
        node.prev = prev;
        prev.next = node;
        this.tail.prev = node;
    }

    private void remove(DLLNode node) {
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
