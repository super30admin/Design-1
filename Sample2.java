// Problem -1

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class MyHashMap {
    class Node // node for Linkedlist
    {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000]; // initialized by taking 10000 * 100 as the size so that traversal through linked list is constant i.e O(1) as 100 is constant
    }
    
    private int findIndex(int key)
    {
        return Integer.hashCode(key) % nodes.length; // using inbuild hashcode and limiting it to 10000
    }
    
    private Node findNode(Node head, int key)
    {
        Node curr = head; 
        Node prev = null;
        
        while(curr !=null && curr.key!=key)
        {
            prev = curr;
            curr = curr.next;
        }
            // found curr and prev and return prev as need to change links
        return prev;
        
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
       int index = findIndex(key); // found index
        if(nodes[index] == null) // if no node present
            nodes[index] = new Node(-1,-1); //dummy node
       
        Node prev = findNode(nodes[index] , key); // find prev
        if(prev.next == null) // if no prev
           prev.next = new Node(key, value); //create new node and put at the prev.next
        else
            prev.next.value = value; // else if node present at key, update value
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
         int index = findIndex(key);
          if(nodes[index] == null)  // if no node present
              return -1;
        
         Node prev = findNode(nodes[index] , key); // find prev
         
        if(prev.next == null) // if no prev
            return -1;
            
        return prev.next.value; // get value and return
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = findIndex(key);
        if(nodes[index] == null) return; // if no node for removal return from here
         Node prev = findNode(nodes[index] , key);
        
        if(prev.next == null) // if no node for removal return from here
            return;
        
        prev.next = prev.next.next; // else change the links
        
       
         }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */