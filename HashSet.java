// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
public class HashSet {
    class MyHashSet {
        private boolean storage[][];
        private int buckets;
        private int bucketItems;

        private int hash1(int key){
            return key%1000;
        }

        private int hash2(int key){
            return key/1000;
        }

        public MyHashSet() {
            this.buckets = 1000;
            this.bucketItems = 1000;
            this.storage = new boolean[1000][];
        }

        public void add(int key) {
            int bucket = hash1(key);
            if(storage[bucket] == null){
                if(bucket == 0){
                    storage[bucket] = new boolean[bucketItems+1];
                }
                else{
                    storage[bucket] = new boolean[bucketItems];
                }
            }

            int bucketItem = hash2(key);
            storage[bucket][bucketItem] = true;
        }

        public void remove(int key) {
            int bucket = hash1(key);
            if(storage[bucket] == null)
                return;
            int bucketItem = hash2(key);
            storage[bucket][bucketItem] = false;
        }

        public boolean contains(int key) {
            int bucket = hash1(key);
            if(storage[bucket] == null){
                return false;
            }
            else{
                int bucketItem = hash2(key);
                return storage[bucket][bucketItem];
            }
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
