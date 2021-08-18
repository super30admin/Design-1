// Time Complexity : O(n/k) -> n: number of possible keys, k: number of predefined buckets
// Space Complexity : O(k + m) -> m: number of unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Pair<U, V> {
    public U first;
    public V second;
    
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(Integer key) {
        for(Pair<Integer, Integer> pair : this.bucket) {
            if(pair.first.equals(key))
                return pair.second;
        }
        return -1;
    }
    
    public void update(Integer key, Integer value) {
        boolean found = false;
        for(Pair<Integer, Integer> pair : this.bucket) {
            if(pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if(!found)
            this.bucket.add(new Pair<Integer, Integer>(key, value));
    }
    
    public void delete(Integer key) {
        for(Pair<Integer, Integer> pair : this.bucket) {
            if(pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

class MyHashMap {

    List<Bucket> hashmap;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.hashmap = new ArrayList<Bucket>();
        for(int i = 0; i < 1000; i++) {
            this.hashmap.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int new_hashkey = key % 1000;
        this.hashmap.get(new_hashkey).update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int new_hashkey = key % 1000;
        return this.hashmap.get(new_hashkey).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int new_hashkey = key % 1000;
        this.hashmap.get(new_hashkey).delete(key);
    }
}