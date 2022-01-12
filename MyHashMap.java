import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // An array of linkedLists
    private Node[] array;
    private int buckets;
    private Node prev, curr;

    public MyHashMap() {
        buckets = 10000;
        array = new Node[buckets];
    }

    private int index(int key) {
        return Integer.hashCode(key) % buckets;
    }

    private Node find(int key, Node node) {
        prev = null;
        curr = node;
        // traverse the list until we find the node with the given key or till the list
        // is exhausted
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        // pointer to the node previous to the key node or the last node of the list
        return prev;
    }

    public void put(int key, int value) {
        int index = index(key);
        // check if list exists at the index, if not create a dummy node
        if (array[index] == null) {
            array[index] = new Node(-1, -1);
        }
        // if list exists, find if the node with key and the list pointer
        prev = find(key, array[index]);
        // if node isn't there
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else { // if node is there at the given key
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = index(key);
        // if list exists at the index
        if (array[index] == null)
            return -1;
        // if list exists, find if the node with key
        prev = find(key, array[index]);
        // if node isn't there
        if (prev.next == null)
            return -1;
        // if node is there, return the node val
        return prev.next.val;
    }

    public void remove(int key) {
        int index = index(key);
        // if list exists at the index
        if (array[index] == null)
            return;
        // if list exists, find if the node with key
        prev = find(key, array[index]);
        // if node isn't there
        if (prev.next == null)
            return;
        // if node is there, return the node val
        prev.next = prev.next.next;
    }
}
