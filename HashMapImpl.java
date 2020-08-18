// Time Complexity : O(n)
// Space Complexity : O(1) (constant size array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing specific


public class HashMapImpl {
    static class MyHashMap {

    /** Initialize your data structure here. */
    int[] map=new int[1000001];                //initialized array ds with the limit given in the problem
    public MyHashMap() {
        for (int i=0;i<map.length;i++){        //assigned all the values as -1 , the value to be returned if the key doesnt exist
            map[i]= -1;
        }  
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key]=value;                        //implementing put method by assigning the value to the key index in array
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];                       //implemented get method by returning the value at the index(key) of the array
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key]=-1;                          // making the value back to -1 as per requirement to remove
    }
}

public static void main(String[] args) {
    MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 2);          
hashMap.put(2, 3);         
System.out.println(hashMap.get(1));            // returns 2
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 4);          // update the existing value
hashMap.get(2);            // returns 4 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)
}
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */