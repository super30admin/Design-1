class MyHashSet {

    private static final int HASH_SIZE = 78727;   // Chose a very large prime number
    private static final int BUCKET_SIZE = 70;     // Each bucket size

    private int[][] buckets;
    private int[] bucketCount;

    public MyHashSet() {
        buckets = new int[HASH_SIZE][BUCKET_SIZE];
        bucketCount = new int[HASH_SIZE];
    }

    private int hash(int key) {
        return key % HASH_SIZE;
    }

    public void add(int key) {
        int h = hash(key);

        // check if exists
        for (int i = 0; i < bucketCount[h]; i++) {
            if (buckets[h][i] == key) return;
        }

        // insert if space available
        if (bucketCount[h] < BUCKET_SIZE) {
            buckets[h][bucketCount[h]] = key;
            bucketCount[h]++;
        }
        // if no space space available not inserted but we know 0 <= key <= 10^6
    }

    public void remove(int key) {
        int h = hash(key);

        for (int i = 0; i < bucketCount[h]; i++) {
            if (buckets[h][i] == key) {
                buckets[h][i] = -1;
                bucketCount[h]--;
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (int i = 0; i < bucketCount[h]; i++) {
            if (buckets[h][i] == key) return true;
        }
        return false;
    }
}
