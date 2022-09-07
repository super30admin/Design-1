// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    static ArrayList a;
    
    public MyHashSet() {
        
        this.a = new ArrayList<>();
        
    }
    
    public void add(int key) {
        if(!a.contains(key))
            a.add(key);
    }
    
    public void remove(int key) {
        if(a.contains(key))
            a.remove(a.indexOf(key));
        
    }
    
    public boolean contains(int key) {
        return a.contains(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */