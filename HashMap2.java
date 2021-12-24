class MyHashMap {
        
    class Node{
        int val;
        int key;
        Node next;
        
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }    
    }
    Node [] nodes;
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node [buckets]; 
        
    }
    private int index(int key){
        return Integer.hashCode(key)%buckets;
    }
    private Node find(int key, Node node){
        Node prev = null;
        Node curr = node;
        
        while(curr !=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    public void put(int key, int value) {
        
        int index =index(key);
        if (nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(key, nodes[index]);
         // prev at end   
        if (prev.next == null){
            prev.next = new Node(key,value);
        }    
        else{
         // prev is not at end
         // node is present 
            prev.next.val = value;
        }    
        
        
    }
    
    public int get(int key) {
        int index =index(key);
        if (nodes[index] == null) return -1;
        Node prev = find(key, nodes[index]);
        if (prev.next == null) return -1;
        
        return prev.next.val;    
    }
    
    public void remove(int key) {
        int index =index(key);
        if (nodes[index] == null) return;
        Node prev = find(key, nodes[index]);
        if (prev.next == null) return;
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