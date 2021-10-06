class MyHashSet {
    
    boolean [] array = new boolean[1000001];
    
    public MyHashSet() {
      
    }
    
    public void add(int key) {
        if(!array[key]){
            array[key] = true;
        }
    }
    
    public void remove(int key) {
        if(array[key] == true){
            array[key] = false;
        }
    }
    
    public boolean contains(int key) {
        if(array[key] == true){
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//  Space Complexity: O(n)
// Time complexity: Add, Remove contains all are O(1)