// Time Complexity : add = O(1); remove = O(1); contains = O(1)
// Space Complexity : O(1) as no extra space needed apart from input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    /* Double Hashing technique is being used */

    int buckets;
    int bucketItems;
    boolean storage[][];
    
    public MyHashSet() {
        buckets = 1000;    // for equal distribution
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key%buckets;
    }
    
    private int hash2(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if (storage[hash1] == null){
           if(hash1 == 0)
               storage[hash1] = new boolean[bucketItems+1]; //to accomodate the boundary case [0,10^6]
            else
                storage[hash1] = new boolean[bucketItems]; 
        }
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        
        if (storage[hash1] != null){
            int hash2 = hash2(key);
            storage[hash1][hash2] = false;
        } else{     // if storage[hash1] == null => no elements were added
            return;
        }
    }
    
    public boolean contains(int key) {
         int hash1 = hash1(key);
        if (storage[hash1] == null) // if storage[hash1] == null => no elements were added
            return false;
        else{
            int hash2 = hash2(key);
            return storage[hash1][hash2];
        }
            
    }

    public static void main(String args[]) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}

