// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {
    int buckets;
    int bucketsize;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets=1000;
        this.bucketsize=1000;
        storage= new boolean[buckets][];
    }
    private int getOuterHash(int key)
    {
        return key % buckets;
    }

    private int getInnerHash(int key)
    {
        return key/bucketsize;
    }
    
    public void add(int key) {
        int outerHash = getOuterHash(key);
        if(storage[outerHash]==null)
        {
        if(outerHash==0)
        storage[outerHash]= new boolean[bucketsize+1];
        
        else
        {
            storage[outerHash]= new boolean[bucketsize+1];
        }

        }

        int innerHash=getInnerHash(key);
        storage[outerHash][innerHash]= true;
    }
    
    public void remove(int key) {
        int outerHash = getOuterHash(key);
        if(storage[outerHash]!=null)
        {
            int innerHash = getInnerHash(key);
            storage[outerHash][innerHash]=false;
        }
    }
    
    public boolean contains(int key) {
        int outerHash= getOuterHash(key);
        if(storage[outerHash]== null)
        return false;

        else
        {
            int innerHash= getInnerHash(key);
            return storage[outerHash][innerHash];

        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
