public class MyHashSet {
    boolean[] mSet;

    public MyHashSet() {
        mSet = new boolean[1_000_001];
        
    }
    
    public void add(int key) {
        mSet[key] = true;
        
    }
    
    public void remove(int key) {
        mSet[key] = false;
        
    }
    
    public boolean contains(int key) {
        return mSet[key];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

