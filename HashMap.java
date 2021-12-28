// Time Complexity : O(1) for put,get and remove operations.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a node array of length 10,000 so that when we implement chaining to avoid collisions in the worst case
// we have to run through 100 elements in the linked list. For put operation first fetch the bucket number using
// hash function and check if node is present at that particular location. When node is present use the find 
// method to check if given key is existing in the linked list, if found update the value corresponding to that 
// key. If not found add a new node at the end. For get operation first fetch the bucket number using hash 
// function then use the find method to know if a node is present with a given key. For remove operation use the
// hash method to get bucket number and then find method to first know if the node is present with given key if 
// found then remove it.   

class Node{
    int key;
    int value;
    Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
        next = null;
    }
}

class MyHashMap {
    
    Node[] storage;
    
    public MyHashMap() {
        storage = new Node[10000];
    }
    
    public int hash(int key){
        return key%10000;
    }
    
    public Node find (int key, Node bucket){
        Node prev = null;
        Node curr = bucket;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
    
        Node prev = find(key,storage[bucket]);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket]==null){
            return -1;
        }
        else{
            Node prev = find(key,storage[bucket]);
            if(prev.next==null){
                return -1;
            }
            else{
                return prev.next.value;
            }
        }
        
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket]==null){
            return;
        }
        else{
            Node prev = find(key,storage[bucket]);
            if(prev.next==null){
                return;
            }
            else{
                prev.next = prev.next.next;
            }
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
