//Implement Hashset without using any in-built libraries to add the value, remove the value and check if it contains a particular value or not.
//Time Complexity: O(1)
//Space Complexity : O(1)


public class Problem_705 {
    public static void main(String[] args) {
        MyHashSet hash = new MyHashSet();
        hash.add(10);
        hash.add(20);
        hash.add(43);
        hash.add(5);
        hash.remove(43);
        System.out.println(hash.contains(90));
        System.out.println(hash.contains(5));
        
    }
    
}
class MyHashSet {
    // 2D array will have the null value at the time of initialization.
    boolean[][] storage;
    //buckets for the primary array
    int buckets;
    //bucket items for the secondary array.
    int bucketItems;

    public MyHashSet() {
        // buckets and bucketItems have 10^3 value because the size is 10^6 and we required the squareroot of 10^6.
        buckets = 1000;
        bucketItems = 1000;
        // Initialize the primary array of storage. 
        storage = new boolean[buckets][];
    }
    // First hash function to get the index of primary array.
    private int getBucket(int key){
        return key % buckets;
    }
    // Second hash function to get the index of secondary array.
    private int getBucketItem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        // If we have not initialized secondary array at a particular index of a primary array.
        if(storage[bucket] == null){
            // If it is the 0th index then we have to take 1001 value in that array because of the value 10^6.
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            } // Else 1000 values enough.
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
