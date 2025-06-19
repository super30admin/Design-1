// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Approach - To implement hashset without built in libraries
 * i will use double hashing. It will handle collisions. 
 */
class MyHashSet {

    // first array in 2D array
    int bucket;
    // first array in 2D array
    int bucketItem;
    boolean[][] storage;
    int MAX = 1000;

    public MyHashSet() {
        this.bucket = MAX;
        this.bucketItem = MAX;
        this.storage = new boolean[bucket][]; 
    }

    // to get hashing function for primary key
    private int getPrimaryKeyHash(int key){
        return key%MAX;
    }
    
    // to get hashing function for secondary key
    private int getSecondaryKeyHash(int key){
        return key/MAX;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryKeyHash(key);
        if(storage[primaryIndex] == null){
            // Handling edge case
            if(primaryIndex==0){
                storage[primaryIndex] = new boolean[bucketItem+1];
            }
            else{
                storage[primaryIndex] = new boolean[bucketItem];
            }
        }

        // adding element to storage
        int secondaryIndex = getSecondaryKeyHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryKeyHash(key);
        // if element do not exist
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = getSecondaryKeyHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = getPrimaryKeyHash(key);
        if(storage[primaryIndex] == null){
            return false;
        }

        // returning element value if first array is not null
        int secondaryIndex = getSecondaryKeyHash(key);
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
