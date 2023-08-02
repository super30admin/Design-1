// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    int buckets;
    int bucketItems;
    boolean[][] storage;
    
    public MyHashSet() {
        this.buckets =1000;  // Square root of highestbound given for key values
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][]; 
    }
    public int hashMethod1(int key)
    {
        return key%buckets;  
    }
    public int hashMethod2(int key)
    {
        return key/buckets;
    }
    public void add(int key) {
        int bucket= hashMethod1(key);
        int bucketItem = hashMethod2(key);
        if(storage[bucket]==null)
        {
            if(bucket == 0){
            storage[bucket]= new boolean[bucketItems+1]; 
            }
            else{
            storage[bucket] = new boolean[bucketItems];
            }
            
        }
        storage[bucket][bucketItem] = true;
       
    }
    
    public void remove(int key) {
        int bucket= hashMethod1(key);
        int bucketItem = hashMethod2(key);
        if(storage[bucket]==null)
        {
            
            return;
        }
        
        else
        storage[bucket][bucketItem] = false;

    }
    
    public boolean contains(int key) {
        int bucket= hashMethod1(key);
        int bucketItem = hashMethod2(key);
        if(storage[bucket]==null)
        {
            return false;
        }
       return storage[bucket][bucketItem] ;
        
}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
