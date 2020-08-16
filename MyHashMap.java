// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : yes
class MyHashMap {
    class Listnodes {
        int key, val;
        Listnodes next;

        Listnodes(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Listnodes[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Listnodes[10000];
    }
    int idx(int key) { 
        return Integer.hashCode(key) % nodes.length;
    }

    Listnodes findElement(int key, int index)
    {
        if (nodes[index]==null)
            return nodes[index] = new Listnodes(-1,-1);
        //Get the previous node.
        Listnodes prev = nodes[index];
        while (prev.next != null && prev.next.key != key)
        {
            prev = prev.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = idx(key);
        //System.out.println(index);
        Listnodes prev = findElement(key, index);
        //If the node doesn't exist, create a new one. If it exists, update the value.
        if (prev.next == null)
            prev.next = new Listnodes(key,value);
        else 
            prev.next.val = value;
        
    }
    
    public int get(int key) {
        int index = idx(key);
        Listnodes prev = findElement(key, index);
        //If the node doesn't exist, return -1. If it exists, return the value.
        return prev.next==null?-1:prev.next.val;
        
    }
    
    public void remove(int key) {
        int index = idx(key);
        Listnodes prev = findElement(key, index);
        if (prev.next != null)
            prev.next = prev.next.next;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */