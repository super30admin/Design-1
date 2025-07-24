// O(1) for all the operations
// This uses linear chaining approach which stores values in a linkedlist approach for conflicting hash values.
class Node {
    int val;
    Node next;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyHashSet {

    Node[] set;
    int primarySize;

    public MyHashSet() {
      // Adding size to be 1000 as per the input range
        this.primarySize = 1000;
        set = new Node[primarySize];
    }

    private int getHash(int val) {
        return val%primarySize;
    }

    // Method to get the reference for the previous element
    private Node getPrev(Node node, int key) {
        if(node==null) return null;
        while(node.next!=null && node.next.val!=key) {
            node = node.next;
        }
        return node;
    }
    
    public void add(int key) {
        int hash = getHash(key);
        if(set[hash]==null) {
          // Add a new dummy node if there is no entry in this hash
            Node node = new Node(-1);
            set[hash] = node;
        }
        Node prev = getPrev(set[hash], key);
      // Add a new node if there is no entry in this hash otherwise, do nothing
        if(prev.next==null) {
            Node nodeNew = new Node(key);
            prev.next = nodeNew;
        }
    }
    
    public void remove(int key) {
        int hash = getHash(key);
      // Do nothing if entry for hash itself is not present
        if(set[hash]==null) {
            return;
        }
        Node prev = getPrev(set[hash], key);
      // Remove element by mapping based on if its present or not present
        prev.next = prev.next==null?null:prev.next.next;
    }
    
    public boolean contains(int key) {
        int hash = getHash(key);
        if(set[hash]==null) {
            return false;
        }
        Node prev = getPrev(set[hash], key);
        if(prev.next==null) {
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
