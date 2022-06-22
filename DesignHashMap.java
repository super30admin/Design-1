// Time Complexity :O(1) on average case, O(n) on worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes.


// Your code here along with comments explaining your approach
## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
class DesignHashMap {
    class Node{
            int key;
            int val;
            Node next;
        public  Node(int key, int val){
            this.key = key;
            this.val = val;
        }    
    }
    Node[] nodes;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
  }
    public int index(int key){
        return key % buckets;
    }
    public Node find(int key, Node node){
        Node prev = null;
        Node curr = node;
        while( curr != null && curr.key!= key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
        
    }
    
    
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1); 
        }
        Node prev = find( key, nodes[index]);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.val = value;
        }
        }
    
    
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null) return -1;
        Node prev = find( key, nodes[index]);
        if(prev.next == null) return -1;
        return prev.next.val;
        
        
    }
    
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null) return;
        Node prev = find( key, nodes[index]);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}