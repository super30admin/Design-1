package com.s30.edu.design1;

class MyHashMap {
    Node[] nodes; // HashMap is internally a array of nodes

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[1000];
        
    }
    
    class Node{
        int key, value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node position = getNodeInBucket(key); // find a node in a bucket
        
        if(position.next == null){ // If next node is null, insert key value pair 
            Node node = new Node(key, value);
            position.next = node;
        }
        
        position.next.value = value; // else, update the value
    }
    
    // Hashing function
    public int getIndex(int key){
        return key % 1000;
    }
    
    // Function to find a node in a bucket 
    public Node getNodeInBucket(int key){
        int index = getIndex(key);
        
        if(nodes[index] == null){
            Node dummy = new Node(-1,-1);
            nodes[index] = dummy;
            return dummy;  
        }
        
        Node position = nodes[index];
        while((position.next != null) && (position.next.key != key)){ // Increment pointer until node with a given key is found or null node found
            position = position.next;
        }
        
        return position;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node position = getNodeInBucket(key);
        
        if(position.next == null){
            return -1;
        }else{
            return position.next.value;
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node position = getNodeInBucket(key);
        
        if(position.next != null){
            position.next = position.next.next; // not actual deletion, just update the pointers
        }
    }
    
    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);          
        hashMap.put(2, 2);         
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1 
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found) 
    }
    
}


