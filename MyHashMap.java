// Time Complexity :put - O(N/K) where N is number of values and K is keyspace; remove - O(N/K);get - O(N/K)
// Space Complexity : O(K+N) where K is keyspace and N is number of values 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {
    
    class node {
        int key, val; 
        node next;
        public node(int key, int val){
            this.key = key; 
            this.val = val;
        }
        
    }
    
    node[] nodes; 
    int size; 
    
    private int getKey(int key){
        return Integer.hashCode(key) % this.size;
    }
    
    private node find(node head, int key){
        node prev = null;
        node curr = head; 
        while (curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 100000;
        nodes = new node[size];
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = this.getKey(key);
        if (nodes[idx]==null){
            nodes[idx] = new node(-1,-1);
        }
        node prev = find(nodes[idx],key);
        if (prev.next== null){
            prev.next = new node(key,value);
        }
        else {
            prev.next.val = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = this.getKey(key);
        if (nodes[idx] == null)
        {
         return -1;   
        }
        node found = find (nodes[idx],key);
        if (found.next==null){
            return -1;
        }
        return found.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = this.getKey(key);
        if (nodes[idx] == null)
        {
         return;   
        }
        node found = find (nodes[idx],key);
        if (found.next==null){
            return;
        }
        found.next = found.next.next;
        return;
        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// Your code here along with comments explaining your approach
