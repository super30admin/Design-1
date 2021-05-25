// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach
class MyHashMap {

    ArrayList<int[]> hm;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hm = new ArrayList<int[]>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	int[] keyvalue = {key, value};
        int conditionsatisfy = 0;
        if(hm!=null && hm.size()!=0) {
        	for(int i = 0; i < hm.size(); i++) {
        		if(hm.get(i)[0] == key) {
        			hm.get(i)[1] = keyvalue[1];
                    conditionsatisfy = 1;
        		}
        	}
            if(conditionsatisfy == 0) {
                hm.add(keyvalue);
            }
        }
        else
            hm.add(keyvalue);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(hm!=null & hm.size()!=0) {
        	for(int i = 0; i < hm.size(); i++) {
        		if(hm.get(i)[0] == key) {
        			return hm.get(i)[1];
        		}
        	}
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	if(hm!=null) {
        	for(int i = 0; i < hm.size(); i++) {
        		if(hm.get(i)[0] == key) {
        			hm.remove(i);
        		}
        	}
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */