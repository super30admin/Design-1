// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Not very clear on how to come up with the array size.

class MyHashMap {

    int loc = 0;
    int[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[100000];
        //initialize with -1s
        Arrays.fill(arr,-1);
    }

    private int hashfunc(int key){
        return (key%100000);
    }

    public void put(int key, int value) {
        loc = hashfunc(key);
        arr[loc] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        loc = hashfunc(key);
        return arr[loc];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        loc = hashfunc(key);
        arr[loc] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */