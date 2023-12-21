class MyHashSet {
    private boolean[][] storage;
    int bucket;
    int bucketItem;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.storage = new boolean[bucket][];
    }

    public void add(int key) {
        int arrayIndex = key%this.bucket;
        int subarrayIndex = key/this.bucketItem;
        System.out.println(storage[arrayIndex]);
        if(storage[arrayIndex] == null) {
            if(arrayIndex == 0) {
                storage[arrayIndex] = new boolean[subarrayIndex + 1];
            } else {
                storage[arrayIndex] = new boolean[subarrayIndex];
            }
        }
        storage[arrayIndex][subarrayIndex] = true;
    }

    public void remove(int key) {
        int arrayIndex = key%this.bucket;
        int subarrayIndex = key/this.bucketItem;
        if(storage[arrayIndex] == null) return;
        storage[arrayIndex][subarrayIndex] = false;
    }

    public boolean contains(int key) {
        int arrayIndex = key%this.bucket;
        int subarrayIndex = key/this.bucketItem;
        if(storage[arrayIndex] == null) return false;
        return storage[arrayIndex][subarrayIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */