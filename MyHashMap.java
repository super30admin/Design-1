// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : figured the solution using arrays, but not quite efficient and 
// i spent a long time to get a solution, had to review through full online materials to acheive the logic.


// Your code here along with comments explaining your approach

class MyHashMap {

    public int size = 769;
    public LinkedList<ListData>[] list;

    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new LinkedList[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % size;
        if (list[hashKey] == null) 
        {
            list[hashKey] = new LinkedList<ListData>();
            list[hashKey].add(new ListData(key, value));
        } 
        else 
        {
            for (ListData l : list[hashKey]) {
                if (l.key == key) 
                {
                    l.value = value;
                    return;
                }
            }
            list[hashKey].add(new ListData(key, value));
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int hashKey = key % size;
        LinkedList<ListData> list1 = list[hashKey];
        if (list1 == null)
            return -1;
        for (ListData l : list1) 
        {
            if (l.key == key) 
            {
                return l.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int hashKey = key % size;
        ListData toremove = null;
        if (list[hashKey] == null)
            return;
        else {
            for (ListData l : list[hashKey]) 
            {
                if (l.key == key) 
                {
                    toremove = l;
                }
            }
            if (toremove == null)
                return;
        }
        list[hashKey].remove(toremove);
    }
}

class ListData {
    public int key;
    public int value;
    public ListData(int key, int value) {
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
    
