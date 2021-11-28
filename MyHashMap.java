// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {

    class Node {
        private int key;
        private int val;
        private Node next;
        
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    private int bucket;
    private Node [] nodes;
    
    public MyHashMap() {
        bucket = 10000;
        nodes = new Node[bucket];
    }
    
    // Looks for pointer just before the key
    private Node find(Node node, int key)
    {
        Node prev = node;
        Node curr = prev.next;
        // curr == null when value not found 
        // prev.next.key == key when value found
        while(curr != null && prev.next.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        
        return prev; // always pointer to one before what is needed
    }
    
    private int getHash(int key)
    {
        return Integer.hashCode(key) % bucket;
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1,-1);
        }
        
        Node prev = find(nodes[index], key);
        
        if(prev.next == null)
        {
            prev.next = new Node(key, value);
        }
        else
            prev.next.val = value;
    }
    
    public int get(int key) {
        int index = getHash(key);
        
        if(nodes[index] == null)
            return -1;
        
        Node prev = find(nodes[index], key);   
        if(prev.next == null)
        {
            return -1;
        }
        else
            return prev.next.val;
    }
    
    public void remove(int key) {
        int index = getHash(key);
        
        if(nodes[index] == null)
            return;
        Node prev = find(nodes[index], key);   
        if(prev.next == null)
        {
            return;
        }
        else
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