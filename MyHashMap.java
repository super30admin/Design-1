//time complexity o(1) for storage and retrival
class MyHashMap {
    int [] hash;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hash = new int[1000001];
        Arrays.fill(hash,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hash[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hash[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hash[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */