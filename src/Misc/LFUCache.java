package Misc;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    private class DLLInfo {
        Node head;
        Node tail;
        int count;

        private DLLInfo() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
            this.count = 0;
        }
    }

    private class Node {
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private PriorityQueue<Node> freqQueue;
    private Map<Integer, Node> dictionary;
    private Map<Integer, DLLInfo> sameFrequencyNodeMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.freqQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        this.dictionary = new HashMap<>();
        this.sameFrequencyNodeMap = new HashMap<>();
    }


    public int get(int key) {
        if (this.dictionary.containsKey(key)) {
            Node node = this.dictionary.get(key); // get the address of the node to update
            DLLInfo dllInfo = this.sameFrequencyNodeMap.get(node.frequency); // get the head of DLL list in which we maintain the most/least recent order of nodes
            remove(dllInfo, node); // remove from the corresponding DLL list

            // this is to update the frequency priority queue
            this.freqQueue.remove(node); // remove from queue to update the frequency of the node
            node.frequency++;
            this.freqQueue.add(node); // add it back with updated frequency

            // this is to add the node in different DLL with corresponding node frequency
            DLLInfo newDLLInfo = this.sameFrequencyNodeMap.getOrDefault(node.frequency, new DLLInfo());
            add(newDLLInfo, node); // add at the tail end

            if (!this.sameFrequencyNodeMap.containsKey(node.frequency)) {
                this.sameFrequencyNodeMap.put(node.frequency, newDLLInfo);
            }

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }

        if (this.dictionary.containsKey(key)) {
            Node nodeToRemove = this.dictionary.get(key);
            this.freqQueue.remove(nodeToRemove); // remove from priority queue

            DLLInfo dllInfo = this.sameFrequencyNodeMap.get(nodeToRemove.frequency);
            remove(dllInfo, nodeToRemove);
        }

        // add newNode dictionary
        Node newNode = new Node(key, value);
        this.dictionary.put(key, newNode);

        //update the size of dll list if map size greater than capacity
        if (this.dictionary.size() > this.capacity) {
            Node nodeWithLowFreq = this.freqQueue.peek();
            int lowestFre = nodeWithLowFreq.frequency;

            DLLInfo correspondingDLL = this.sameFrequencyNodeMap.get(lowestFre);
            if (correspondingDLL.count == 1) {
                // remove nodeWithLowFreq - as this has the lowest frequency
                this.dictionary.remove(nodeWithLowFreq.key);
                remove(correspondingDLL, nodeWithLowFreq);
                this.freqQueue.remove(nodeWithLowFreq);
            } else {
                // else remove the node from the head of correspondingDLL
                Node nodeToRemove = correspondingDLL.head.next;
                this.dictionary.remove(nodeToRemove.key);
                remove(correspondingDLL, nodeToRemove);
                this.freqQueue.remove(nodeToRemove);
            }

        }

        this.freqQueue.add(newNode);
        // add the node in freq map as well
        if (this.sameFrequencyNodeMap.containsKey(newNode.frequency)) {
            DLLInfo dllInfo = this.sameFrequencyNodeMap.get(newNode.frequency);
            add(dllInfo, newNode);
        } else {
            DLLInfo dllInfo = new DLLInfo();
            add(dllInfo, newNode);
            this.sameFrequencyNodeMap.put(newNode.frequency, dllInfo);
        }
    }

    private void add(DLLInfo dllInfo, Node nodeToAdd) {
        // add it from tail side
        Node tail = dllInfo.tail;
        Node prev = tail.prev;
        prev.next = nodeToAdd;
        nodeToAdd.prev = prev;
        nodeToAdd.next = tail;
        tail.prev = nodeToAdd;

        dllInfo.count++;

    }

    private void remove(DLLInfo dllInfo, Node nodeToRemove) {
        if (nodeToRemove.prev == dllInfo.head) {
            Node next = nodeToRemove.next;
            dllInfo.head.next = next;
            next.prev = dllInfo.head;
        } else if (nodeToRemove.next == dllInfo.tail) {
            Node prev = nodeToRemove.prev;
            prev.next = dllInfo.tail;
            dllInfo.tail.prev = prev;

        } else {
            Node prev = nodeToRemove.prev;
            Node next = nodeToRemove.next;
            prev.next = next;
            next.prev = prev;
        }

        dllInfo.count--;
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        lfuCache.put(4, 4);

        System.out.println(lfuCache.get(4));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        lfuCache.put(5, 5);

        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
        System.out.println(lfuCache.get(5));
    }
}
