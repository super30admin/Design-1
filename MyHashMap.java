// Time Complexity : O(1)
// Space Complexity : O(buckets+bucketItems)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    int[][] storage;
    int buckets;
    int bucketItems;

    /** Bucket and bucketItems is used for hashing algorithm.*/
    public MyHashMap() {
        this.storage=new int[1001][];
        this.buckets=1000;
        this.bucketItems=1000;
    }

    public int bucket(int key){
        return key%buckets;
    }

    public int bucketItems(int key){
        return key/bucketItems;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket=bucket(key);
        int bucketItem=bucketItems(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]=new int[bucketItems+1];
            }else{
                storage[bucket]=new int[bucketItems];
            }
            Arrays.setAll(storage[bucket], i -> -1);
        }
        storage[bucket][bucketItem]=value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItems(key);
        if(storage[bucket]!=null){
            return storage[bucket][bucketItem];
        }else{
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItems(key);
        if(storage[bucket]!=null){
            storage[bucket][bucketItem]=-1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */