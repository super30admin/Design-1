class MyHashMap {
    int[] keys;
    int[] values;

    /** Initialize your data structure here. */
    public MyHashMap() {
        // initializing the size of keys array to the limit given in the problem
        keys = new int[1000000];
        // initialize each key to -1
        Arrays.fill(keys, -1);
        values = new int[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // set value at index "key" in keys array to value
        keys[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // if the value at keys[key] is not -1, we have a value, return that.
        if(keys[key] != -1){
            return keys[key];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // if that key doesn't exist, it is -1, return immediately
        if(keys[key] == -1)
            return;
        // set the value at keys[key] to -1 to remove the key
        keys[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
