class MyHashMap {

    class node {
        int key, val;
        node next;
        public node(int key, int val){
            this. key = key;
            this.val = val;
        }
    }

    node[] node;
    int size;

    private node find(node head, int key){
        node prev = null;
        node curr = head;
        while(curr != null && curr.key != key ){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private int getKey(int key){
        return Integer.hashCode(key);

    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 1000009;
        node = new node[size];

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getKey(key);
        if(node[idx] == null){
            node[idx] = new node (-1,-1);
        }
        node prev = find(node[idx], key);
        if(prev.next == null){
            prev. next = new node(key, value);
        }else{
            prev.next.val = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getKey(key);
        if (node[idx] == null){
            return -1;
        }
        node  prev = find(node[idx], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.val;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getKey(key);
        if(node[idx] == null){
            return;
        }
        node prev = find(node[idx], key);
        if(prev.next == null){
            return;
        }
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