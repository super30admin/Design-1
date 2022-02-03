// Time Complexity
// Put O(N)
// Get O(N)
// Remove O(N)
// Space Complexity
// O(Bucket Pool + Unique keys per bucket)

class MyHashMap {
    class Node {
        int key, val;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node [] nodes;

    public MyHashMap() {
       nodes = new Node[10000]; 
    }
    
    private int getHash(int key) {
        return key % 10000;
    }
    
    private Node getPrevious(int key) {
        int idx = getHash(key);
        
        if(nodes[idx] == null) return null;
        
        Node prev = nodes[idx];
        Node curr = prev.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
        
    }
    
    public void put(int key, int value) {
        Node prev = getPrevious(key);
        
        if(prev == null) {
            int idx = getHash(key);
            nodes[idx] = new Node(-1, -1);
            prev = nodes[idx];
        }
        
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        Node prev = getPrevious(key);
        
        if(prev == null || prev.next == null) {
            return -1;
        }
        
        return prev.next.val;
    }
    
    public void remove(int key) {
        Node prev = getPrevious(key);
        
        if(prev == null || prev.next == null) {
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
