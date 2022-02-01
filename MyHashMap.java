// Time Complexity : o(1) for put, get and remove. Object creation takes O(n) time
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
//Create array of the size of range.
//Key will act as index, and value as the one stored at that index of array
//implement put, get, remove


class MyHashMap {
    int [] valueArray;
    public MyHashMap() {
        valueArray = new int[1000001];
        Arrays.fill(valueArray,-1);
    }
    
    public void put(int key, int value) {
        valueArray[key] = value;
    }
    
    public int get(int key) {
        return valueArray[key];
    }
    
    public void remove(int key) {
        valueArray[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */