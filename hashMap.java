// Time Complexity : O(1) for all operations
// Space Complexity : O(N) in worst case. Where N = 10^6.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/526188321/
// Any problem you faced while coding this : No issues


class MyHashMap {

        private int totalPositionsInBuckets;
        private int totalBuckets;
        private Integer[][] hashMap;

        /** Initialize your data structure here. */
        public MyHashMap() {
            totalBuckets = totalPositionsInBuckets = 1000;
            hashMap = new Integer[totalBuckets][];
        }

        //This method helps in finding the bucket no for a particular key
        private int findBucket(int key) {
            return key%totalBuckets;
        }

        //this method helps find the position in a particular bucket
        private int findPositionInBucket(int key) {
            return key/totalPositionsInBuckets;
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int bucket = findBucket(key);
            int positionInBucket = findPositionInBucket(key);

            if(null == hashMap[bucket]){
                if (0 == bucket) {
                    hashMap[bucket] = new Integer[totalPositionsInBuckets+1];
                } else {
                    hashMap[bucket] = new Integer[totalPositionsInBuckets];
                }
            }
            hashMap[bucket][positionInBucket] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int bucketIndex = findBucket(key);
            int positionInBucket = findPositionInBucket(key);

            if (null == hashMap[bucketIndex] || null == hashMap[bucketIndex][positionInBucket] ) {
                return -1;
            }

            return hashMap[bucketIndex][positionInBucket];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int bucketIndex = findBucket(key);
            int positionInBucket = findPositionInBucket(key);
            
            if (null == hashMap[bucketIndex] || null == hashMap[bucketIndex][positionInBucket] ) {
                return;
            }

            //Just setting it the value here to -1. Value will only be positive
            // so putting -1 here is a hack like saying nothing is present here.
            hashMap[bucketIndex][positionInBucket] = -1;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
