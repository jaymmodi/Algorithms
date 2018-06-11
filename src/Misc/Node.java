package Misc;

public class Node {
    public int key;
    public int value;
    public int frequency;
    public int recentUsed; // more the number, then more recently it is used - This should not be removed.

    public int getRecentUsed() {
        return recentUsed;
    }

    public void setRecentUsed(int recentUsed) {
        this.recentUsed = recentUsed;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
        this.recentUsed = 1;
    }
}
