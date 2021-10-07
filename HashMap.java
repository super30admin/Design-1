// Time Complexity : As the total number of operations is given, it takes O(1) time. 
// In general sense, The time complexity will depend on the Load factor(lf): lf = n/m, n=number of elements stored in hash table and m=number of slots
// Space Complexity : O(n) time.
// Did this code successfully run on Leetcode: https://leetcode.com/submissions/detail/567537299/
// Any problem you faced while coding this : Is the anyalysis of time complexity correct?
class MyHashMap {

    class Node {
        int key; // User's Key
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] hashMap;

    public MyHashMap() {
        hashMap = new Node[10000];
    }

    private int index(int key) {
        return (Integer.hashCode(key)) % 10000;
    }

    private Node find(int key) {
        int hashKey = index(key);

        Node head = hashMap[hashKey];
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int hashKey = index(key);

        if (hashMap[hashKey] == null) {
            hashMap[hashKey] = new Node(-1, -1);
        }
        Node ptr = find(key);

        // Key not existing
        if (ptr.next == null) {
            Node newEntry = new Node(key, value);
            ptr.next = newEntry;
            return;
        }

        // Key is exisitng
        ptr.next.value = value;
    }

    public int get(int key) {
        int hashKey = index(key);
        Node ptr = find(key);

        // Null index/hashkey
        if (hashMap[hashKey] == null)
            return -1;

        // Found
        if (ptr.next != null)
            return ptr.next.value;

        // Not Found
        return -1;
    }

    public void remove(int key) {
        int hashKey = index(key);

        Node ptr = find(key);

        if (hashMap[hashKey] == null)
            return;
        // Found
        if (ptr.next != null) {
            ptr.next = ptr.next.next;
        }

        // Not found

    }
}

public class HashMap {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
