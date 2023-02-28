// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : load factor etc is one more solution


// Your code here along with comments explaining your approach

class MyHashSet {
	int size = (int)Math.pow(10, 6)+1;
	boolean[] flag;
    public MyHashSet() {
		flag = new boolean[size];
	}
    
    public void add(int key) {
        flag[key]=true;
    }
    
    public void remove(int key) {
        flag[key]=false;
    }
    
    public boolean contains(int key) {
        return flag[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
