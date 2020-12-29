class MyHashMap {

    class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node [] nodes;
    private int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private Node find(Node head, int key){
        Node temp1 = head, temp2 = null;
        while(temp1 != null && temp1.key != key){
            temp2 = temp1;
            temp1 = temp1.next;
        }
        return temp2;
    }
    /** value will always be non-negative. */
    //TC - O(n) 
    public void put(int key, int value) {
        int i = index(key);
        if(nodes[i] == null){
            nodes[i] = new Node(-1, -1);
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    //TC - O(n) 
    public int get(int key) {
        int i = index(key);
        if(nodes[i] == null) return -1;
        Node prev = find(nodes[i], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    //TC - O(n) 
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null) return;
        Node prev = find(nodes[i], key);
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
