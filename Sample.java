// Time Complexity : O(n/k)
// Space Complexity : 0(k + m) m is the number of unique values
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {
    private Bucket[] buckets;
    private int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.buckets = new Bucket[this.keyRange];

        for (int i = 0; i < this.keyRange; i++) {
            this.buckets[i] = new Bucket();
        }

    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.buckets[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.buckets[bucketIndex].delete(key);

    }

    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.buckets[bucketIndex].exists(key);

    }
}

class Bucket {
    LinkedList<Integer> container;

    Bucket() {
        container = new LinkedList<>();
    }

    void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }

    }

    void delete(Integer key) {
        this.container.remove(key);
    }

    boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
