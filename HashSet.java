// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//I have used concept of double hashing and implemented the same using 2D array. As the range of input is
// 0 to 10^6, we can have 1000 buckets with each bucket being able to have max 1000 elements.
// Primary hashing functions maps the input to a bucket
//second hashing function maps to the array index .
//for addition we use the above to find appropriate insert location.
//for removal, we use both above to find the location of element to be removed.
//same logic for contains
//if at any point of time while performing operation, if bucket points to null, it means elements are not present



class MyHashSet {
    //double hashing approach
    boolean[][] storage;
    int primaryBuckets;
    int secondaryBuckets;
    public MyHashSet() {
        primaryBuckets=1000;
        secondaryBuckets=1000;
        storage=new boolean[primaryBuckets][];

    }

    private int getPrimaryKey(int key)
    {
        return key % primaryBuckets;
    }

    private int getSecondaryKey(int key)
    {
        return key / secondaryBuckets;
    }

    public void add(int key) {
        int primaryIndex=getPrimaryKey(key);
        if(storage[primaryIndex]==null)
        {
            if(primaryIndex==0)
                storage[primaryIndex]=new boolean[secondaryBuckets+1];
            else
                storage[primaryIndex]=new boolean[secondaryBuckets];
        }

        int secondaryIndex=getSecondaryKey(key);
        storage[primaryIndex][secondaryIndex]=true;
    }


    public void remove(int key) {
        int primaryIndex=getPrimaryKey(key);
        if(storage[primaryIndex]==null)
        {
            return;
        }
        int secondaryIndex=getSecondaryKey(key);
        storage[primaryIndex][secondaryIndex]=false;
    }

    public boolean contains(int key) {
        int primaryIndex=getPrimaryKey(key);
        if(storage[primaryIndex]==null)
        {
            return false;
        }
        int secondaryIndex=getSecondaryKey(key);
        return storage[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */