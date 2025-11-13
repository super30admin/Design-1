// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for the boolean array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Initialized a boolean[][] array storage with size as 1000
 * 
 * In add, the key is hashed initally with % operator and retrieved the idx of storage []
 * Then key is again hashed but with / operator to retrieve the vertical idx of storage[][]
 * the idx of 2nd hash function is set to true to indicate its presence.
 * 
 * In remove, repeat the same steps but the idx of 2nd hash function is set to false
 * 
 * In contains, we do the same but if the storage[idx1] is null, return false. Else return whatever is present 
 * in storage[idx1][idx2]
 */


public class DesignHashSet {
    int buckets;
    int innerBuckets;
    boolean[][] storage;

    public DesignHashSet() {
        buckets = 1000;
        innerBuckets = 1000;
        storage = new boolean[buckets][];    
    }
    
    public void add(int key) {
        int hash1 = computeHash1(key);
        int hash2 = computeHash2(key);
        if(storage[hash1] == null) {
            storage[hash1] = new boolean[innerBuckets];
        }
        
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = computeHash1(key);
        int hash2 = computeHash2(key);
        if(storage[hash1] == null) {
            return;
        }

        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = computeHash1(key);
        int hash2 = computeHash2(key);
        if(storage[hash1] == null) {
            return false;
        } else {
            return storage[hash1][hash2];
        }
    }

    private int computeHash1(int key) {
        return key % buckets;
    }

    private int computeHash2(int key) {
        return key / innerBuckets;
    }

    public static void main(String[] args) {
        DesignHashSet myHashSet = new DesignHashSet();
        myHashSet.add(1);      
        myHashSet.add(2);      
        System.out.println(myHashSet.contains(1)); //return True
        System.out.println(myHashSet.contains(3)); // return False
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));
    }
}


