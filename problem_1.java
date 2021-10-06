// Time Complexity
// add - O(1)
// remove - O(1)
// contains - O(1)
// Space Complexity - O(n)
// Ran Successfully on the leetcode

class MyHashSet {
    boolean[] hash= new boolean[1000001];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(hash[key]==false){
            hash[key]=true;
        }
    }
    
    public void remove(int key) {
        hash[key]=false;
    }
    
    public boolean contains(int key) {
        if(hash[key]==true){
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