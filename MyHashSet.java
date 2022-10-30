class MyHashSet {
    boolean[][] storage;
    int buckets, bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int pos1 = key % 1000;
        int pos2 = key / 1000;
        if (storage[pos1] == null) {
            if (pos1 == 0) {// this is to handle the case when key=100000m in that case we have to insert a
                            // value at 1000th position and that will only go at oth place in amin array.
                storage[pos1] = new boolean[bucketItems + 1];
                storage[pos1][pos2] = true;
            } else {
                storage[pos1] = new boolean[bucketItems];
                storage[pos1][pos2] = true;
            }
        } else {
            storage[pos1][pos2] = true;
        }
    }

    public void remove(int key) {
        int pos1 = key % 1000;
        int pos2 = key / 1000;
        if (storage[pos1] != null && storage[pos1][pos2]) {
            storage[pos1][pos2] = false;
        } else {
            return;
        }
    }

    public boolean contains(int key) {
        int pos1 = key % 1000;
        int pos2 = key / 1000;
        if (storage[pos1] != null && storage[pos1][pos2]) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */