/**

// Time Complexity : O(1) + O(N) => O(N)
// Space Complexity : O(SIZE) + O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

compute the hash of the input by % N
then create a array of size N

each index will hold the start of the list

each collision will lead to form a chain of list


**/

class MyHashMap {
    
    private final int SIZE = 73;
    private final int NOT_FOUND = -1;
    
    class Node {
        public int data;
        public int key;
        public Node next;
        
        public Node(int data, int key) {
            this.key = key;
            this.data = data;
            this.next = null;
        }
    }
    
    private Node[] headList;
    
 

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.headList = new Node[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    
        int hash = key % SIZE;
        
        Node start = this.headList[hash];
        Node newnode = new Node(value, key);
        
        
        if( start == null) {
        
            newnode.next = start;
            start = newnode;
        } else {
        
            while(start !=null) {
                
                if(start.key == key) {
                    start.data = value;
                    return;
                }
                
                start = start.next;
            }
            
            start = this.headList[hash];
            
            newnode.next = start;
            start = newnode;
        }
        
        this.headList[hash] = start;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    
        int hash = key % SIZE;
        
        Node start = this.headList[hash];
        
        if(start == null) {
            return NOT_FOUND;
        }
        else {
            while(start != null) {
                
                if(start.key == key){
                    return start.data;
                }
                
                start = start.next;
            }
            
            return NOT_FOUND;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    
        /**
        
            Delete a node from list
        **/
        
        int hash = key % SIZE;
        
        Node start = this.headList[hash];
        
        if(start == null) {
            return;
        }
        
        if(start.key == key) {
            start = start.next;
            this.headList[hash] = start;
            return;
        }
        
        while( start.next != null) {
            
            if(start.next.key == key) {
                // node is present in the list at next position from current start
                
                start.next = start.next.next;
                return;
            }
            
            start = start.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */