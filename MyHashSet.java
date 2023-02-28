class MyHashSet {
    private int buckets; //size of the primary array
    private int bucketItems; //size of nested array
    boolean[][] storage;

    public MyHashSet() {
        buckets = 100;
        bucketItems = 100;
        storage = new boolean[buckets][];
    }

    //hash function for primary array
    public int hashFunction1(int key) {
        return key % buckets;
    }

    //hash function for nested array to handle collisions
    public int hashFunction2(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int pIdx = hashFunction1(key);
        int nIdx = hashFunction2(key);
        if (storage[pIdx] == null) {
            if (pIdx == 0) {
                storage[pIdx] = new boolean[bucketItems + 1];
            } else {
                storage[pIdx] = new boolean[bucketItems];
            }
        }
        storage[pIdx][nIdx] = true;
    }

    public void remove(int key) {
        int pIdx = hashFunction1(key);
        int nIdx = hashFunction2(key);
        if (storage[pIdx] == null) return;
        storage[pIdx][nIdx] = false;
    }

    public boolean contains(int key) {
        int pIdx = hashFunction1(key);
        int nIdx = hashFunction2(key);
        if (storage[pIdx] == null) return false;
        return storage[pIdx][nIdx];
    }


    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(9);
        myHashSet.remove(19);
        myHashSet.add(14);
        myHashSet.remove(19);
        myHashSet.remove(9);
//        myHashSet.contains(1);
//        myHashSet.contains(3);
        myHashSet.add(0);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(0);
        myHashSet.remove(9);


    }
}