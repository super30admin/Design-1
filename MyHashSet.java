import java.util.*;
class MyHashSet {
    private boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets =1000;
        this.bucketItems = 1000;
        this.storage  = new boolean[buckets][];
    }
    private int hash1(int key){
        return key%buckets;
    }
    private int hash2(int key){
        return key/bucketItems;
    }

    public void add(){
        int hash1 =  hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1]== null){
            if(hash1  == 0){
                storage[hash1] = new  boolean[bucketItems+1];
            }
            else{
                storage[hash1] = new  boolean[bucketItems];
            }
        }
        storage[hash1][hash2] =  true;
    }
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return;
       
        storage[hash1][hash2] = false;
        
    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if(storage[hash1] == null) return false;
        return storage[hash1][hash2];
    }


}

