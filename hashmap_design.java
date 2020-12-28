// Time Complexity : O(N/K) where N is no. of keys and K is number of predefined buckets/nodes
// Space Complexity : O(K + M) where K is number of predefined buckets/nodes and M is the no. of unique inserted keys
// Did this code successfully run on Leetcode : Yes

class Node{    
    int key;
    int value;
    Node next;    

    public Node(int key, int value) {    
        this.key = key;
        this.value = value;
        this.next = null;    
    }    
}    

class MyHashMap {
    Node[] nodes;
    private int keys_space = 10000;
    
    private int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    private Node find(Node head, int key){
        Node current = head;
        Node previous = null;
        while(current != null && current.key != key){
            previous = current;
            current = current.next;
        }
        return previous;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[keys_space]; 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = index(key);
        if(nodes[i] == null){
            nodes[i] = new Node(-1, -1);
        }
        Node previous = find(nodes[i], key);
        if(previous.next == null)
            previous.next = new Node(key, value);
        else
            previous.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(key);
        if(nodes[i] == null) return -1;
        Node previous = find(nodes[i], key);
        if(previous.next == null)
            return -1;
        else
            return previous.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null) return;
        Node previous = find(nodes[i], key);
        if(previous.next == null){
            return;
        }
        else{
            previous.next = previous.next.next;
            return;
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