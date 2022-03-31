/**
 * Time complexity of all operations is O(1)
 * Space complexity is O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class HashSetImpl {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public HashSetImpl() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key){
        return key % buckets;
    }

    private int getBucketItem(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
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

    public static void main(String[] args) {
        HashSetImpl obj = new HashSetImpl();
        obj.add(1);
        obj.add(100);
        obj.add(9);
        obj.add(1000);
        obj.remove(9);
        System.out.println(obj.contains(100));
    }
}