// Time Complexity : O(L), where L is the maximum size of linkedlist, which can be 100 in worst case when n = 10061.  
// Space Complexity : O(N + K), where n is the length of the hashmap array and k is the number of unique key value pairs. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//created Node class
class Node {
    int key;
    int value;
    Node next; 
    
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null; 
    }
}

class MyHashMap {
    //choosing a prime number close to 10^4, so for the worst case, we will have to iterate through 100 nodes.
    static int n = 10061;
    Node hashmap[]; 
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new Node[n];
    }
    
    /** Created a method to get the prev node in the linkedlist */
    public Node getPosition(int index, int key) {
        if (hashmap[index] == null) {
            //inserting a dummy node to avoid getting null pointer exceptions
            hashmap[index] = new Node(-1, -1); 
        }
        Node prev = hashmap[index];
        //iterating the linkedlist till the prev node. 
        while(prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev; 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%n;
        Node prev = getPosition(index, key);
        //if prev.next is not null, updating the existing value for the given key.
        if (prev.next != null) {
            prev.next.value = value;
        }
        //else adding a new node with the given key and value
        else {
            prev.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%n;
        Node prev = getPosition(index, key);
        //if prev.next is not null, return the value for the given key, else return -1 as the key-value pair doesn't exists in the map. 
        return prev.next != null?prev.next.value:-1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%n;
        Node prev = getPosition(index, key);
        //if prev.next is null, the key-value doesn't exists, else delete the 
        if(prev.next!=null) prev.next = prev.next.next; 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */