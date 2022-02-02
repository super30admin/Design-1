//time complexity: put=O(1); get=O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    
    //linear chaining -> array and LinkedList
    //create array of size 10^4, then get operation- best case O(1), worst case O(n^2)
    
    int hash;
    private class Node {
        int key,val;
        Node next;
        
        Node(int k, int v){
            this.key = k;
            this.val = v;
            this.next = null;
        }
    }
    
    private static final int NUM_BUCKETS = 10000;
    private Node[] buckets;

    private int getHash(int key) {
        return key%NUM_BUCKETS;
    }
    
    private Node findPrevious(int key) {
        //get hash
        int hash = getHash(key);
        
        //find val in buckets at index == hash;
        if(buckets[hash] == null) {
            //no linked list
            return null;
        }
        Node prev = buckets[hash];
        Node curr = prev.next;
        
        //iterate till you find key or you hit end of linked list
        while(curr!= null && curr.key != key) {
            
            //traverse the linked list till you find key
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    public MyHashMap() {
        this.buckets = new Node[NUM_BUCKETS];
    }
    
    public void put(int key, int value) {
        Node prev = findPrevious(key);
        //check if prev does not exist
        if(prev == null) {
            int hash = getHash(key);
            
            //create dummy node at index==hash
            buckets[hash] = new Node(-1,-1);
            prev = buckets[hash];
        }
        
        //if exists update
        if(prev.next != null) {
            prev.next.val = value;
        } else { //else insert
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
        Node prev = findPrevious(key);
        
        //check if prev does not exist or if prev is the last Node of the list
        if(prev == null || prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }
    
    public void remove(int key) {
        Node prev = findPrevious(key);
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