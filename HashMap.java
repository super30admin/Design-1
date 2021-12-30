// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class MyHashMap {
    //Linked list class
    class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    Node[] nodes;
    int buckets;
    
    //constructor
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    //hash function to find the position in the array
    private int index(int key) {
        return key % buckets;
    }
    
    //function to find the prev node in the linked list.
    private Node find(int key, Node node) {
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    //if the array value is null at index, then create a new dummy node.
    //added dummy node in the beginning to hold the value for prev.
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(key, nodes[index]);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    //return the value if the key is availabla in HashMap
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null) return -1;
        Node prev = find(key, nodes[index]);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    //Remove the entry from the Hashmap if exists
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null) return;
        Node prev = find(key, nodes[index]);
        if(prev.next == null) return;
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