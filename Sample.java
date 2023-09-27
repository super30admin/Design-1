// Time Complexity : O(1) for add, remove, contains 
// Space Complexity : O(1) for add,remove, contains 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    boolean[][] data;  
    int buckets;
    int bucketItems;

    public MyHashSet() {
     this.buckets = 1000;
     this.bucketItems = 1000;
     this.data = new boolean[1000][];  
    }
    
    int hash1(int key) {
        return key % buckets;
    }

       int hash2(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        if(data[bucket] == null)
        {
          if (bucket == 0)  {
        data[bucket] = new boolean[ bucketItems + 1];}
        else data[bucket] = new boolean[bucketItems];
        }
        
            int bucketItem = hash2(key);
            data[bucket][bucketItem] = true;
        

    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        if(data[bucket] == null) return;
       
             int bucketItem = hash2(key);
            data[bucket][bucketItem] = false;

        
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        if(data[bucket] == null) return false;
         int bucketItem = hash2(key);
         return data[bucket][bucketItem] ;
        

    }
}
