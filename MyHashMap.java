class MyHashMap {
    
    // Linear chaining technique
    // Time complexity is O(1)
    // Space Complexity is O(n)
    // Solution is submitted to leetcode with no errors
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            
        }
    }
    int bucket;
    private Node[] storage;
    
    public MyHashMap() {
        this.bucket = 10000;
        this.storage = new Node[bucket];
    }
    
    public int getIndex(int key) {
        return key%bucket;
    } 
    
    public Node getPrev (Node node, int key){
        Node prev = null;
        Node curr = node;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int indx = getIndex(key);
        if(storage[indx] == null){
            storage[indx] = new Node(-1,-1);
        }
        Node prev = getPrev(storage[indx], key);
        if(prev.next == null){
            // no key found
            prev.next = new Node(key, value);
        } else {
            //Key is found
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int indx = getIndex(key);
        if(storage[indx] == null) return -1;
        Node prev = getPrev(storage[indx], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int indx = getIndex(key);
        if(storage[indx] == null) return;
        Node prev = getPrev(storage[indx], key);
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