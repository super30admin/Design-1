// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * I leveraged the double hashing technique for collision handling mentioned by Professor in the lecture
 * Created an 2D integer array
 * Created two hash functions
 * As disucussed, there will be no nested collisions using this approach
 * **/
class MyHashMap {

    /** Initialize your data structure here. */
    /**
     HashMap is an array of Linked Lists
     We can implement it using different strategies
     Linear chaining - LinkedList
     Linear probing
     BST
     Double Hashing
     Main Advantage of HashMap - Fast access to a value which is associated with a key
     Main issues:
     hash Function design
     Collision Handling
     **/
    //Using Double Hashing
    private int[][] map;
    private int outersize;
    private int innersize;
    public MyHashMap() {
        this.outersize = 1000;
        this.innersize = 1001;
        map = new int[outersize][];
    }

    //Hash Function one
    public int hashOne(int key)
    {
        return key%outersize;
    }

    //Hash Function two
    public int hashTwo(int key)
    {
        return key/innersize;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index1 = hashOne(key);
        int index2 = hashTwo(key);
        if(map[index1]==null)
            map[index1]=new int[innersize];
        map[index1][index2] = value+1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index1 = hashOne(key);
        int index2 = hashTwo(key);
        return map[index1]!=null&&map[index1][index2]!=-1 ? map[index1][index2]-1 : -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index1 = hashOne(key);
        int index2 = hashTwo(key);
        if(map[index1]!=null)
            map[index1][index2] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */