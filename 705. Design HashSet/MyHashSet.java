class MyHashSet {

    int primaryBucket;
    int secondaryBucket;
    boolean[][] storage;

    public MyHashSet() {

        this.primaryBucket = 1000;
        this.secondaryBucket = 1000;
        this.storage = new boolean[primaryBucket][];

    }

    public int primaryKey(int key) {

        return key % primaryBucket;

    }

    public int secondaryKey(int key) {

        return key / secondaryBucket;

    }

    public void add(int key) {

        int primaryIndex = primaryKey(key);

        if (storage[primaryIndex] == null) {

            if (primaryIndex == 0) {
                storage[primaryIndex] = new boolean[secondaryBucket + 1];
            } else {
                storage[primaryIndex] = new boolean[secondaryBucket];
            }

        }

        int secondaryIndex = secondaryKey(key);
        storage[primaryIndex][secondaryIndex] = true;

    }

    public void remove(int key) {

        int primaryIndex = primaryKey(key);

        if(storage[primaryIndex] == null){

            return;
        }

        int secondaryIndex = secondaryKey(key); 
        storage[primaryIndex][secondaryIndex] = false;

    }

    public boolean contains(int key) {

        int primaryIndex = primaryKey(key);

        if (storage[primaryIndex] == null) {

            return false;
        }
        int secondaryIndex = secondaryKey(key);

        return storage[primaryIndex][secondaryIndex];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */