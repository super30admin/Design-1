class MyHashMap {

    class Node{
        int val;
        int key;
        Node next;
        public Node(int _val, int _key){
            val = _val;
            key = _key;
        }
    }
    Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[1000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getHashCode(key);
        Node prev = find(index,key);
        if(prev.next == null){
            prev.next = new Node(value, key);
        }else{
            prev.next.val = value;
        }
    }

    /**
     *
     * @param index
     * @param key
     * @return
     */
    public Node find(int index, int key){
        if(nodes[index] == null){
            return nodes[index] = new Node(-1,-1);
        }
        Node prev = nodes[index];

        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    }

    public int getHashCode(int key){
        return Integer.hashCode(key) % (nodes.length-1);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHashCode(key);
        Node prev = find(index,key);
        if(prev.next != null && prev.next.key == key){
            return prev.next.val;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getHashCode(key);
        Node prev = find(index,key);
        if(prev.next != null && prev.next.key == key){
            prev.next = prev.next.next;
        }
    }

    /**
     * Time Complexity - O(n) - Put(), O(n) - get(), O(n) - remove()
     * Space Complexity - O(n) - n elements - Here i tried 100k (given in question - constraints) first, then 10k then 1000. I got best efficently with 1000 size.
     */
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */