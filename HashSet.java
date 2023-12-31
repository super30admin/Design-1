// Time Complexity : amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    class Node {
        Integer key;
        Node next;
        public Node(Integer key, Node next){
            this.key = key;
            this.next = next;
        }
    }

    private final int SET_SIZE = 10000;

    Node[] set = new Node[SET_SIZE];

    public MyHashSet() {
        
    }

    private Node find(int key){
        int index = hash(key);
        if(set[index] == null){
            return null;
        } else {
            Node prev = set[index];
            Node next = prev.next;
            while(next != null && next.key < key){
                prev = next;
                next = next.next;
            }
            return prev;
        }
    }

    private int hash(int key){
        return key%SET_SIZE;
    }
    
    public void add(int key) {
        int index = hash(key);
        if(set[index] == null){
            set[index] = new Node(null, null);
            set[index].next = new Node(key, null);
        } else {
            Node prev = find(key);
            if(prev.next == null || prev.next.key != key){
                Node n = new Node(key, prev.next);
                prev.next = n;
            }
        }
    }
    
    public void remove(int key) {
        Node prev = find(key);
        if(prev != null && prev.next != null && prev.next.key == key){
            prev.next = prev.next.next;
        }
    }
    
    public boolean contains(int key) {
        Node prev = find(key);
        return prev != null && prev.next != null && prev.next.key == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
