// Time Complexity : O(1) for all operations
// Space Complexity : O(N) in worst case. Where N = 10^6.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/525804811/ 
// Any problem you faced while coding this : None. While thinking of BST I did.

class MyHashMap {
    private Integer[][] map;
    private int bucketIds;
    private int bucketPositions;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        // using sqrt(N) decided to keep size as 10^3
        bucketIds = bucketPositions = 1000;
        // map will be initialized to 10^3 null references
        map = new Integer[bucketIds][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // using two chain  hashing
        // first get bucket id
        int bucket = getBucket(key);
        // then index in that bucket
        int pos = getPositionInBucket(key);
        
        if(null == map[bucket])
        {
            // We need to store 10^3 elements in that case so index will be 1000 thus +1
            if(0 == bucket)
            {
                map[bucket] = new Integer[bucketPositions + 1];
            }
            else 
            {
                map[bucket] = new Integer[bucketPositions];
            }
        }
        
        map[bucket][pos] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = getBucket(key);
        int pos = getPositionInBucket(key);
        
        if(null == map[bucket] || null == map[bucket][pos])
        {
            return -1;
        }
       
        return map[bucket][pos]; //.intValue();
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = getBucket(key);
        int pos = getPositionInBucket(key);
        
        if(null == map[bucket])
        {
            return;
        }
        // We can't remove from array in O(1). SO Hack: assign a -1.    
        map[bucket][pos] = -1;
    }
    /** Only key is hashed as we can store any value at that key */
    // Helper function to get first hash or bucket Id in map
    private int getBucket(int key)
    {
        return key % bucketIds;
    }

    // Helper function to get second hash or index in map[bucketId]
    private int getPositionInBucket(int key)
    {
        return key / bucketPositions;
    }
}
