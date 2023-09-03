// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Design HashSet

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean [][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    public int getBucket(int key){
        return key%buckets;
    }

     public int getBucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        System.out.println("Key "+key);
         System.out.println("bucket "+bucket + "bucketItem " +bucketItem);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }else{
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

    public class Main {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        // Adding elements to the set
        set.add(1);
        set.add(2);
        set.add(3);

        // Checking if an element is in the set
        System.out.println("Contains 2: " + set.contains(2)); // Should print true
        System.out.println("Contains 4: " + set.contains(4)); // Should print false

        // Removing an element from the set
        set.remove(2);

        // Checking again after removal
        System.out.println("Contains 2: " + set.contains(2)); // Should print false
    }
}

}
