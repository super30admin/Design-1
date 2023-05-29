// Time Complexity : contains, remove O(1), add - amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// we have used 2 arrays. the primary array of 1000 elements and a secondary array of 1000 elements at each of the indexes of the primary array.
// 


class MyHashSet {
    private int primary;
    private int secondary;
    private boolean[][] storage;
    public MyHashSet() {
        this.primary= 1000;
        this.secondary= 1000;
        this.storage = new boolean[primary][];
        
    }

    public int hash1(int key)
    {
        return key%primary;
    }

    public int hash2(int key)
    {
        return key/secondary;
    }
    
    public void add(int key) {
        int primaryIndex = hash1(key); 
        int secondaryIndex= hash2(key);
        if(storage[primaryIndex] == null)
        {
            if(primaryIndex==0)
            {
                storage[primaryIndex] = new boolean[secondary+1];
            }
            else
            {
                storage[primaryIndex] = new boolean[secondary];
            }
        }
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = hash1(key); 
        if(storage[primaryIndex] == null) return;
        int secondaryIndex= hash2(key);
        storage[primaryIndex][secondaryIndex] = false;
        
    }
    
    public boolean contains(int key) {
        int primaryIndex = hash1(key);
        if(storage[primaryIndex] == null) return false;
        else {
        int secondaryIndex= hash2(key);
        return storage[primaryIndex][secondaryIndex];
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