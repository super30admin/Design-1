//Time complexity : put(), get(), remove() -> O(N) - N is the size of the Linked List
//Space complexity: O(N) - unique key-value pairs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyHashMap {
    
    //Create a class node to store key value pair type data
    class Node{
        int key, val;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] storage;
    int bucket;
    
    
    //Hashing function
    private int getKey(int key){
        
         //using built in Integer.hashCode() and 
        //modulo bucket as we want to limit the hashCode value in the range of 0 to 10000
        
        return Integer.hashCode(key) % bucket;
    }
    
    //Find function to find the key
    private Node find(Node head, int key){
        Node prev  = null;
        Node current = head;
        // loop until current is not null and 
        //the key it points is not equal to the key passed
        while(current != null && current.key != key){ 
            prev = current;
            current = current.next;
        }
        return prev;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = 10000;
        storage = new Node[bucket]; //primary array type Node of size 10000  
    }
    
 
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getKey(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1); // create a dummy node if node does'nt exist
        }
        //if node exist
        Node prev = find(storage[index], key);
        if( prev.next == null){ // element not found so create a new node
            prev. next = new Node(key, value);
        }
        else{
            prev.next.val = value;// element found so update its value
        }
         
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getKey(key);
        if(storage[index] == null){ // element not found so return -1
            return -1;              
        }
        Node prev = find(storage[index], key);
        if( prev.next == null){ // element not found so return -1
            return -1;
        }
        return prev.next.val; // element found so return its value
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getKey(key);
        if(storage[index] == null){ // element not found so return
            return;               
        }
        Node prev = find(storage[index], key);
        if( prev.next == null){ // element not found so return
            return;
        }
        prev.next = prev.next.next; // element found so point the prev next to next of next node
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */