// Time Complexity : Add = O(n), Remove = O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't know the concept behind it. Learnt in leetcode before coding this


// Your code here along with comments explaining your approach

class MyHashSet {
    ArrayList<Integer> hashset;
    public MyHashSet() {
        hashset = new ArrayList<>();

    }

    public void add(int key) {
        if(!hashset.contains(key)){
            hashset.add(key);
        }
    }

    public void remove(int key) {
        if(hashset.contains(key)) {
            ArrayList<Integer> newHashSet = new ArrayList<>();
            newHashSet.add(key);
            hashset.removeAll(newHashSet);
        }
    }

    public boolean contains(int key) {
        if(hashset.contains(key)) {
            return true;
        }
        return false;
    }
}
