/**
 * 706. Design HashMap
Easy

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

    MyHashMap() initializes the object with an empty map.
    void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
    int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

    Constraints:

    0 <= key, value <= 106
    At most 104 calls will be made to put, get, and remove
    
    // Time Complexity : O(100)
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Initially, did not implement dummy node which caused issue as the find returns the prev node later added it as explained in lecture

*/
class MyHashMap {
    
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private Node[] storage;
    private final int BUCKETS;

    public MyHashMap() {
        BUCKETS = 10000;
        storage = new Node[BUCKETS];
    }

    private int bucketHash(int key){
        return key % BUCKETS;
    }

    // Time Complexity : O(100)
    // Space Complexity : O(1)
    private Node find(int key){
        int bucket = bucketHash(key);
        if (storage[bucket] == null) return null;
        Node prev = null;
        Node curr = storage[bucket];
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    // Time Complexity : O(100)
    // Space Complexity : O(1)
    public void put(int key, int value) {
        int bucket = bucketHash(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1); // dummy node to handle the case for find() 
                                                // when there is only single ll node, because find() returns prev node
        }

        Node prev = find(key);
        if (prev.next == null) { // key not present in ll
            prev.next = new Node(key, value);
        } else { // key already present - just update the value 
            prev.next.value = value;
        }            

    }
    
    // Time Complexity : O(100)
    // Space Complexity : O(1)
    public int get(int key) {
        int bucket = bucketHash(key);
        if (storage[bucket] == null) return -1;
        Node prev = find(key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }
    
    // Time Complexity : O(100)
    // Space Complexity : O(1)
    public void remove(int key) {
        int bucket = bucketHash(key);
        if (storage[bucket] == null) return;
        Node prev = find(key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,11);
        obj.put(2,22);
        obj.put(2,24);

        int param_2 = obj.get(1);
        obj.remove(1);  
    }
}
