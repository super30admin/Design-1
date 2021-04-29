// Time Complexity : o(1)
// Space Complexity : o(n)- I have a doubt in this, I remember Sir told in class, 
//that we need to consider the auxillary space only for the space complexity, and not consider the space needed for output,
//so now do i give o(1), by not considering the spcae for data or consider it and give o(n). Please clarify

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashMap {
  

    /** Initialize your data structure here. */
    int[] data;
    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
     
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        data[key]=value;         
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       return data[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        data[key]= -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


/*class MyHashMap {
    int[] data;
    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }
    public void put(int key, int val) {
        data[key] = val;
    }
    public int get(int key) {
        return data[key];
    }
    public void remove(int key) {
        data[key] = -1;
    }
}*/