// Time Complexity : getBucket-O(1),getBucketItem-O(1),add-O(1).remove-O(1),contains-O(1)
// Space Complexity :O(n)
class MyHashSet {
    int buckets;// size of primary array
    int bucketItems;// size of secondary array
    boolean[][] storage;// 2-D array

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[this.buckets][];

    }

    // Hash function for getting indices of primary array
    public int getBucket(int key) {
        return key % this.buckets;
    }

    // Hash function for getting indices of secondary array
    public int getBucketItems(int key) {
        return key / this.bucketItems;
    }

    // adding values/data into arrays
    public void add(int key) {
        int bucket = getBucket(key);// getting index of primary array
        int bucketItem = getBucketItems(key);// getting index of secondary array
        if (storage[bucket] == null)// checking if secondary array is present or not
        {
            if (bucket == 0) {
                storage[bucket] = new boolean[this.bucketItems + 1];// extra size which is bucketItems + 1 is to handle
                                                                    // the largest key (1,000,000)
            } else {
                storage[bucket] = new boolean[this.bucketItems];// As there is no secondary array at the respective
                                                                // primary array index we are creating one
            }
        }
        storage[bucket][bucketItem] = true;// Secondary array is already present so simply inserting data into array.

    }

    public void remove(int key) {
        int bucket = getBucket(key);// getting index of primary array
        int bucketItem = getBucketItems(key);// getting index of secondary array
        if (storage[bucket] == null)// checking if secondary array is present or not
        {
            return;// we dont have to do anything as there is no secondary array present at the
                   // respective index which implies no elements.
        }
        storage[bucket][bucketItem] = false;// removing element at needed index by making it false.
    }

    // method for searching a value in the 2-D array
    public boolean contains(int key) {
        int bucket = getBucket(key);// getting index of primary array
        int bucketItem = getBucketItems(key);// getting index of secondary array
        if (storage[bucket] == null)// checking if secondary array is present or not
        {
            return false;// as value at primary array index is null which mean there is no secondary
                         // array at that index which directly implies there is no data stored at the
                         // particular index, so returning false.
        }
        return storage[bucket][bucketItem];// secondary array is present so returning the element present at needed
                                           // index.
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */