/**
 * Time Complexity: O(1) for all add(), remove() & contains() functions
 * Space Complexity: O(n) in worst case
 */

class MyHashSet {

    boolean[][] set;
    int size;

    public MyHashSet() {
        this.size = 1000;
        this.set = new boolean[size][];
    }

    private int hashFunction1(int key) {
        return key % this.size;
    }

    private int hashFunction2(int key) {
        return key / this.size;
    }
    
    public void add(int key) {
        int hf1 = hashFunction1(key);
        int hf2 = hashFunction2(key);
        if(set[hf1] == null) {
            if(hf1 == 0) {
                set[hf1] = new boolean[size + 1];
            } else {
                set[hf1] = new boolean[size];
            }
        }
        set[hf1][hf2] = true;
    }
    
    public void remove(int key) {
        int hf1 = hashFunction1(key);
        int hf2 = hashFunction2(key);
        if(set[hf1] == null) return;
        set[hf1][hf2] = false;
    }
    
    public boolean contains(int key) {
        int hf1 = hashFunction1(key);
        int hf2 = hashFunction2(key);
        if(set[hf1] == null) return false;
        return set[hf1][hf2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */