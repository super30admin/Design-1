class MyHashMap {
    private class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private static final int NUM_BUCKETS = 10000;
    
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[NUM_BUCKETS];
    }
    private int getHash(int key){
        return key % NUM_BUCKETS;
    }
    private Node findPrev(int key){
        int hash = getHash(key);
        if(buckets[hash]==null)
            return null;
        
        Node prev = buckets[hash];
        Node curr = prev.next;
        
        while(curr!= null && curr.key!= key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
        
    }
    
    public void put(int key, int value) {
        Node prev = findPrev(key);
        
        if(prev == null){
            int hash = getHash(key);
            buckets[hash]= new Node(-1,-1);
            prev = buckets[hash];
        }
        
        if(prev.next!=null)
            //To Update the exixting key
            prev.next.value = value;
        else
            //To Insert a new key value pair
            prev.next = new Node(key,value);
        
    }
    
    public int get(int key) {
        Node prev = findPrev(key);
        if(prev == null || prev.next == null)
            return -1;
        
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        Node prev = findPrev(key);
        
        if(prev == null || prev.next == null)
            return;
        
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
