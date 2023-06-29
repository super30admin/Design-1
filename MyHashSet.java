// Time Complexity : O(1) for all user ooeartions.
// Space Complexity : O(1) for all user ooeartions.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashSet {
    boolean[][] buckets;
    boolean[] bucketItems;
    int size = 1000;

    public MyHashSet() {
        this.buckets = new boolean[this.size][];
    }

    private int hash(int key, boolean isBucketHash){
        if(isBucketHash){
            return key % this.size;
        }

        return key / this.size;
    }
    
    public void add(int key) {
        int bucketHash = hash(key, true);
        int bucketItemHash = hash(key, false);

        if(buckets[bucketHash] == null){
            if(bucketHash == 0){
                buckets[bucketHash] = new boolean[this.size+1];
            }else{
                buckets[bucketHash] = new boolean[this.size];
            }
        }

        buckets[bucketHash][bucketItemHash] = true;
    }
    
    public void remove(int key) {
        int bucketHash = hash(key, true);
        int bucketItemHash = hash(key, false);

        if(buckets[bucketHash] == null){
            return;
        }

        buckets[bucketHash][bucketItemHash] = false;;
    }
    
    public boolean contains(int key) {
        int bucketHash = hash(key, true);
        int bucketItemHash = hash(key, false);

        if(buckets[bucketHash] == null){
            return false;
        }

        return buckets[bucketHash][bucketItemHash];
    }
}