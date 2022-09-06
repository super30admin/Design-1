// Time Complexity : O(n) Because TC of ArrayList contains method is O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    // I thought of using arraylist to solve this problem. So I declared ArrayList globally
    List<Integer> hs;

    public MyHashSet() {
        hs = new ArrayList<>();
    }

    public void add(int key) {
        // While adding I am just checking if key is already present. If not then adding in List(to avoid duplicate and implement HastSet)
        if(!hs.contains(key))
            hs.add(key);
    }

    public void remove(int key) {
        // If key is present then just removing it from List
        if(hs.contains(key))
            hs.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        return (hs.contains(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */