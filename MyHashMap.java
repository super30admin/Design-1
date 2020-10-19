// Time Complexity : O(1) for all the operations if key is int and O(l) if key is not int
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Basic syntax (used to use python)


// Your code here along with comments explaining your approach

//Refered the Class before solving.

class MyHashMap {
    // Creating the Node class
    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node node[];
    
    /** Initialize your data structure here. */
    public MyHashMap() {        
        node = new Node[1000];
    }
    
    // returns the hashed value, we call index because it's index of the bucket array
    private int index(int key){
        return Integer.hashCode(key)%node.length;
    }
    
    // Function to find the key in the linkedList
    // Use of PREV for all the operation as it's sufficient.
    
    private Node findInList(Node head, int key){
        Node curr = head;
        Node prev = null;
        
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = index(key);
        
        if(node[hash]==null){
            node[hash] = new Node(-1,-1);
        }
        Node prev = findInList(node[hash], key);
        
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = index(key);
        if(node[hash] == null){
            return -1; 
        } 
        
        Node prev = findInList(node[hash],key);
        
        if(prev.next==null) {
            return -1;
        }
        return prev.next.value;
            
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = index(key);
        if(node[hash]==null) return;
        Node prev = findInList(node[hash],key);
        if(prev.next==null) return;
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
