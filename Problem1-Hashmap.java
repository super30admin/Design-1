// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Took me some time to undertand and implement 

class MyHashMap {
    
    int [] A = new int[1000001];
    public MyHashMap() {
        for(int i = 0;i<1000001;i++){
            A[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        A[key]=value;
    }
    
    public int get(int key) {
        return A[key];
    }
    
    public void remove(int key) {
        A[key] = -1;
    }
}

