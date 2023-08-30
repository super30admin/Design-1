// Problem 1:(https://leetcode.com/problems/design-hashset/)

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
//approach: created a 2D boolean array to act as a hashset. two hashing functions were defined, one primary which decides the location of the row in 2D array and the other which defines the position in the column of the array. The first row of the the 2D array has a bigger size than others to accomodate the edge case of 10^6.

class MyHashSet {

    int buckets ;
    int bucketItems ;
    boolean[][] s;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        s = new boolean[buckets][];
        
    }

    private int posBucket(int key)
    {
        return key%buckets;
    }

    private int posBucketItem(int key)
    {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = posBucket(key);
        int bucketItem = posBucketItem(key);

        if(s[bucket]==null)
        {
            if(bucket==0)
            {
                s[bucket] = new boolean[bucketItems+1];
            }
            else
            {
                s[bucket] = new boolean[bucketItems];
            }
        }
        s[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket = posBucket(key);
        int bucketItem = posBucketItem(key);

        if(s[bucket]==null)
        {
            return;
        }
        s[bucket][bucketItem]=false;
        
    }
    
    public boolean contains(int key) {
        int bucket = posBucket(key);
        int bucketItem = posBucketItem(key);

        if(s[bucket]==null)
        {
            return false;
        }
        return s[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */