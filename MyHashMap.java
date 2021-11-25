// Time Complexity : find : O(length of list), put O(length of list), get: O(length of list) remove (length of list)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class MyHashMap {
    class Node {
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes;
    int buckets;
    private int getHash(int key){
        return Integer.hashCode(key) % buckets;
    }

    private Node find(Node node,int key){ // traverse through the nodes till you find the node with key value
        Node prev = node;
        Node current = prev.next;
        while(current != null && prev.next.key != key){
            prev = current;
            current = current.next;
        }
        return prev;
    }

    public MyHashMap() {
        buckets = 1000;
        nodes = new Node[buckets];
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if(nodes[index] == null){
             nodes[index] = new Node(-1,-1); // insert a dummy node with -1, -1 as removal becomes with easy when this dummy node is present
        }
        Node prev = find(nodes[index],key); // if nodes are already present as prev returned by find method points to last node insert node after previos node
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else
            prev.next.value = value;
    }

    public int get(int key) {
        int index = getHash(key);
        if(nodes[index] == null)
            return -1;
        Node prev = find(nodes[index],key); // find node if present return value else -1
        if(prev.next == null)
            return -1;
        else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        if(nodes[index] == null)
            return;
        Node prev = find(nodes[index],key); // find node and remove if found else return
        if(prev.next == null)
            return;
        else
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
