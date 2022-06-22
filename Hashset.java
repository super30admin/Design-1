// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : just had to be careful for bucket 0

class MyHashSet {
    boolean[][] hash_set;
    int buckets; // primary array.
    int bucket_items; // secondary array.

    public MyHashSet() {
        buckets = 1000;
        bucket_items = 1000;
        hash_set = new boolean[buckets][];
    }

    private int get_bucket(int key) {
        return key % buckets;
    }

    private int get_bucket_items(int key) {
        return key / bucket_items;
    }

    public void add(int key) {
        int bucket = get_bucket(key);
        int bucket_item = get_bucket_items(key);
        if (hash_set[bucket] == null) { // if there is no secondary array at "bucket" position create a new one based on
                                        // if bucket==0 or not.
            if (bucket == 0) {
                hash_set[bucket] = new boolean[bucket_items + 1];
            } else {
                hash_set[bucket] = new boolean[bucket_items];
            }

        }
        hash_set[bucket][bucket_item] = true;

    }

    public void remove(int key) {
        int bucket = get_bucket(key);
        int bucket_item = get_bucket_items(key);
        if (hash_set[bucket] == null) { // secondary array itself doesnt exsist at "bucket".
            return;
        }
        hash_set[bucket][bucket_item] = false;

    }

    public boolean contains(int key) {
        int bucket = get_bucket(key);
        int bucket_item = get_bucket_items(key);
        if (hash_set[bucket] == null) { // secondary array itself doesnt exsist at "bucket" therefore key doesnt exist.
            return false;
        }
        return hash_set[bucket][bucket_item];

    }

    public static void main(String args[]) {
        MyHashSet obj = new MyHashSet();
        obj.add(2);
        obj.add(3);
        obj.remove(3);
        obj.contains(2);
        obj.contains(3);

    }
}
