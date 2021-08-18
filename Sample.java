// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah faced problem calculating Time n Space complexity. looking for more efficient approach.


// Your code here along with comments explaining your approach

class MyHashMap {
ArrayList<HashDS> arr ;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
     
        for(HashDS h : arr)
        {
            if(h.key == key)
            {
                arr.remove(h);
                break;
            }
        }
        
        HashDS hs = new HashDS(key,value);
        arr.add(hs);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int val = -1;
        
        for(HashDS h : arr)
           {
                if(h.key == key)
                {
                    return h.value;
                }
           } 
      
       return val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         for(HashDS h : arr)
        {
            if(h.key == key)
            {
                arr.remove(h);
                break;
            }
        }
    }
}

class HashDS {
    int key;
    int value;
    public HashDS(int key, int value){
        this.key = key;
        this.value = value;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
