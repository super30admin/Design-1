// Time Complexity : O(1) for put, get and remove
// Space Complexity : O(1) for put, get and remove
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope

class MyHashMap {
    
    /*
    Thought process:
    
    We can solve this using Double Hashing technique which is faster in time but consumes more space
    Doing this by Separate Chaining method:
    
    We'll have a array of LinkedList. Need to choose the length of LL in such a way that it is not very
    long as it will be O(N) in finding an element.
    
    So we choose 100 as LL length and 10000 as parent array size
    
    We need a class Node to design as it is a design problem.
    Next, index func to compute index of a given key. Use (hashCode or array length) % nodes.length
    Next, find method, which will help find a given key
    
    */
    
    class Node{
        int key, value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] nodes;
    
    public int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    public Node find(Node head, int key){
        Node curr = head, prev = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index]==null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        prev.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        if(nodes[index]==null) return -1;
        Node prev = find(nodes[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null) return;
        Node prev = find(nodes[index], key);
        if(prev.next != null){
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
