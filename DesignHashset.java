// - The row index (outer index) represents `key / 1000` (hash bucket).
// - The column index (inner index) represents `key % 1000` (position within the bucket).
// - This ensures efficient storage and lookup while reducing space usage.
// Time complexities:
// - add: O(1)
// - remove: O(1)
// - contains: O(1)

class MyHashSet {
    int[][] hashset;
    public MyHashSet() {
        hashset = new int[1001][];
    }
    
    public void add(int key) {
        int outerKey = key/1000;
        int innerKey = key%1000;
        if(hashset[outerKey] == null){
            hashset[outerKey] = new int[1000];
            Arrays.fill(hashset[outerKey], -1);
        }
        hashset[outerKey][innerKey] = key;
    }
    
    public void remove(int key) {
        int outerKey = key/1000;
        int innerKey = key%1000;
        if(hashset[outerKey] != null){
            hashset[outerKey][innerKey] = -1;
        }
    }
    
    public boolean contains(int key) {
         int outerKey = key/1000;
        int innerKey = key%1000;
        if(hashset[outerKey] == null){
            return false;
        }

        if(hashset[outerKey][innerKey] == key){
            return true;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */