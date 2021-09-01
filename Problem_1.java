class MyHashMap {

    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node [] hashTable;
    int buckets;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = 10000;
        hashTable = new Node[buckets];
    }

    private int myHashCode(int key){
        return Integer.hashCode(key) % buckets;
    }

    private Node findNode( Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while( curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // get the hashcode
        int i = myHashCode(key);
        if( hashTable[i] == null){
            // setup the stating node
            hashTable[i] = new Node (-1, -1);
        }
        Node prev = findNode( hashTable[i], key);
        if( prev.next == null){
            // setup new value
            prev.next = new Node( key, value);
        }else{
            // update the value
            prev.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // get hash code
        int i = myHashCode(key);
        if( hashTable[i] == null) return -1;
        Node prev = findNode( hashTable[i], key);
        if( prev.next == null) return -1;
        return  prev.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = myHashCode(key);
        if( hashTable[i] == null) return;
        Node prev = findNode( hashTable[i], key);
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