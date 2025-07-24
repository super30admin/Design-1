public class MyHashSet {
    private boolean[][] items;
    private int primaryBucket;
    private int secondaryBucket;


    public MyHashSet() {
        this.primaryBucket = 1000;
        this.secondaryBucket = 1001;
        this.items = new boolean[primaryBucket][];
    }

    public void add(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if (items[index] == null) {
            boolean[] bucket = new boolean[secondaryBucket];
            items[index] = bucket;
            bucket[index2] = true;
        } else {
            boolean[] bucket = items[index];
            if (!bucket[index2]) bucket[index2] = true;
        }
    }

    public void remove(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        var list = items[index];
        if (list == null) return;
        list[index2] = false;
    }

    public boolean contains(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        var list = items[index];
        if (list == null) return false;
        return list[index2];
    }

    private int hash1(int key) {
        return key % primaryBucket;
    }

    private int hash2(int key) {
        return key / secondaryBucket;
    }
}