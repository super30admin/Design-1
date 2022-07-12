class MyHashMap {
    Node[] nodes = null;

    class Node {
        int key, val;
        Node next;
        Node(int k, int v){
            key = k;
            val = v;
            next = null;
        }
    }
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    public void put(int key, int value) {
        int h = getHash(key);
        if(nodes[h] == null)
            nodes[h] = new Node(-1, -1); //create a placeholder 
        Node prev = findNode(nodes[h], key);
        if(prev.next == null){
            prev.next = new Node(key, value); // no node with this key, so add it
        }else{
            prev.next.val = value; // key exists, hence update its value
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = getHash(key);
        if(nodes[h] == null)
            return -1;
        Node prev = findNode(nodes[h], key); // returns a pointer to the prev of the node needed
        if(prev.next == null)
            return -1;
        else return prev.next.val;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = getHash(key);
        if(nodes[h] == null)
            return;
        Node prev = findNode(nodes[h], key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }

    private int getHash(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    private Node findNode(Node head, int key){
        Node prev = null, cur = head;
        while(cur!=null && cur.key != key){
            prev = cur;
            cur = cur.next;
        }
        return prev;

    }
}