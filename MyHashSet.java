class MyHashSet {

    boolean[][] arr;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        arr = new boolean[buckets][];

    }

    public void add(int key) {
        int hash1 = bucketHash(key);
        int hash2 = bucketItemsHash(key);

        if(arr[hash1] == null)
        {
            if(hash1 == 0)
                arr[hash1] = new boolean[bucketItems+1];
            else
                arr[hash1] = new boolean[bucketItems];

            arr[hash1][hash2] = true;

        }
        else
            arr[hash1][hash2] = true;

    }

    public void remove(int key) {
        int hash1 = bucketHash(key);
        int hash2 = bucketItemsHash(key);
        if(arr[hash1] == null)
            return;

        arr[hash1][hash2] = false;
    }

    public boolean contains(int key) {
        int hash1 = bucketHash(key);
        int hash2 = bucketItemsHash(key);
        if(arr[hash1] == null)
            return false;

        return arr[hash1][hash2];
    }

    private int bucketHash(int key) {
        return key % buckets;
    }

    private int bucketItemsHash(int key) {
        return key / buckets;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */