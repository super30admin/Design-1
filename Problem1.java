// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Pair<K, V> {
    public K key;
    public V val;
    
    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(Integer key) {
        for(Pair<Integer, Integer> pair: this.bucket) {
            if(pair.key.equals(key)) {
                return pair.val;
            }
        }
        return -1;
    }
    
    public void update(Integer key, Integer value) {
        boolean found = false;
        for(Pair<Integer, Integer> pair: this.bucket) {
            if(pair.key.equals(key)) {
                pair.val = value;
                found = true;
                break;
            }
        }
        
        if (!found) {
            this.bucket.add(new Pair<Integer, Integer> (key, value));
        }
    } 
    
    public void remove(Integer key) {
        for(Pair<Integer, Integer> pair: this.bucket) {
            if(pair.key.equals(key)) {
                this.bucket.remove(pair);
                break;
            } 
        }
    }
}
class MyHashMap {
    
    private int k;
    private List<Bucket> hashTable;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.k = 2003;
        this.hashTable = new ArrayList<Bucket>();
        for(int i = 0; i < this.k; i++) {
            this.hashTable.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % this.k;
        this.hashTable.get(hashKey).update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key % this.k;
        return this.hashTable.get(hashKey).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % this.k;
        this.hashTable.get(hashKey).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */