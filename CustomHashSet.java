// Time Complexity
// add() : O(1)
// remove() : O(1)
// contains() : O(1)

// Space Complexity
// add() : O(1)
// remove() : O(1)
// contains() : O(1)


// Constraints:
// 0 <= key <= 10^6
// At most 104 calls will be made to add, remove, and contains.

// Double Hashing
// Hash1 = Modulus
// Hash2 = Division

public class CustomHashSet {
    class MyHashSet {

        private boolean[][] hashSet;

        private int size;

        public MyHashSet() {
            this.size = (int) Math.sqrt(Math.pow(10, 6));
            this.hashSet = new boolean[size][];
        }

        public void add(int key) {
            int currentBucket = getCurrentBucket(key);
            int positionInBucket = getPositionInBucket(key);
            if (hashSet[currentBucket] == null) {
                // size = 1000
                // currentbucket = 1000000%1000 = 0
                // positionInBucket = 1000000/1000 = 1000
                // bucket[] = [0, 999]
                // positionInBucket = [0, 999]
                if (currentBucket == 0) {
                    hashSet[currentBucket] = new boolean[this.size + 1];
                } else {
                    hashSet[currentBucket] = new boolean[this.size];
                }
            }
            hashSet[currentBucket][positionInBucket] = true;
        }

        public void remove(int key) {
            int currentBucket = getCurrentBucket(key);
            int positionInBucket = getPositionInBucket(key);
            if (hashSet[currentBucket] == null) {
                return;
            }
            hashSet[currentBucket][positionInBucket] = false;
        }

        public boolean contains(int key) {
            int currentBucket = getCurrentBucket(key);
            int positionInBucket = getPositionInBucket(key);
            if (hashSet[currentBucket] == null) {
                return false;
            }
            return hashSet[currentBucket][positionInBucket];
        }

        // Hash 1
        private int getCurrentBucket(int key) {
            return key % this.size;
        }

        // Hash 2
        private int getPositionInBucket(int key) {
            return key / this.size;
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
