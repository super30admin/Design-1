// Time Complexity : O(1) Average Case and O(n) worst Case
// Space Complexity : O(10000 + n) where n is the number of keys in the HashMap
// Did this code successfully run on Leetcode : Yes

// Linear Chaining using Linked List
class MyHashMap {
    Node[] nodes = new Node[10000];
    class Node{
        int val;
        int key;
        Node next;
        private Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    //find function
    private int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    private Node find(Node head, int key){
        int index = index(key);
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(nodes[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null)    return -1;
        Node prev = find(nodes[index],key);
        if(prev.next == null)    return -1;
        return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null)    return;
        Node prev = find(nodes[index],key);
        if(prev.next == null)    return;
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
