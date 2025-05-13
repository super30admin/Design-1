/*
 * Uses an array of lists (buckets) to store keys with chaining for collision handling.
 * 1. buckets: an array of ArrayLists, each holding integers that hash to the same index.
 * 2. PRIME: a prime number used for modulo to distribute keys evenly.

 * - hash(key): computes index using a simple hash function.
 * - add: places key in its bucket if not already present.
 * - remove: deletes key from its bucket if it exists.
 * - contains: checks if key exists in its computed bucket.
 */

/*
* Another approach I thought was to take an boolean array[1001][1001] that can easily accomodate the input range till 10^6
* and mark true for the [key/1001][key%1001] which will eventually be unique for every unique key
But this approach is not properly hashing but it is open addressing
*/

// Time Complexity : O(1) average, O(n) worst-case (if all keys hash to the same bucket) for all functions
// Space Complexity : O(n), where n is the number of keys stored.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No (Explored multiple ways)

class MyHashSet {

    int PRIME = 2011;
    List<Integer>[] buckets;
    int hash(int key) {
        return (31 * key + 17) % PRIME;
    }
    public MyHashSet() {
        buckets = new List[PRIME];
    }
    
    public void add(int key) {
        int hsh = hash(key);
        if(buckets[hsh] == null)
            buckets[hsh] = new LinkedList<>();
        if(!buckets[hsh].contains(key))
            buckets[hsh].add(key);

    }
    
    public void remove(int key) {
        int hsh = hash(key);
        if(contains(key))
            buckets[hsh].remove((Integer) key);        
    }
    
    public boolean contains(int key) {
        int hsh = hash(key);
        if(!(buckets[hsh] == null)){
            if(buckets[hsh].contains(key))
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
