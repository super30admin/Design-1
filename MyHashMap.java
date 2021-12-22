// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// It runs successfully for the sample test case, but when I go on to submit it, it fails for one very large test case.
// Could you please help me understand where I am going wrong.

class MyHashMap {

    private int[][] map;
    private int buckets;
    private int bucketItems;

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        map = new int[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (map[bucket] == null) {
            if (bucket == 0)
                map[bucket] = new int[bucketItems + 1];
            else
                map[bucket] = new int[bucketItems];
        }

        map[bucket][bucketItem] = value;
    }

    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (map[bucket] == null)
            return -1;

        return map[bucket][bucketItem];
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (map[bucket] != null)
            map[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */