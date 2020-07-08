//Design and implement a HashMap

// Time Complexity : Amortized O(1) for insert, delete and get
// Space Complexity : O(n) worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't face any, as this was explained clearly in class.


// Your code here along with comments explaining your approach

class MyHashMap {
    //maintaining an array of linked list nodes which contain keys and values
    ListNode[] nodes = new ListNode[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        //nothing to initialize in the constructor
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key); //find the index where the key has to be placed.
        ListNode prev = findElement(index,key); // prev contains the previous key that has been placed in that particular index postion.
        if(prev.next == null) { // if there are no nodes, create a new node with the key-value pair
            prev.next = new ListNode(key,value); 
        }
        prev.next.value = value; // else, attach it to the linked list
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);  //find the index where the key has been placed.
        ListNode  prev= findElement(index,key); // prev contains the previous key that has been placed in that particular index postion.
        return prev.next == null ? -1 : prev.next.value; //If there is no node, it returns -1. else it returns the value present in the key.
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next != null)
            prev.next = prev.next.next; //updates the prev pointer and links it to the next of current node.
    }
    //defining a node
    private static class ListNode {
        int key, value;
        ListNode next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //implements our hashfunction which returns the index where the key needs to be placed.
    private int getIndex(int key) {
        return Integer.hashCode(key) % 10000;
    }
    
    private ListNode findElement(int index, int key) {
        if (nodes[index] == null) //if there are no nodes currently, it just returns -1.
            return nodes[index] = new ListNode(-1,-1); 
        ListNode prev = nodes[index]; 
        while(prev.next!=null && prev.next.key!=key) { //if there are nodes and the keys are unique, then it updates the nodes and places the key after the current node.
            prev = prev.next; 
        }
        return prev; //however, if the keys are same, it returns the key.
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
