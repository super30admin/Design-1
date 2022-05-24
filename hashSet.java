import java.io.*;
import java.lang.*;

class MyHashSet {
    //Time complexity O(1) for all operations
    int bucket=1000;
    int bucketItems=1000;
    boolean[][] storage=new boolean[bucket][];
    public int bucket(int value){
        return value%bucket;
    }
    public int bucketItem(int value){
        return value/bucket;
    }
    public MyHashSet() {
      
    }
    
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]=new boolean[bucketItems+1];
            }
            else{
                storage[bucket]=new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]!=null){
            storage[bucket][bucketItem]=false;
        } 
    }
    
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        return storage[bucket]!=null && storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */