// Time Complexity : For all operations: O(1)
// Space Complexity : For all operations: O(1) 
// constant space as we declare size = 10^6 + 1.

class MyHashSet {
    boolean[][] hashSet;
    int bucketSize;


    public MyHashSet() {
        bucketSize = 1000;
        hashSet = new boolean[bucketSize][];
    }

    public void add(int key) {
        int bucket = key % bucketSize;
        int bucketItem = key / 1000;

        if (hashSet[bucket] == null) {
            if (bucket == 0) {
                hashSet[bucket] = new boolean[1001];
            } else {
                hashSet[bucket] = new boolean[1000];
            }
        }

        hashSet[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = key % bucketSize;
        int bucketItem = key / 1000;

        if (hashSet[bucket] == null) {
            return;
        }

        hashSet[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = key % bucketSize;
        int bucketItem = key / 1000;

        if (hashSet[bucket] == null) {
            return false;
        }

        return hashSet[bucket][bucketItem];
    }
}