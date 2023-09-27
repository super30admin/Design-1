// Time Complexity :  O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class MyHashSet {

    private boolean[][] buckets;
    private int bucketSize = 1000;
    private int nestedSize = 1000;
        
    public int hashBucket(int key){
        return key%bucketSize;
    }
    
    public int hashNested(int key){
        return key/nestedSize;
    }
    
    public MyHashSet() {
        buckets = new boolean[bucketSize][];
    }
    
    public void add(int key) {
        // Check for null in bucket first position
        //If not create secondary arrayy
        // If there, add set the vakue to true. 
        int val1 = hashBucket(key); //get the key for first bucket
        int val2 = hashNested(key); //get the key for second bucket
        
        if( buckets[val1] == null && val1 == 0)
            buckets[val1] = new boolean[nestedSize + 1];
        else if( buckets[val1] == null)
            buckets[val1] = new boolean[nestedSize];
      
        buckets[val1][val2] = true;
      
    }
    
    public void remove(int key) {
        int val1 = hashBucket(key);
        int val2 = hashNested(key);
        if (buckets[val1] == null)
            return;
        
        buckets[val1][val2] = false;
    }
    
    public boolean contains(int key) {
        int val1 = hashBucket(key);
        int val2 = hashNested(key);

        if (buckets[val1] == null)
            return false;
        
        return buckets[val1][val2];

        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
