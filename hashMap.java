//Implementation using linear chaining. ie.
//following is how the nodes array look like
//[head, head, head .....]
//   |    |      |
// node  node  node
//   |    |      |
// node  node  node
//   |    |      |
// node  node  node
//time complexity O(n) where is the size of the chained linked list which is 100 here.
//space complexity O(N x n) where N is the size of the node array
class MyHashMap {
    class Node{
        int key; int val;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
    Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }
   //this returns the hashed index based on the key
   // % nodes.length ensures that the returned value
   // exits between 0 and nodes.length i.e array size 
    private int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    //this returns the prev node based on the key for a given LL(head)
    private Node find(Node head, int key){
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //if the key doesnt exit in nodes array
        int i = index(key);
        if(nodes[i] == null){
            nodes[i] = new Node(-1, -1);
        }
	//we create a prev node based on the head(nodes[i])
        Node prev = find(nodes[i], key);
	//if the prev is the tail
        if(prev.next == null){
            prev.next = new Node(key, value);	    
        } else {//its somewhere in the LL
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(key);
        if(nodes[i] == null) return -1;
        Node prev = find(nodes[i], key);
        if(prev.next == null) return -1;
        return prev.next.val;        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null) return;
        Node prev = find(nodes[i], key);
        if(prev.next == null) return;
        else{
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
