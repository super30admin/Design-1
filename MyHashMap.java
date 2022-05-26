//Time Complexity

// put: on average case it is O(1)
// get: on average case it is O(1)
// remove: on average case it is O(1)

// Space Complexity : O(n)

// Did this code successfully run on Leetcode : Yes

class MyHashMap {
    private Integer[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new Integer[buckets][];
    }

    private int hash1(int key){
        return key % buckets;
    }

    private int hash2(int key){
        return key / bucketItems;
    }

    public void put(int key, int value) {
        int bucketIndex = hash1(key);
        int bucketItemIndex = hash2(key);
        if(storage[bucketIndex] == null){
            if(bucketIndex == 0)
                storage[bucketIndex] = new Integer[bucketItems + 1];
            else
                storage[bucketIndex] = new Integer[bucketItems];
        }
        storage[bucketIndex][bucketItemIndex] = value;
    }

    public int get(int key) {
        int bucketIndex = hash1(key);
        int bucketItemIndex = hash2(key);
        if(storage[bucketIndex] == null)
            return -1;
        else
        if(storage[bucketIndex][bucketItemIndex] == null) return -1;
        return storage[bucketIndex][bucketItemIndex];
    }

    public void remove(int key) {
        int bucketIndex = hash1(key);
        int bucketItemIndex = hash2(key);
        if(storage[bucketIndex] == null)
            return;
        else
            storage[bucketIndex][bucketItemIndex] = null;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();



        hashMap.put(1, 2);



        hashMap.put(2, 3);



        hashMap.get(1);            // returns 2



        hashMap.get(3);            // returns -1 (not found)



        hashMap.put(2, 4);          // update the existing value



        hashMap.get(2);            // returns 4



        hashMap.remove(2);          // remove the mapping for 2



        hashMap.get(2);            // returns -1 (not found)
    }
}