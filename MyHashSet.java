
//Time complexity for add, remove contains is O(1).
// Only 28/33 test cases are passed in the leetcode
class MyHashSet {
    int bucket;
    int bucketItems;
    boolean[][] array ;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.array = new boolean[bucket][];
    }

    private int getBucket(int key){
        return key% bucket;
    }
    private int getBucketItem(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(bucket == 0){
            array[bucket] = new boolean[bucketItems+1];
        }
        else{
            array[bucket] = new boolean[bucketItems];
        }
        array[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(array[bucket] == null){
            return;

        }
        array[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(array[bucket] == null){
            return false;
        }
        return array[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */