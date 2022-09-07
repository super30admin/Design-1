/*
All operation TC is O(1)
Code working on leetcode 
*/

class MyHashSet {

    boolean [][]storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int getBuckets(int key){
        return key % buckets;
    }
    
    private int getBucketItems(int key){
        return key / bucketItems;
    }
    public void add(int key) {
        int a = getBuckets(key);
        int b = getBucketItems(key);
        if(storage[a]==null){
            if(a==0){
                storage[a] = new boolean[bucketItems + 1];
            }
            else{
            storage[a] = new boolean[bucketItems];
            } 
        }
        storage[a][b] = true;   
    }
    
    public void remove(int key) {
        int a = getBuckets(key);
        int b = getBucketItems(key);
        
        if(storage[a]==null) return;
        storage[a][b] = false;

    }
    
    public boolean contains(int key) {
        int a = getBuckets(key);
        int b = getBucketItems(key);
        if(storage[a]==null) return false;
        
        return storage[a][b];
        

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */