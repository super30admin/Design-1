class MyHashMap {
    
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] nodes;
    int bucketSize;
    public MyHashMap() {
        bucketSize = 10000;
        nodes = new Node [bucketSize];
    }
    
    private int index(int key){
        return Integer.hashCode(key) % bucketSize;
    }
    private Node findKey(int key, Node node){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key){
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
        Node prev = findKey(key, nodes[index]);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        int index = index(key);
        
        if(nodes[index] == null) return -1;
        
        Node prev = findKey(key, nodes[index]);
        if(prev.next == null) return -1;
        
        return prev.next.val;
    }
    
    public void remove(int key) {
        int index = index(key);
        
        if(nodes[index] == null) return;
        
        Node prev = findKey(key, nodes[index]);
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