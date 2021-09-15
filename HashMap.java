// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class HashMap {

    static class Node {
        int key, val;
        Node next;

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] hashmap;

    HashMap() {
        hashmap = new Node[15];
    }

    public void put(int key, int value) {
        Node prev = getPreviousNode(getIndex(key), key);
        if(prev.next == null)
            prev.next = new Node(key,value);
        else
            prev.next.val = value;
    }

    public int get(int key) {
        Node prev = getPreviousNode(getIndex(key), key);
        if(prev.next.key == key) return prev.next.val;
        return -1;
    }

    public void remove(int key) {
        Node prev = getPreviousNode(getIndex(key), key);
        if(prev.next != null) prev.next = prev.next.next;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key % hashmap.length);
    }

    private Node getPreviousNode(int index, int key) {
        if(hashmap[index] == null)
            hashmap[index] = new Node(-1,-1);

        Node prev = hashmap[index];
        while (prev.next != null && prev.next.key != key)
            prev = prev.next;

        return prev;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
    }

}
