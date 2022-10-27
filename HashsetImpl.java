//time complexity - O(1)
//space complexity - O(N), N is Math.pow(10, 6)+1
//able to execute in leetcode
class MyHashSet {
    int size = (int)Math.pow(10, 6)+1;
    boolean[] hs = new boolean[size];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        hs[key] = true;
    }
    
    public void remove(int key) {
        hs[key]=false;
    }
    
    public boolean contains(int key) {
        return hs[key];
    }
}
