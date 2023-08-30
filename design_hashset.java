// Time Complexity : O(1)
// Space Complexity : O(1_000_000 + 1) or O(1)

        
class MyHashSet {
    int MAX_SIZE = 1_000_000 + 1;
    boolean[] hashSetArray ;
    public MyHashSet() {
        hashSetArray = new boolean[MAX_SIZE];
    }
    
    public void add(int key) {
        hashSetArray[key] = true;
    }
    
    public void remove(int key) {
        if(contains(key)){
          hashSetArray[key] = false;  
        }
    }
    
    public boolean contains(int key) {
        return hashSetArray[key];
    }
}

/**
 * MyHashSet obj = new MyHashSet();
 * Your MyHashSet object will be instantiated and called as such:
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */