// Time Complexity : O(n) in the worst case where every element has collision otherwise O(n/keyspace)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private int keySpace;
    private List<Bucket> hashTable;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList();
        for(int i=0;i<this.keySpace;i++) {
            this.hashTable.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%this.keySpace;
        Bucket b = hashTable.get(index);
        b.update(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%this.keySpace;
        return this.hashTable.get(index).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%this.keySpace;
        this.hashTable.get(index).remove(key);
    }
}

class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList();
    }

    public Integer get(Integer key) {
        for(Pair<Integer, Integer> pair : this.bucket) {
            if(pair != null && pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean found = false;
        for(Pair<Integer, Integer> pair : this.bucket) {
            if(pair != null && pair.key.equals(key)) {
                pair.value = value;
                found = true;
            }
        }
        if(!found) {
            Pair pair = new Pair(key, value);
            this.bucket.add(pair);
        }
    }

    public void remove(Integer key) {
        for(Pair<Integer, Integer> pair : this.bucket) {
            if(pair != null && pair.key.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */