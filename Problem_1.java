// Time Complexity : O(1)
// Space Complexity : O(1000) = O(1) (if we have n elements then O(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use the double hashing technique to achieve time and space complexity of O(1). We create a boolean array of size sqrt(n) and each
   array cell contains a pointer to another boolean array of size sqrt(n). The first mod hash func together with second divide hash funcn
   makes sure we dont encounter any collisons. While adding we check if storage[hash] has an existing pointer. If not we create one and set
   value at calculated cell as true. Similarly for deletion we check element at cell after calculating the two hashes and set its value to false.
   For lookup we calculate the 2 hashes and return value in that cell.
 */

 class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null) {
            if(hash1 == 0)
                storage[hash1] = new boolean[bucketItems + 1];
            else
                storage[hash1] = new boolean[bucketItems];
        }
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null)
            return;
        
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null)
            return false;
        
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
