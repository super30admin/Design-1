//Time Complexity: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Have issues with remove method 
// causing index out of bound issue, I noticed that .remove() removes elements based on index input
// So I changed it to Integer.valueOf(key) to remove the key.
// Your code here along with comments explaining your approach
class MyHashSet {
    public ArrayList<Integer> myset; //Used for unlimited elements, instead of using arrays
    public MyHashSet() {
        myset=new ArrayList<Integer>(); //initialize myset for new object.
    }
    
    public void add(int key) {
        if(!myset.contains(key)){ //if myset does not contain key then add otherwise do not accept keys that are the same.
            myset.add(key);
        }
    }
    
    public void remove(int key) {
        if(myset.contains(key)){ //if key is in myset remove it otherwise there is nothing to remove.
            myset.remove(Integer.valueOf(key)); //remove key in myset.
        }
    }
    
    public boolean contains(int key) {
        return myset.contains(key); //returns true if myset contains key otherwise
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
