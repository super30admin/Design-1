// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on LeetCode: yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class MyHashSet {

    private static final int SIZE = 420;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for( int i = 0; i<SIZE; i++){
            buckets[i] = new LinkedList<Integer>();
        }
    }
    
    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        LinkedList<Integer> bucket = buckets[hash(key)];
        if(!bucket.contains(key)) bucket.add(key);
    }
    
    public void remove(int key) {
        buckets[hash(key)].remove((Integer)key);

        
    }
    
    public boolean contains(int key) {
                return buckets[hash(key)].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
