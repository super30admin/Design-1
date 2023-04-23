// Time Complexity :  O(1) for average and O(n) for worst case for all operations.
// Space Complexity : O(n) - where n is the number of entries in HashSet
// Did this code successfully run on Leetcode : yes

// used an array of nodes to implement HashSet;

class MyHashSet {
    class Node{
        int key;
        Node next;
        public Node (int key){
        this .key = key;
    }
    }

    int buckets = 10000;
    Node storage[] = new Node [buckets];
    
    private int getbucket(int key){
        return key%buckets;
    }
    
    private Node find(Node node, int key){
        Node prev = node;
        Node curr = node;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int bucket = getbucket(key);
        if(storage[bucket]==null){
            storage[bucket]= new Node(-1);
        }
        Node prev = find(storage[bucket],key);
        if(prev.next==null){
            prev.next = new Node(key);
        }
 
    }
    
    public void remove(int key) {
        int bucket = getbucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev = find(storage[bucket],key);
        if(prev.next!=null){
            prev.next = prev.next.next;
        }
        
        
    }
    
    public boolean contains(int key) {
        int bucket = getbucket(key);
        if(storage[bucket]==null){
            return false;
        }
        Node prev = find(storage[bucket],key);
        if(prev.next==null){
            return false;
        }  
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */