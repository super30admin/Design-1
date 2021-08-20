// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashMap {

    /** Initialize your data structure here. */
    Node pairs[][];
    int buckets;
    int bucketNums;
    public MyHashMap() {
        buckets = 1000;
        bucketNums = 1000;
        pairs = new Node[buckets][];
    }
    
    public int getBucketLocation(int key){
        return key % bucketNums;
        
    }
    public int getKeyLocation(int key){
        return key / bucketNums;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket_index = getBucketLocation(key);
        int key_index = getKeyLocation(key);
        if (pairs[bucket_index] == null){
            if (bucket_index == 0) {
                pairs[bucket_index] = new Node[bucketNums + 1];
            }
            else{
                pairs[bucket_index] = new Node[bucketNums];
            }
        }
        pairs[bucket_index][key_index] = new Node(key, value);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket_index = getBucketLocation(key);
        int key_index = getKeyLocation(key);
        if (pairs[bucket_index] == null || pairs[bucket_index][key_index] == null){
            return -1;
        }
        else{
            return pairs[bucket_index][key_index].value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket_index = getBucketLocation(key);
        int key_index = getKeyLocation(key);
        if (pairs[bucket_index] == null || pairs[bucket_index][key_index] == null){
            return;
        }
        else{
            pairs[bucket_index][key_index] = null;
        }
        
    }
}

class Node{
    int key;
    int value;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */