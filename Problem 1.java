// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000000];
        Arrays.fill(map, -1);
    }
    //assigning value to key in put operation
    public void put(int key, int value) {
        map[key] = value;
    }
    
   //if the key is out of range returning removing by using -1 otherwise giving th value of key
    public int get(int key) {
        if (key < 0 || key > 1000000 || map[key] == -1) {
            return -1;
        } else {
            return map[key];
        }
    }
    //removing using -1
    public void remove(int key) {
        map[key] = -1;
    }
}
