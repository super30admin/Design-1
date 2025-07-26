// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for storing elements in the hash set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * This implementation uses double hashing to resolve collisions.
 * Primary hash key is calculated using modulo operation, and secondary hash key is calculated using integer division.
 * If Primary bucket is empty a new secondary bucket is created, and the value True is set for the corresponding secondary key.In case of removal, the value is set to False.
 */
class MyHashSet {
    int PrimaryBuckets;
    int SecondaryBuckets;
    boolean DoubleHashSet[][];

    public MyHashSet() {
        this.PrimaryBuckets=1000;
        this.SecondaryBuckets=1000;
        this.DoubleHashSet=new boolean[PrimaryBuckets][];
    }

    public int GetPrimaryHashKey(int key){
        return key%PrimaryBuckets;
    }

      public int GetSecondaryHashKey(int key){
        return key/PrimaryBuckets;
    }
    
    public void add(int key) {
        int PrimaryKey=GetPrimaryHashKey(key);
        int SecondaryKey=GetSecondaryHashKey(key);
        if(DoubleHashSet[PrimaryKey]==null)
        {
            if(PrimaryKey==0)
            {
            boolean[] SecondaryBucket=new boolean[SecondaryBuckets+1];
            DoubleHashSet[PrimaryKey]=SecondaryBucket;
            }
            else
            {
            boolean[] SecondaryBucket=new boolean[SecondaryBuckets];
            DoubleHashSet[PrimaryKey]=SecondaryBucket;
            }
        }
        DoubleHashSet[PrimaryKey][SecondaryKey]=true; 
        
    }
    
    public void remove(int key) {
        int PrimaryKey=GetPrimaryHashKey(key);
        int SecondaryKey=GetSecondaryHashKey(key);
         if(DoubleHashSet[PrimaryKey]==null)
         {
            return;
         }
         else
         {
             DoubleHashSet[PrimaryKey][SecondaryKey]=false;
         }
        
    }
    
    public boolean contains(int key)
    {
        int PrimaryKey=GetPrimaryHashKey(key);
        int SecondaryKey=GetSecondaryHashKey(key);
         if(DoubleHashSet[PrimaryKey]==null)
         {
            return false;
         }
         return DoubleHashSet[PrimaryKey][SecondaryKey];
    }    
        
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */