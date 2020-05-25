// Time Complexity : finding element is O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Node {
    int key, value;
    Node next; // for chaining

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
	int Max_Size = 10000;
    Node[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[Max_Size];
    }
    private int index(int key){
        return Integer.hashCode(key) % Max_Size;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = index(key);
        if( nodes[i] == null){
            nodes[i] = new Node(-1,-1); //indicate empty
        }
        Node prev = find(nodes[i],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(key);
        if(nodes[i] == null){
            return -1;
        }
        Node prev = find(nodes[i],key);
        if(prev.next == null){
            return -1;
        }else {
            return prev.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null){
            return;
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
    
    private Node find(Node bucket, int key){
        Node curr = bucket, prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */