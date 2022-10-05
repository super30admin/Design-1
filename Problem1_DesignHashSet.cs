// Time Complexity : O(1) for all operations, including Add, Remove and Contains
// Space Complexity : O(n) to store the hashset
// Approach - using double hashing where we have one jagged array, first dimension representing the bucket container and second dimension representing the buckets to store the elements  
public class MyHashSet {

    static readonly int bucketSize1 = 1000;
    static readonly int bucketSize2 = 1000;
    
    bool[][] hashSet;
        
    public MyHashSet() {
        hashSet = new bool[bucketSize1+1][];
    }
    
    public void Add(int key) {
        int hash1 = key/bucketSize1;
        int hash2 = key%bucketSize2;
        
        if(hashSet[hash1] == null)
        {
            hashSet[hash1] = hash1==1000 ? new bool[1] : new bool[bucketSize2] ;
        }
        
        hashSet[hash1][hash2] = true;
    }
    
    public void Remove(int key) {
        int hash1 = key/bucketSize1;
        int hash2 = key%bucketSize2;
        
        if(hashSet[hash1] != null)
            hashSet[hash1][hash2] = false;
    }
    
    public bool Contains(int key) {
        int hash1 = key/bucketSize1;
        int hash2 = key%bucketSize2;
        
        if(hashSet[hash1] == null)
            return false;
        return hashSet[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */