public class HashSet {
    public int buckets;
    public int bucketItems;
    public boolean[][] storage;

    public HashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int whichBucket = hash1(key);
        int whichBucketItem = hash2(key);
        if (storage[whichBucket] == null) {
            if (whichBucket == 0) {
                storage[whichBucket] = new boolean[bucketItems + 1];
            } else {
                storage[whichBucket] = new boolean[bucketItems];
            }
        }
        storage[whichBucket][whichBucketItem] = true;
    }

    public void remove(int key) {
        int whichBucket = hash1(key);
        int whichBucketItem = hash2(key);
        if (storage[whichBucket] == null)
            return;
        storage[whichBucket][whichBucketItem] = false;
    }

    public boolean contains(int key) {
        int whichBucket = hash1(key);
        int whichBucketItem = hash2(key);
        if (storage[whichBucket] == null)
            return false;
        return storage[whichBucket][whichBucketItem];
    }

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(5);
        set.add(15);
        set.add(25);
        set.add(35);
        System.out.println(set.contains(10));
        set.add(10);
        set.add(20);
        set.add(30);
        System.out.println(set.contains(10));
        System.out.println(set.contains(5));
        set.remove(5);
        System.out.println(set.contains(5));
        System.out.println(set.contains(1));
    }
}