// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes, Runtime 12 ms; Beats - 98.30%

// Any problem you faced while coding this : yes - i forogt that i could access a 2-d array as set[primaryBucket], no need to access as set[primaryBucket][]


// Your code here along with comments explaining your approach
class MyHashSet {

    int buckets;
    int bucketSize;
    boolean [][] set;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketSize = 1000;
        set = new boolean[1000][];
    }

    private int hash1(int key)
    {
        return key%buckets;
    }

    private int hash2(int key)
    {
        return key/bucketSize;
    }
    
    public void add(int key) {
        int primaryBucket = hash1(key);
        if(set[primaryBucket] == null)
        {
            if(0 == primaryBucket)
            {
                set[primaryBucket] = new boolean[bucketSize+1];
            }
            else
            {
                set[primaryBucket] = new boolean[bucketSize];
            }
        }
        int secondaryBucket = hash2(key);
        set[primaryBucket][secondaryBucket] = true;
    }
    
    public void remove(int key) {
        int primaryBucket = hash1(key);
        if(null != set[primaryBucket])
        {
            int secondaryBucket = hash2(key);
            set[primaryBucket][secondaryBucket] = false;
        }
    }
    
    public boolean contains(int key) {
        int primaryBucket = hash1(key);
        if(null != set[primaryBucket])
        {
            int secondaryBucket = hash2(key);
            return set[primaryBucket][secondaryBucket];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */