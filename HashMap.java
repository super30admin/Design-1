// Time Complexity :  For contains add and remove all will have O(k/n) where n -> number of elements in the main list and k -> number of collided elements . This is because every function calls contains internally
// another way is to think that if all the keys of the main list were required, we would take O(k) but since we have collisions so we will not take upall of them and hence O(k/n)

// Space Complexity : O(m+k) where m is the number of unique keys that are used and k is the number of collisions that occur
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// class for storing keys and values 
class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// bucket class which will store the list of all the elements which have the
// same hashed key value
class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    // initialisation phase
    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    // for the hashed key we check all the pairs and return which matches with the
    // key
    public Integer get(Integer key) {
        for (Pair<Integer, Integer> p : this.bucket) {
            if (p.key.equals(key))
                return p.value;
        }
        return -1;
    }

    // a boolean which keeps track of found or not and checks each and every pair in
    // bucket to see if the key is already present
    // if the key is already present, then it updates the value else it creates a
    // new pair and adds it to the bucket

    public void update(Integer key, Integer val) {
        boolean found = false;
        for (Pair<Integer, Integer> p : this.bucket) {
            if (p.key.equals(key)) {
                p.value = val;
                found = true;
                break;
            }
        }
        if (found == false) {
            this.bucket.add(new Pair(key, val));
        }
    }

    // finds all the pair in a bucket and removes the one which has the target key.
    public void remove(Integer key) {
        for (Pair<Integer, Integer> p : this.bucket) {
            if (p.key.equals(key)) {
                this.bucket.remove(p);
                break;
            }

        }
    }
}

class MyHashMap {

    private int k;
    private List<Bucket> bucket_list;

    /** Initialize your data structure here. */
    public MyHashMap() {
        // initialise the list of bucket as well as the start of each bucket and prime
        // number k
        this.k = 2003;
        this.bucket_list = new ArrayList<Bucket>();
        for (int i = 0; i < this.k; i++) {
            this.bucket_list.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // creates a hashed key and searches the corresponding bucket and updates the
        // pair having the target key
        int hash = key % this.k;
        this.bucket_list.get(hash).update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        // creates a hashed key and searches the corresponding bucket and gets the value
        // of the pair in the bucket
        int hash = key % this.k;
        return this.bucket_list.get(hash).get(key);

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        // creates a hashed key and searches the corresponding bucket and removes the
        // pair in the bucket
        int hash = key % this.k;
        this.bucket_list.get(hash).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */