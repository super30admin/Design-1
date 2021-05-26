import java.util.Arrays;
import java.util.*;

class MyHashMap {

    /** Initialize your data structure here. */
    private int bucket;
    private int bucketItems;
    private int [][] storage;
    public MyHashMap() {
        bucket=1000;
        bucketItems=1000;
        storage=new int [bucket][];

    }
    public int bucket(int key){
        return key%bucket;
    }
     public int bucketItem(int key){
        return key/bucketItems;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket] == null){
            if(bucket== 0){
                storage[bucket]=new int [bucketItems+1];
            }
            else{
                storage[bucket]=new int [bucketItems];
            }
        }
        storage[bucket][bucketItem]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null){
            return -1;
        }
        return storage[bucket][bucketItem];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null)return;
        //storage = ArrayUtils.removeElement(storage,storage[bucket][bucketItem]);
        storage[bucket][bucketItem]= -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */