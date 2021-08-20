// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the hashmap structure.


class MyHashMap {

    ListNode[] nodes = new ListNode[1000000];
    public static class ListNode {
        int key;
        int value;

        ListNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int getIndex (Integer key) {
        return key.hashCode() % 1000000;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        // If the node DNE, it will be added into LL
        if (nodes[index] == null) {
            ListNode node = new ListNode(key, value);
            nodes[index] = node;
        }
        else {
            nodes[index] = new ListNode(key, value);
        }

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) return -1;

        return nodes[index].value;

    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        nodes[index] = null;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */