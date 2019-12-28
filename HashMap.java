class MyHashMap {
    
    /** Initialize your data structure here. */
    Node[] nodes = new Node[100000];
    public MyHashMap() {
        
    }
    
    private class Node{
        int key;
        int value;
        Node next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private int calculateHash(int key){
        return Integer.hashCode(key);    
    }
    
    private Node findPrevious(Node head, int key){
        Node current = head;
        Node previous = null;
        
        while(current != null  && current.key != key){
            previous = current;
            current = current.next;
        }
        
        return previous;
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = this.calculateHash(key);
        
        if(nodes[index] == null){
            nodes[index] = new Node(-1, -1);
        }
        
        Node prev = findPrevious(nodes[index], key);
        
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = this.calculateHash(key);
        
        if(nodes[index] == null){
            return -1;
        }
        
        Node prev = findPrevious(nodes[index], key);
        if(prev.next == null ){
            return -1;
        }else{
            return prev.next.value;
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = this.calculateHash(key);
        
        if(nodes[index] == null){
            return;
        }
        
        Node prev = findPrevious(nodes[index], key);
        
        if(prev.next == null){
            return;
        }else{
            prev.next = prev.next.next;
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