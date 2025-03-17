// Time Complexity : O(1) for all add, remove and search operations
// Space Complexity : O(B + N) where: B is the number of buckets (1000), N is the number of non-empty buckets × bucketItems
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class MyHashSet {

    private boolean [][] hashSet;
    private int buckets;
    private int bucketItems;

    private int bucket(int key){
        return key%buckets;
    }

    private int bucketItem(int key){
        return key/bucketItems;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.hashSet = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucketKey = bucket(key);
        if (bucketKey == 0) {
            hashSet[bucketKey] = new boolean[bucketItems + 1];
        } else {
            hashSet[bucketKey] = new boolean[bucketItems];
        }        
        int bucketItemKeys = bucketItem(key);
        hashSet[bucketKey][bucketItemKeys] = true; 
    }
    
    public void remove(int key) {
         int bucketKey = bucket(key);
        if(hashSet[bucketKey] == null){
            return;
        }
        int bucketItemKeys = bucketItem(key);
        hashSet[bucketKey][bucketItemKeys] = false;  
    }
    
    public boolean contains(int key) {
        int bucketKey = bucket(key);
        if(hashSet[bucketKey] == null){
            return false;
        }
        int bucketItemKeys = bucketItem(key);
        return hashSet[bucketKey][bucketItemKeys]; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
