import java.util.*;

class HashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public HashSet() {
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket= getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]= new boolean[bucketItems+1];
            }
            else
            {
                storage[bucket]= new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
    }

    public void remove(int key) {
        int bucket= getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
    }

    public boolean contains(int key) {
        int bucket= getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem];

    }

    public static void main(String[] args) {
        HashSet obj = new HashSet();
        obj.add(4);
        System.out.println(obj.contains(4));//ans = true
        obj.add(5);
        System.out.println(obj.contains(5));//ans = true
        obj.remove(5);
        System.out.println(obj.contains(5));//ans = false

    }
}