// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Only 25 cases passed on leet code, unable to locate the issue


// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;

    public MyHashSet() {
        bucket= 1000;
        bucketItems= 1000;
        storage= new boolean[bucket][];
    }
        
    public int getBucket(int i){
        return i%bucket;
        
    }
        public int getBucketItem(int i){
        return i/bucketItems; 
        
    }
        
    public void add(int key) {
        int bucketIndex= getBucket(key);
        int bucketItemIndex= getBucketItem(key);
        if(storage[bucketIndex]==null){
            if(bucketIndex==0){
                storage[bucketIndex]= new boolean[bucketItems+1];
            }else{
                storage[bucketIndex]= new boolean[bucketItems];
            }
            storage[bucketIndex][bucketItemIndex]= true;
        }
        
        
    }
    
    public void remove(int key) {
        int bucketIndex= getBucket(key);
        int bucketItemIndex= getBucketItem(key);
        if(storage[bucketIndex]==null){
            return;
        }
        
        storage[bucketIndex][bucketItemIndex]= false;
        }
        
    
    
    public boolean contains(int key) {
        int bucketIndex= getBucket(key);
        int bucketItemIndex= getBucketItem(key);
        if(storage[bucketIndex]==null){
            return false;
        }
        return storage[bucketIndex][bucketItemIndex];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */