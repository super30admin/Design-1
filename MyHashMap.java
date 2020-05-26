/*
Time complexity : put : O(1)
                  remove O(1)
                  get O(1)
Space Complexity : O(N) N = input size

Is worked on leetcode : YES
*/


class MyHashMap {
    Integer [][] storage;
    int buckets;
    int bucket_items;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets =1001;
        bucket_items=1000;
        storage = new Integer[buckets][];
    }
    private int bucket(int key){
        return key %  buckets;
    }
    
    
    private int bucket_item (int key){
        return  key / bucket_items;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket_no = bucket(key);
        int bucket_item_no = bucket_item(key);
        if(storage[bucket_no] == null){
            storage[bucket_no] = new Integer[bucket_items];
        }
        storage[bucket_no][bucket_item_no] = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket_no = bucket(key);
        int bucket_item_no = bucket_item(key);
        if(storage[bucket_no] != null){
            if(storage[bucket_no][bucket_item_no] == null){
                return -1;
            }else{
                return storage[bucket_no][bucket_item_no];
            }
        }
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket_no = bucket(key);
        int bucket_item_no = bucket_item(key);
        if(storage[bucket_no] != null){
            storage[bucket_no][bucket_item_no]  = null;
        }
        
    }
    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(1, 1);
        hm.get(1);
        
        
    }
}
