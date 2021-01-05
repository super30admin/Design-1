// Time for lookup - O(1)
// Space - O(N)

class MyHashMap {

    int[][] hashmap;
    int buckets = 1000;
    
    private int hash1(int key) {
        return key % buckets;
    }
    
    private int hash2(int key) {
        return key / buckets;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new int[buckets][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = hash1(key);
        int j = hash2(key);
        if(hashmap[i] == null) {
            hashmap[i] = new int[buckets];
        }
            
        hashmap[i][j] = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = hash1(key);
        int j = hash2(key);
        if(hashmap[i]==null || hashmap[i][j] == -1){
            return -1;
        }
        return hashmap[i][j];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = hash1(key);
        int j = hash2(key);
        if(hashmap[i]==null) {
            return;
        }
        hashmap[i][j] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
