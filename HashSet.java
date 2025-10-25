// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    public int buckets;
    public int bucketItems;
    public boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];     
    }
    
    public void add(int key) {
        int bucket =  hashFunctionOne(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
               storage[bucket] = new boolean[bucketItems];
            }
        }
        int bucketItem = hashFunctionTwo(key);
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hashFunctionOne(key);
        int bucketItem =  hashFunctionTwo(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
         int bucket = hashFunctionOne(key);
        int bucketItem =  hashFunctionTwo(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
        
    }

    public int hashFunctionOne(int key){
        return key % buckets;
    }

    public int hashFunctionTwo(int key){
        return key / bucketItems;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */