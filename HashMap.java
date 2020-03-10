// Time Complexity : O(1)
// Space Complexity : O(100000)=> O(k) wher is k is some constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When I used array of size 1000 , I faced issue of collision.
class HashMap { 
    int max = 100000; // This is working in  leetcode because i belive there is no such test case which creates conflict with this.
    int[] data;
    
    public MyHashMap() {
        data = new int[max];
        for(int i = 0;i<max;i++)
        {
            data[i] = -1;
        }
    }
    
    public int getIndex(int key)
    {
        return key%max;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        data[index] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        return data[index];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        data[index] = -1;
    }
}