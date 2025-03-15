// Time Complexity :O(1) for add, remove, contains methods.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Approach: Used double hashing technique with 2D boolean array. 
// Primaryhash function decides the index the main bucket.
// Secondaryhash function decides collisions at particular index in primary bucket. 



class MyHashSet {
    boolean[][] storage;
    int primaryBuckets;
    int secondaryBuckets;

    public MyHashSet() 
    {
        this.primaryBuckets=1000;
        this.secondaryBuckets=1001;
        this.storage=new boolean[primaryBuckets][];
    }

    private int getPrimaryHash(int key)
    {
        return key%primaryBuckets;
    }

    private int getSecondaryHash(int key)
    {
        return key/secondaryBuckets;
    }
    
    public void add(int key) 
    {
        int pIndex=getPrimaryHash(key);
        if(storage[pIndex]==null)
        {
            storage[pIndex]=new boolean[secondaryBuckets];
        }
        int sIndex=getSecondaryHash(key);
        storage[pIndex][sIndex]=true;
    }
    
    public void remove(int key)
     {
        int pIndex=getPrimaryHash(key);
        if(storage[pIndex]==null)
        {
            return;
        }
        int sIndex=getSecondaryHash(key);
        storage[pIndex][sIndex]=false;
    }
    
    public boolean contains(int key) {
        int pIndex=getPrimaryHash(key);
        if(storage[pIndex]==null)
        {
            return false;
        }
        int sIndex=getSecondaryHash(key);
        return storage[pIndex][sIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */