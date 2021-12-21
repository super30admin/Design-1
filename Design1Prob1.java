
// Time Complexity : O(1) for put,get,remove
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Filling -1 with whole array causes extra time, so should I fill it or not (because input can also contain 0,so should identify with unfilled loction)


// Your code here along with comments explaining your approach : Took an array as base data structure and used as percentile max size for hashing
class MyHashMap {
    
    int[] myHashMap;

    public MyHashMap() {
        myHashMap = new int[1000000];
        Arrays.fill(myHashMap,-1);
    }
    
    public void put(int key, int value) {
        int index = key%1000000;
        myHashMap[index] = value;
    }
    
    public int get(int key) {
        int index = key%1000000;
        return myHashMap[index];
    }
    
    public void remove(int key) {
        int index = key%1000000;
        myHashMap[index] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */