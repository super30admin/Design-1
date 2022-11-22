// Time Complexity : Add = O(n), Remove = O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't know the concept behind it. Learnt in leetcode before coding this


// Your code here along with comments explaining your approach

class MyHashSet {
    //creating an array list as base data structure to work as hashset
    ArrayList<Integer> hashset;
    public MyHashSet() {
        //intialize in constructor
        hashset = new ArrayList<>();
    }

    public void add(int key) {
        //if key is not availabe in the arraylist, adding the key to it (key is the actual value here)
        if(!hashset.contains(key)){
            hashset.add(key);
        }
    }

    public void remove(int key) {
        //if key is available in the arraylist, removing it by adding it to new arraylist (it will copy all elements to new array list, so removed tge old one)
        if(hashset.contains(key)) {
            ArrayList<Integer> newHashSet = new ArrayList<>();
            newHashSet.add(key);
            hashset.removeAll(newHashSet);
        }
    }

    public boolean contains(int key) {
        //return true if arraylist has the key
        if(hashset.contains(key)) {
            return true;
        }
        return false;
    }
}
