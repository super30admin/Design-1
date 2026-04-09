// Time Complexity : O(1)
// Space Complexity : O(1) -> O(1000001)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initialized the boolean set with only 100 as the limit


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */