// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understanding the findPrev method

class MyHashMap {

    private class Node {
        int key;
        int value;
            
        Node next = null;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int NUM = 10000;
    private Node[] buckets;
    
    public MyHashMap() {
        buckets = new Node[NUM];
    }
    
    private int getHash(int key) {
        return key % NUM;
    }
     
    private Node findPrev(int key) {
        int hash = getHash(key);
        // checking if LinkedList node exists, if not return null
        if (buckets[hash] == null) {
            return null;
        }
        
        Node prev = buckets[hash]; // our dummy node
        Node curr = prev.next; // current node
        
        //finding
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        Node prev = findPrev(key);
        
        if (prev == null) {
            int hash = getHash(key);
            buckets[hash] = new Node (-1, -1); //creating the dummy node
            prev = buckets[hash];
        }
        
        // if key exists, update value
        if (prev.next != null) {
            prev.next.value = value;
        }
        else {
            prev.next = new Node (key, value);
        }
    }
    
    public int get(int key) {
        Node prev = findPrev(key);
        
        // we check prev == null to see if linked list exists or not
        // if linked list doesn't exist, key won't exist so we return -1
        // we also check if prev.next (curr) == null. Here linked list exists
        // but key may not exist, prev.next = null so also return -1
        if (prev == null || prev.next == null) {
            return -1;
        }
        // else just return value of curr
        return prev.next.value;
    }
    
    public void remove(int key) {
        Node prev = findPrev(key);
        
        if (prev == null || prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */