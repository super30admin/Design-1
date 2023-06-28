// Time Complexity :o(1)
// Space Complexity :o(n) no of unique element inserted
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//1. create List of integer
//2. add(k) add value into the list if it does not present in list
//3. remove(k) value from list
//4. use contains() list method to check if element present or not.

class MyHashSet {
    List<Integer> l;
    public MyHashSet() {
        l = new ArrayList<Integer>();

    }

    public void add(int key) {
        if(!l.contains(key)){
            l.add(key);
        }
    }

    public void remove(int key) {
        Integer k = key;
        l.remove(k);
    }

    public boolean contains(int key) {
        return l.contains(key);
    }
}
